package cn.itcast.activitylifecycle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("cn.itcast.action_START_ACTIVITY");
                startActivity(intent);
            }
        });
        Log.e("MainActivity","调用onCreate()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "调用onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "调用onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "调用onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "调用onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "调用onDestroy()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "调用onRestart()");
    }
}
