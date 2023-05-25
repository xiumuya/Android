package cn.itcast.soundpool;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private SoundPool soundpool;
    private HashMap<Integer,Integer> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化ImageView控件，并为控件添加点击的监听事件
        ImageView iv_do = (ImageView) findViewById(R.id.iv_do);
        ImageView iv_re = (ImageView) findViewById(R.id.iv_re);
        ImageView iv_mi = (ImageView) findViewById(R.id.iv_mi);
        ImageView iv_fa = (ImageView) findViewById(R.id.iv_fa);
        ImageView iv_so = (ImageView) findViewById(R.id.iv_so);
        ImageView iv_la = (ImageView) findViewById(R.id.iv_la);
        ImageView iv_si = (ImageView) findViewById(R.id.iv_si);
        iv_do.setOnClickListener(this);
        iv_re.setOnClickListener(this);
        iv_mi.setOnClickListener(this);
        iv_fa.setOnClickListener(this);
        iv_so.setOnClickListener(this);
        iv_la.setOnClickListener(this);
        iv_si.setOnClickListener(this);
        //初始化SoundPool
        initSoundPool();
    }
    private void initSoundPool() {
        if(soundpool == null){
            //创建SoundPool对象
            soundpool = new SoundPool(7, AudioManager.STREAM_SYSTEM, 0);
        }
        //加载音频文件，并将文件存储到HashMap的集合中
        map.put(R.id.iv_do,soundpool.load(this,R.raw.music_do,1));
        map.put(R.id.iv_re,soundpool.load(this,R.raw.music_re,1));
        map.put(R.id.iv_mi,soundpool.load(this,R.raw.music_mi,1));
        map.put(R.id.iv_fa,soundpool.load(this,R.raw.music_fa,1));
        map.put(R.id.iv_so,soundpool.load(this,R.raw.music_so,1));
        map.put(R.id.iv_la,soundpool.load(this,R.raw.music_la,1));
        map.put(R.id.iv_si,soundpool.load(this,R.raw.music_si,1));
    }
    @Override
    public void onClick(View v) {
        play(v.getId());
    }
    private void play(int i){
        //播放音频
        soundpool.play(map.get(i),1.0f,1.0f,0,0,1.0f);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundpool != null) {
            soundpool.autoPause();
            soundpool.release();
            soundpool = null;
        }
    }
}

