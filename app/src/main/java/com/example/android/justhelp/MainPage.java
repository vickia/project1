package com.example.android.justhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void btnRequest (View view) {
        startActivity(new Intent(this,Request.class));
    }

    public void btnDonate (View view){
        startActivity(new Intent(this,Donate.class));
    }

}
