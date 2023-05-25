package cn.itcast. pressabkey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, View.OnKeyListener {
    ImageButton[] buttons = new ImageButton[2]; //声明一个长度为2的数组
    private TextView tv_choose, tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取2个按钮的引用
        buttons[0] = (ImageButton) findViewById(R.id.ib_img1);
        buttons[1] = (ImageButton) findViewById(R.id.ib_img2);
        tv_choose = (TextView) findViewById(R.id.tv_choose);
        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("请使用键盘中的A、B键控制下方两个按钮");
        for (ImageButton button : buttons) {
            button.setOnClickListener(this); //添加点击事件监听器
            button.setOnKeyListener(this);   //添加键盘按键监听器
        }
    }
    @Override
    public void onClick(View v) {  //实现了OnClickListener接口中的方法
        switch (v.getId()) {
            case R.id.ib_img1:
                tv_choose.setText("您点击了按钮A");
                break;
            case R.id.ib_img2:
                tv_choose.setText("您点击了按钮B");
                break;
        }
    }
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
        switch (keyCode) {                    //判断键盘码
            case KeyEvent.KEYCODE_A:         //按键A
                buttons[0].performClick();  //模拟按钮的单击
                buttons[0].requestFocus();  //使按钮获取焦点
                break;
            case KeyEvent.KEYCODE_B:         //按键B
                buttons[1].performClick();  //模拟按钮的单击
                buttons[1].requestFocus();  //使按钮获取焦点
                break;
        }
        return false;
    }
}
