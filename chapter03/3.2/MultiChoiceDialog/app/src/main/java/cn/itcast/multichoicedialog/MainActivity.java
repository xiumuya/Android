package cn.itcast.multichoicedialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private CharSequence[]  items = new CharSequence[]{"旅游", "美食", "看电影",
            "运动"};
    private boolean[] checkedItems = new boolean[]{false,true,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("请添加兴趣爱好！")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(items, checkedItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean
                                    isChecked){
                                checkedItems[which] = isChecked;
                            }
                        })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 0; i <= checkedItems.length - 1; i++) {
                            if (checkedItems[i]) {
                                stringBuffer.append(items[i]).append(" ");
                            }
                        }
                        if (stringBuffer != null) {
                            Toast.makeText(MainActivity.this, ""+ stringBuffer,
                                    Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                })
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
