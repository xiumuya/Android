package cn.itcast.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView tvCity, tvWeather, tvTemp, tvWind, tvPm;
    private ImageView ivIcon;
    private List<WeatherInfo> infoList; //天气预报数据集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoList = JsonParse.getInstance().getInfosFromJson(MainActivity.this);
        initView();
        getCityData("北京");//第一次进入应用时，显示北京的天气
    }
    private void initView() {
        tvCity = (TextView) findViewById(R.id.tv_city);
        tvWeather = (TextView) findViewById(R.id.tv_weather);
        tvTemp = (TextView) findViewById(R.id.tv_temp);
        tvWind = (TextView) findViewById(R.id.tv_wind);
        tvPm = (TextView) findViewById(R.id.tv_pm);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);
        findViewById(R.id.btn_sh).setOnClickListener(this);
        findViewById(R.id.btn_bj).setOnClickListener(this);
        findViewById(R.id.btn_gz).setOnClickListener(this);
    }
    /**
     * 设置界面数据
     */
    private void setData(WeatherInfo info) {
        if (info==null)return;
        tvCity.setText(info.getCity());
        tvWeather.setText(info.getWeather());
        tvTemp.setText(info.getTemp());
        tvWind.setText("风力："+info.getWind());
        tvPm.setText("PM："+info.getPm());
        if(("晴转多云").equals(info.getWeather())){
            ivIcon.setImageResource(R.drawable.cloud_sun);
        }else if(("多云").equals(info.getWeather())){
            ivIcon.setImageResource(R.drawable.clouds);
        }else if (("晴").equals(info.getWeather())){
            ivIcon.setImageResource(R.drawable.sun);
        }
    }
    /**
     * 根据城市获取对应的天气信息
     */
    private void getCityData(String city) {
        for (WeatherInfo info : infoList) {
            if(info.getCity().equals(city)){
                setData(info);
            }
        }
    }
    @Override
    public void onClick(View v) {  //按钮的点击事件
        switch (v.getId()) {
            case R.id.btn_sh: //上海按钮的点击事件
                getCityData("上海");
                break;
            case R.id.btn_bj: //北京按钮的点击事件
                getCityData("北京");
                break;
            case R.id.btn_gz: //广州按钮的点击事件
                getCityData("广州");
                break;
        }
    }
}
