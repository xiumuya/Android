package cn.itcast.weather;
public class WeatherInfo {
    private String temp;      //温度
    private String weather;  //天气
    private String city;     //城市
    private String pm;       //pm值
    private String wind;    //风力
    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPm() {
        return pm;
    }
    public void setPm(String pm) {
        this.pm = pm;
    }
    public String getWind() {
        return wind;
    }
    public void setWind(String wind) {
        this.wind = wind;
    }
}
