package com.example.udacityadvanced;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.udacityadvanced.data.AndriodImageAssets;

public class MasterListfragment extends Fragment {

    OnImageClickListner mCallback;

    public interface OnImageClickListner{
        void onImageSelected(int position);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    try {
        mCallback=(OnImageClickListner) context;

    }catch (ClassCastException e){
        throw new ClassCastException(context.toString()+"must implement OnImageClickListner");
    }


    }

    public MasterListfragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View rootView=inflater.inflate(R.layout.masterlist_fragment,container,false);

        GridView gridView=(GridView) rootView.findViewById(R.id.image_grid_view);

        MasterlistAdapter mAdapter=new MasterlistAdapter(getContext(), AndriodImageAssets.getAll());

        gridView.setAdapter((ListAdapter) mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCallback.onImageSelected(position);
            }
        });


        return rootView;
    }
}
