package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;


import com.example.lastproject.databinding.ActivityMainBinding;
import com.example.lastproject.ea.EaFragment;


public class MainActivity extends AppCompatActivity {
        ActivityMainBinding binding;
        double waitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.btmNav.setOnItemSelectedListener(item -> {
            if ( item.getItemId()== R.id.btm_item1 ) {
                //홈
            }   else if ( item.getItemId() == R.id.btm_item2 ){
                //일정
            }   else if ( item.getItemId() == R.id.btm_item3 ){
                //출퇴근
            }   else if ( item.getItemId() == R.id.btm_item4 ){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new EaFragment()).commit();
                //전자결재
            }
            return true;
        });
        /*
        ApiClient.setBASEURL("http://localhost/middle/");
        로그인에서 해주겠지? */

    }
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed(); // 액티비티 종료
        }
    }
}