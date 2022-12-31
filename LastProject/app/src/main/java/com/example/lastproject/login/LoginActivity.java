package com.example.lastproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.lastproject.MainActivity;
import com.example.lastproject.R;

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
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}