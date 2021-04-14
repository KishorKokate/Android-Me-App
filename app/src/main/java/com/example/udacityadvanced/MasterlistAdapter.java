package com.example.udacityadvanced;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class MasterlistAdapter extends BaseAdapter {
   private Context mContext;
   private List<Integer> mimageIds;

    public MasterlistAdapter(Context mContext, List<Integer> mimageIds) {
        this.mContext = mContext;
        this.mimageIds = mimageIds;
    }



    @Override
    public int getCount() {
        return mimageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ImageView imageView;
        if (view==null){
            imageView=new ImageView(mContext);


            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else {
            imageView=(ImageView)view;
        }

        imageView.setImageResource(mimageIds.get(i));
        return imageView;
    }
}
