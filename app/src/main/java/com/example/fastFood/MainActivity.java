package com.example.fastFood;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseClass databaseClass;
    Button btnregister, btnlogin;
    EditText btnusername, btnpassword, btnconfirmpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //iniatialization of variable

        databaseClass = new DatabaseClass(this);
        btnusername = findViewById(R.id.et_username);
        btnpassword = findViewById(R.id.et_password);
        btnconfirmpassword = findViewById(R.id.et_cpassword);
        btnregister = findViewById(R.id.btn_register);
        btnlogin = findViewById(R.id.btn_login);

        //click listeneer in details.

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = MainActivity.this.btnusername.getText().toString();
                String password = btnpassword.getText().toString();
                String confirm_password = btnconfirmpassword.getText().toString();

                if(username.equals("") || password.equals("") || confirm_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirm_password)){
                        Boolean checkRegistration = databaseClass.CheckUsername(username);
                        if(checkRegistration == true){
                            Boolean insert = databaseClass.Insert(username, password);
                            if(insert == true){
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                MainActivity.this.btnusername.setText("");
                                btnpassword.setText("");
                                btnconfirmpassword.setText("");
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}