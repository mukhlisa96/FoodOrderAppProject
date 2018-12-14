package com.example.andstudio102.myapplication;
//foods-1b3b5
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button signUpBtn, signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn=(Button)findViewById(R.id.btn_sign_in);
        signUpBtn=(Button)findViewById(R.id.btn_sign_up);


        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(MainActivity.this, Sign_in.class);
                startActivity(signIn);

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(MainActivity.this, Sign_up.class);
                startActivity(signUp);
            }
        });


    }
}
