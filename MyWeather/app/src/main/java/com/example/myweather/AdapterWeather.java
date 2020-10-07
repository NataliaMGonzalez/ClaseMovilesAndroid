package com.example.myweather;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterWeather extends RecyclerView.Adapter<AdapterWeather.ViewHolder> {

    private Context mContext;
    private List<Weather> mWeatherList;

    public  AdapterWeather(Context context, List<Weather> weatherList){
    mContext = context;
    mWeatherList = weatherList;
    }

    @NonNull
    @Override
    public AdapterWeather.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWeather.ViewHolder holder, int position) {
        Weather currentItem = mWeatherList.get(position);

        String weatherURL = currentItem.getWeatherURL();
        String forecastDay = currentItem.getForecastDay();
        String forecastDesc = currentItem.getForecastDesc();
        String forecastMinMax = currentItem.getForecastMinMax();

        holder.mForecastDay.setText(forecastDay);
        holder.mForecastDesc.setText(forecastDesc);
        holder.mForecastMinMax.setText(forecastMinMax);

        // Picasso allows images to be assigned dynamically
        Picasso.with(mContext).load(weatherURL).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mForecastDay;
        public TextView mForecastDesc;
        public TextView mForecastMinMax;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mForecastDay = itemView.findViewById(R.id.txt_forecastDay);
            mForecastDesc = itemView.findViewById(R.id.txt_forecastDesc);
            mForecastMinMax = itemView.findViewById(R.id.txt_forecastMinMax);
        }
    }
}
