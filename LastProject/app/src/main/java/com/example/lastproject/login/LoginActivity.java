package com.example.lastproject.login;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.google.gson.Gson;

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

        ApiClient.setBASEURL("http://192.168.0.2/middle/");

        // 로그인 버튼
        btn_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("emp_no", edt_login_id.getText()).setParams
                        ("emp_pw", edt_login_pw.getText()).sendPost("login", (isResult, data) -> {
                    LoginVO vo = new Gson().fromJson(data, LoginVO.class);

                    if (vo != null && isResult) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("loginInfo", vo);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }

                });
            }

        });
        /* id 버튼 비활성화 */
        btn_login_login.setEnabled(false);
        edt_login_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edt_login_id.length() > 0 && edt_login_pw.length() > 0) {
                    btn_login_login.setEnabled(true);
                    btn_login_login.setBackgroundColor(Color.parseColor("#71F443"));
                } else {
                    btn_login_login.setEnabled(false);
                    btn_login_login.setBackgroundColor(Color.parseColor("#D2D2D1"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* pw 버튼 비활성화 */
        edt_login_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edt_login_pw.length() > 0 && edt_login_pw.length() > 0) {
                    btn_login_login.setEnabled(true);
                    btn_login_login.setBackgroundColor(Color.parseColor("#71F443"));
                } else {
                    btn_login_login.setEnabled(false);
                    btn_login_login.setBackgroundColor(Color.parseColor("#D2D2D1"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}