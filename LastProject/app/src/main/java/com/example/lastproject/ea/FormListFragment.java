package com.example.lastproject.ea;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastproject.R;


public class FormListFragment extends Fragment {
    RecyclerView recv_form;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_list, container, false);
        recv_form = v.findViewById(R.id.recv_form);



        return v;
    }
}