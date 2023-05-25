package cn.itcast.touchevent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyButton button=new MyButton(this); //创建一个自定义的Button对象
        button.setText("Hello"); //设置Button控件的文本
        button.setTextSize(20);  //设置Button控件的文本大小
        button.setAllCaps(false);//设置Button控件原样输出文本
        setContentView(button);  //将按钮设置到界面上
    }
    @SuppressLint("AppCompatCustomView")
    class MyButton extends Button {  //自定义一个Button控件
        public MyButton(Context context) {
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) { //重写触摸事件的处理方法
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN://按下
                    Toast.makeText(MainActivity.this, "按钮被按下",
                            Toast.LENGTH_SHORT).show();
                    break;
                case MotionEvent.ACTION_UP:  //弹起
                    Toast.makeText(MainActivity.this, "按钮被弹起",
                            Toast.LENGTH_SHORT).show();
                    break;
                case MotionEvent.ACTION_MOVE://移动
                    Toast.makeText(MainActivity.this, "在按钮上进行移动",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            return super.onTouchEvent(event);
        }
    }
}
