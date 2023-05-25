package cn.itcast.clicklistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*
*setOnClickListener的第一种用法
*/
/*public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      //设置MainActivity对应的布局文件
        button= (Button) findViewById(R.id.button); //获取界面上的按钮控件
        button.setOnClickListener(this);              //注册监听器
    }
    @Override
    public void onClick(View v) {   //实现点击事件的监听方法
        if (v==button){                //判断点击的控件是否是button
            Toast.makeText(MainActivity.this,"您点击了按钮",Toast.LENGTH_SHORT)
                    .show();
        }
    }
}*/


/*
 *setOnClickListener的第二种用法
 */
/*
public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       //设置Activity对应的布局文件
        button = (Button) findViewById(R.id.button); //获取界面上的按钮控件
        //通过匿名内部类来实现OnClickListener接口
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "您点击了按钮",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
*/

public class MainActivity extends AppCompatActivity implements
        View.OnLongClickListener {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       //设置Activity对应的布局文件
        button = (Button) findViewById(R.id.button); //获取界面上的按钮控件
        button.setOnLongClickListener(this);          //注册监听
    }
    @Override
    public boolean onLongClick(View v) {  //实现OnLongClickListener接口中的方法
        if (v == button) {                   //判断长时间按下的控件是否是button
            Toast.makeText(MainActivity.this, "您长时间按下了按钮",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}


