package cn.itcast.singlechoicedialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView textView;
    private int[] textSizeArr = {10,20,25,30,40};
    int textSize = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置Button监听事件
        findViewById(R.id.bt).setOnClickListener(this);
        textView = (TextView) findViewById(R.id.tv);
    }
    @Override
    public void onClick(View v) {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("设置字体大小")           //设置标题
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(new String[]{"小号", "默认", "中号", "大号",
                        "超大"}, textSize,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        textSize = which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //为TextView设置在单选对话框中选择的字体大小
                        textView.setTextSize(textSizeArr[textSize]);
                        dialog.dismiss(); //关闭对话框
                    }
                })//添加“确定”按钮
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog = builder.create();
        dialog.show();
    }
}
