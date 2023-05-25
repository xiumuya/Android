package cn.itcast.chooseconstellation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnFocusChangeListener {
    ImageButton[] buttons = new ImageButton[2]; //声明一个长度为2的数组
    private TextView tv_choose,tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取2个按钮的引用
        buttons[0] = (ImageButton) findViewById(R.id.ib_img1);
        buttons[1] = (ImageButton) findViewById(R.id.ib_img2);
        tv_choose = (TextView) findViewById(R.id.tv_choose);
        tv_info= (TextView) findViewById(R.id.tv_info);
        tv_info.setText("请选择下列中您喜欢的星座");
        for (ImageButton button : buttons) {
            button.setOnFocusChangeListener(this); //添加监听器
        }
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.ib_img1:
                tv_choose.setText("您选中了狮子座");
                break;
            case R.id.ib_img2:
                tv_choose.setText("您选中了双子座");
                break;
        }
    }
}
