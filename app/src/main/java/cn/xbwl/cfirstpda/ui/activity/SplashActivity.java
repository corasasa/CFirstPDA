package cn.xbwl.cfirstpda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.xbwl.cfirstpda.R;
import cn.xbwl.cfirstpda.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.tv_second)
    TextView tvSecond;
    private CountDownTimer mCountDownTimer;
    private static long COUNT_TIME = 1000;//总倒计时
    private static long INTEVAL_TIME = 1000;//间隔

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mCountDownTimer = new CountDownTimer(COUNT_TIME, INTEVAL_TIME) {

            @Override
            public void onTick(long millisUntilFinished) {
                tvSecond.setText(millisUntilFinished / INTEVAL_TIME + "秒");
            }

            @Override
            public void onFinish() {
                tvSecond.setText(0 + "秒");
                mCountDownTimer.cancel();
                mCountDownTimer = null;
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mCountDownTimer != null) {
            mCountDownTimer.start();
        }
    }
}
