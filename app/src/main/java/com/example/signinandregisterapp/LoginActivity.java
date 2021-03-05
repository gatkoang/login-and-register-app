package com.example.signinandregisterapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseClass databaseClass;
    EditText logusername, logpassword;
    Button logregister, loglogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseClass = new DatabaseClass(this);

        logusername = (EditText)findViewById(R.id.et_lusername);
        logpassword = (EditText)findViewById(R.id.et_lpassword);

        loglogin = (Button)findViewById(R.id.btn_llogin);
        logregister = (Button)findViewById(R.id.btn_lregister);

        logregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        loglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = logusername.getText().toString();
                String password = logpassword.getText().toString();

                Boolean checklogin = databaseClass.CheckLogin(username, password);
                if(checklogin == true){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
