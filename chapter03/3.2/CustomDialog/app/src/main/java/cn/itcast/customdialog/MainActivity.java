package cn.itcast.customdialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        Button btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CommonDialog dialog = new CommonDialog(MainActivity.this);
                dialog.setTitle("提示");
                dialog.setMessage("您确定要删除信息？");
                dialog.setNegtive("取消");
                dialog.setPositive("确定");
                dialog.setOnClickBottomListener(new CommonDialog.
                        OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() { //确定按钮的点击事件
                        dialog.dismiss();
                    }
                    @Override
                    public void onNegtiveClick() { //取消按钮的点击事件
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
