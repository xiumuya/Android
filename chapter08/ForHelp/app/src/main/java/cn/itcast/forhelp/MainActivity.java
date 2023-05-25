package cn.itcast.forhelp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        receiver = new MyBroadcastReceiver(); //实例化广播接收者
        String action = "Help_Stitch";
        IntentFilter intentFilter = new IntentFilter(action);
        registerReceiver(receiver,intentFilter); //注册广播
        Button btn_help= (Button) findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //定义广播的事件类型
                intent.setAction("Help_Stitch");
                sendBroadcast(intent);//发送广播
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
