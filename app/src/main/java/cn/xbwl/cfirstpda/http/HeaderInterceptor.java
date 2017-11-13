package cn.xbwl.cfirstpda.http;

import com.google.gson.Gson;

import java.io.IOException;

import cn.xbwl.cfirstpda.constant.Constant;
import cn.xbwl.cfirstpda.entity.param.LoginParam;
import cn.xbwl.cfirstpda.entity.response.LoginResult;
import cn.xbwl.cfirstpda.entity.response.UserInfo;
import cn.xbwl.cfirstpda.utils.SPUtil;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by chenjinglan on 2017/10/27.
 * email:13925024285@163.com
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取登陆成功，返回的用户信息
        UserInfo userInfo = SPUtil.getUserInfo();
        Request request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Encoding", "*")
                .addHeader("token", userInfo == null ? "" : userInfo.getToken())
                .build();

        //如需判断token过时，可在此判断
        Response response = chain.proceed(request);
        if (response.code() == 401) {
            Request oldRequest = response.request();
            //重新登录
            LoginParam param = new LoginParam();
            param.setJobnum(userInfo.getAccount());
            param.setPassword(userInfo.getPwd());
            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json; charset=UTF-8"), new Gson().toJson(param));
            Request requestLogin = request.newBuilder().removeHeader("token").url(Constant.BASE_URL
                    + "pda/user/login").post(requestBody).build();
            Response responseLogin = chain.proceed(requestLogin);
            if (responseLogin.isSuccessful()) {
                LoginResult loginResult = new Gson().fromJson(responseLogin.body() == null ?
                        "" : responseLogin.body().toString(), LoginResult.class);
                if (loginResult != null) {
                    LoginResult.DataBean userInfoNew = loginResult.getData();
                    if (userInfoNew != null) {
                        userInfo.setToken(userInfoNew.getToken());
                        SPUtil.putUserInfo(userInfo);
                        Request newRequest = oldRequest.newBuilder().removeHeader("token")
                                .addHeader("token", userInfoNew.getToken()).build();
                        return chain.proceed(newRequest);
                    }
                }

            }
        }
        return chain.proceed(request);
    }
}
