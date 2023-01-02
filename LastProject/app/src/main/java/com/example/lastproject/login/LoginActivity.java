package com.example.lastproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoginActivity extends AppCompatActivity {
    Button btn_login_login;
    EditText edt_login_id, edt_login_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        edt_login_pw = findViewById(R.id.edt_login_pw);
        edt_login_id = findViewById(R.id.edt_login_id);
        btn_login_login = findViewById(R.id.btn_login_login);
        ApiClient.setBASEURL("http://192.168.0.28/middle/");

        // 로그인 버튼
        btn_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams
                        ("emp_no", edt_login_id.getText()).setParams("emp_pw", edt_login_pw.getText()).sendPost("and", (isResult, data) -> {
                                    Log.d("TAG", "onClick: " + data);
                            if(isResult) {
                               testVO vo =  new Gson().fromJson(data, new TypeToken<testVO>(){}.getType() );
                                if( vo != null) {
                                  Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                 startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "아이디 비번 확인", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(LoginActivity.this, "연결 실패", Toast.LENGTH_SHORT).show();
                            }


                });
            }
        });

    }
}