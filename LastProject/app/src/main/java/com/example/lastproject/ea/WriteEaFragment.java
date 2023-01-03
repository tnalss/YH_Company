package com.example.lastproject.ea;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lastproject.R;


public class WriteEaFragment extends Fragment {
    TextView tv_a;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_ea, container, false);
        tv_a = v.findViewById(R.id.tv_a);

        EaCodeVO vo = (EaCodeVO) getArguments().getSerializable("form");
        tv_a.setText(vo.getCode_value());

        return v;
    }
}