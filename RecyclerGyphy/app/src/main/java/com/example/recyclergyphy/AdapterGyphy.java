package com.example.recyclergyphy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterGyphy extends RecyclerView.Adapter<AdapterGyphy.ViewHolder> {

    private Context mContext;
    private List<Gyphy> mGyphyList;


    public AdapterGyphy(Context context, List<Gyphy> gyphyList) {
        mContext = context;
        mGyphyList = gyphyList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.gyphy_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Gyphy currentItem = mGyphyList.get(position);

        String url = currentItem.getUrl();

  //     Picasso.with(mContext).load(url).fit().centerInside().into(holder.mImageView);
        Glide.with(mContext).load(url).centerCrop().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mGyphyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    mGyphyList.remove(position);
                    notifyItemRemoved(position);
                }
            });

        }




    }


}
