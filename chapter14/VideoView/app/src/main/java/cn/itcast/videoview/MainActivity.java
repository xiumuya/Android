package cn.itcast.videoview;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    private VideoView videoView;
    private MediaController controller;
    ImageView iv_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoview);
        iv_play = (ImageView) findViewById(R.id.bt_play);
        //拼出在资源文件夹下的视频文件路径String字符串
        String url = "android.resource://" + getPackageName() + "/" + R.raw.video;
        //字符串解析成Uri
        Uri uri = Uri.parse(url);
        //设置videoview的播放资源
        videoView.setVideoURI(uri);
        //VideoView绑定控制器
        controller = new MediaController(this);
        videoView.setMediaController(controller);
        iv_play.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_play:
                play();
                break;
        }
    }
    // 播放视频
    private void play() {
        if (videoView != null && videoView.isPlaying()) {
            iv_play.setImageResource(android.R.drawable.ic_media_play);
            videoView.stopPlayback();
            return;
        }
        videoView.start();
        iv_play.setImageResource(android.R.drawable.ic_media_pause);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                iv_play.setImageResource(android.R.drawable.ic_media_play);
            }
        });
    }
}
