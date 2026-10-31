package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class loginaos extends AppCompatActivity {
    private  Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginaos);

        TextView username = (TextView) findViewById(R.id.email);
        TextView password = (TextView) findViewById(R.id.password);
        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBTN);

        //admin and admin

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                /*if (username.getText().toString().equals("") && password.getText().toString().equals("")) {
                    Toast.makeText(loginaos.this, "Please fill all the missing field", Toast.LENGTH_SHORT).show();

                }else if (username.getText().toString().equals("llanes.navinbyron@ue.edu.ph") && password.getText().toString().equals("navin123")) {
                  */  //correct
                    Toast.makeText(loginaos.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),canteenchoose.class);
                    startActivity(intent);
                    finish();
               /* }else
                    //incorrect
                    Toast.makeText(loginaos.this, "Username or Password do not match", Toast.LENGTH_SHORT).show();
*/
            }
        });
    }
    public void openmain() {
        Intent intent = new Intent(this, canteenchoose.class);
        startActivity(intent);
    }
}