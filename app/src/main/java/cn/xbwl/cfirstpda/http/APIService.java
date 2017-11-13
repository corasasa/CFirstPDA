package cn.xbwl.cfirstpda.http;

import cn.xbwl.cfirstpda.entity.param.LoginParam;
import cn.xbwl.cfirstpda.entity.response.HttpResult;
import cn.xbwl.cfirstpda.entity.response.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 */

public interface APIService {
    @POST("pda/user/login")
    Observable<HttpResult<UserInfo>> login(@Body LoginParam loginParam);
}
