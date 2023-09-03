package com.bdtopcoder.smart_slider;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/*
        Copyright by BdTopCoder
        Website : https://www.bdtopcoder.xyz/
        Name : Atikul Islam
        Note : Do Not Copy Any java Class. You can use this library full free.
        If You Copy It will strike
 */

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    List<SliderItem> sliderItems;
    ViewPager2 viewPager2;
    static onClick onClick;
    int SlideTimes;



    public SliderAdapter(com.bdtopcoder.smart_slider.onClick onClick) {
        SliderAdapter.onClick = onClick;
    }

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2, int slideTimes) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
        SlideTimes = slideTimes;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        SliderItem mySliderItem = sliderItems.get(position);
        holder.setImage(sliderItems.get(position));
        if (position == sliderItems.size() - 2){
            viewPager2.post(runnable);
        }

        holder.itemView.setOnClickListener(v -> {
            /*itemView.setOnClickListener(v ->
                    onClick.onCLick(getAdapterPosition(),v
                    ));*/

            onClick.onCLick(position,mySliderItem.getTitle(),v);
        });

    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }


    public class SliderViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        Handler sliderHandler = new Handler();
        SliderItem sliderItem;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);

            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setOffscreenPageLimit(3);
            viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer((page, position) -> {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            });

            viewPager2.setPageTransformer(compositePageTransformer);
            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    sliderHandler.removeCallbacks(sliderRunnable);
                    if (SlideTimes == 0){
                        sliderHandler.postDelayed(sliderRunnable,5000);
                    } else {
                        sliderHandler.postDelayed(sliderRunnable,SlideTimes);
                    }
                }
            });


        } // ===================

        void setImage(SliderItem sliderItem){
            if (sliderItem.getImages() != 0 ){
                imageView.setImageResource(sliderItem.getImages());
            } else if (!sliderItem.getImagesUrl().isEmpty()){
                new LoadImageTask().execute(sliderItem.getImagesUrl());
            }

        } // setImage End here ===============

        private class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
            @Override
            protected Bitmap doInBackground(String... urls) {
                String imageUrl = urls[0];
                Bitmap bitmap = null;
                try {
                    URL url = new URL(imageUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                if (result != null) {
                    imageView.setImageBitmap(result);
                }
            }
        }

    }  // SliderViewHolder End Here ====


    Runnable runnable = new Runnable() {
        @SuppressLint("NotifyDataSetChanged")
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };


    Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };


} // SliderAdapter End Here =============
