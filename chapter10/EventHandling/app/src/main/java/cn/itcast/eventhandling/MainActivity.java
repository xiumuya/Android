package cn.itcast.eventhandling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//设置页面布局
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//点击了后退键
            Toast.makeText(this, "点击了后退键", Toast.LENGTH_LONG).show();
            return true; // 屏蔽后退键
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {     //点击了音量增加键
            Toast.makeText(this, "音量增加", Toast.LENGTH_LONG).show();// 提示音量增加
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
