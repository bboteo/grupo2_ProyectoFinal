package com.jr.jmproytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnLogginusuarios);

        this.click();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginActivity();
            }
        });
    }

    private void loginActivity(){
        Intent intent = new Intent(getApplicationContext(), MALogin.class);
        startActivity(intent);
    }


}