package com.example.lastproject.attend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lastproject.R;

public class AttendFragment extends Fragment {

    Button on, off;
    RecyclerView recv_attend_record;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attend_main, container, false);

        /*리사이클러뷰*/
        recv_attend_record = v.findViewById(R.id.recv_attend_record);




        return v;
    }
}