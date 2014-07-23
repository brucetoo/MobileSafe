package com.itheima.mobilesafe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bruce
 * Data 2014/7/21
 * Time 18:53.
 */
public class LostFindActivity extends Activity {

    private SharedPreferences sp;
    private TextView tv_phone;
    private ImageView iv_lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //判断是否运行过设置向导
    sp = getSharedPreferences("config",MODE_PRIVATE);
    //如果设置过向导，留在此页面
    if(sp.getBoolean("configed",false)){
        setContentView(R.layout.activity_lost_find);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        iv_lock = (ImageView) findViewById(R.id.iv_lock);
        //安全电话设置成功
        if(!TextUtils.isEmpty(sp.getString("phone",""))){
            tv_phone.setText(sp.getString("phone",""));
            iv_lock.setBackgroundResource(R.drawable.lock);
        }

    }else{//没有设置过，跳到设置向导
        iv_lock.setBackgroundResource(R.drawable.lock);
        Intent intent = new Intent(LostFindActivity.this,Setup1Activity.class);
        startActivity(intent);
        this.finish();
    }

}

    /**
     * 重新进入手机防盗设置向导页面
     * @param view
     */
    public void reEnterSetup(View view){
        Intent intent = new Intent(this,Setup1Activity.class);
        startActivity(intent);
        //关闭当前页面
        finish();
    }
}
