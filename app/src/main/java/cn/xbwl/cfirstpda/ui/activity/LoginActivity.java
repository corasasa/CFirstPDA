package cn.xbwl.cfirstpda.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.xbwl.cfirstpda.R;
import cn.xbwl.cfirstpda.base.BaseActivity;
import cn.xbwl.cfirstpda.entity.param.LoginParam;
import cn.xbwl.cfirstpda.entity.response.HttpResult;
import cn.xbwl.cfirstpda.entity.response.UserInfo;
import cn.xbwl.cfirstpda.http.BaseObserver;
import cn.xbwl.cfirstpda.http.RetrofitManager;
import cn.xbwl.cfirstpda.utils.IntentUtil;
import cn.xbwl.cfirstpda.utils.SPUtil;
import cn.xbwl.cfirstpda.utils.ToastUtil;
import io.reactivex.Observable;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_count)
    EditText etCount;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.sp_linkIp)
    Spinner spLinkIp;
    @BindView(R.id.btn_setting)
    Button btnSetting;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_version_name)
    TextView tvVersionName;
    private RetrofitManager mRetrofitManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        mRetrofitManager = RetrofitManager.getInstance();
    }

    private void initView() {
        UserInfo userInfo = SPUtil.getUserInfo();
        if (userInfo != null) {
            etCount.setText(userInfo.getAccount());
            etPwd.setText(userInfo.getPwd());
        }
    }

    @OnClick({R.id.btn_setting, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_setting:
                break;
            case R.id.btn_login:
                goLogin();
                break;
        }
    }

    private void goLogin() {
        String count = etCount.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(count)){
            ToastUtil.showString(this,"账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            ToastUtil.showString(this,"密码不能为空");
            return;
        }
        LoginParam param = new LoginParam();
        param.setJobnum(count);
        param.setPassword(pwd);
        goToLogin(param);
    }

    private void goToLogin(final LoginParam param) {
        Observable<HttpResult<UserInfo>> loginObservable = mRetrofitManager.getService().login(param);
        beginHttpSuscriber(loginObservable)
                .compose(this.<UserInfo>bindToLifecycle())
                .subscribe(new BaseObserver<UserInfo>(LoginActivity.this, "正在登陆...", true) {
                    @Override
                    public void onSuccess(UserInfo userInfo) {
                        if (userInfo != null) {
                            userInfo.setAccount(param.getJobnum());
                            userInfo.setPwd(param.getPassword());
                            SPUtil.putUserInfo(userInfo);
                            IntentUtil.startActivity(LoginActivity.this, MainActivity.class);
                        }
                    }

                    @Override
                    public void onFail(String msg) {
                        super.onFail(msg);
                        ToastUtil.showString(LoginActivity.this, "登陆失败" + msg);
                    }
                });
    }
}
