package com.example.lastproject.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastproject.R;
import com.example.lastproject.databinding.FragmentHomeBinding;

import java.util.Calendar;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar
                .Builder(container, R.id.calendarView).range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();


        binding.menu11.setClipToOutline(true);
        binding.menu12.setClipToOutline(true);
        binding.menu13.setClipToOutline(true);
        binding.menu21.setClipToOutline(true);
        binding.menu22.setClipToOutline(true);
        binding.menu23.setClipToOutline(true);
        //visibility 속성을 이용해서 일반회원의 경우 메뉴 몇 개를 숨겨야함..


        View v = binding.getRoot();
        binding.menu11.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu1_1){
            //사원관리
        } else if ( v.getId() == R.id.menu1_2){
            //문서관리
        } else if ( v.getId() == R.id.menu1_3){
            //게시판
        } else if ( v.getId() == R.id.menu2_1){
            //지점관리
        } else if ( v.getId() == R.id.menu2_2){
            // 일정관리
        } else if ( v.getId() == R.id.menu2_3){
            // 전자결재
        }
    }
}