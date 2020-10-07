package com.example.myweather;

public class Weather {
    private String forecastDesc;
    private String weatherURL;
    private String forecastDay;
    private String forecastMinMax;

    public Weather(String forecastDesc, String weatherURL, String forecastDay, String forecastMinMax) {
        this.forecastDesc = forecastDesc;
        this.weatherURL = weatherURL;
        this.forecastDay = forecastDay;
        this.forecastMinMax = forecastMinMax;
    }

    public String getWeatherURL() {
        return weatherURL;
    }

    public void setWeatherURL(String weatherURL) {
        this.weatherURL = weatherURL;
    }

    public String getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(String forecastDay) {
        this.forecastDay = forecastDay;
    }

    public String getForecastDesc() {
        return forecastDesc;
    }

    public void setForecastDesc(String forecastDesc) {
        this.forecastDesc = forecastDesc;
    }

    public String getForecastMinMax() {
        return forecastMinMax;
    }

    public void setForecastMinMax(String forecastMinMax) {
        this.forecastMinMax = forecastMinMax;
    }




}
