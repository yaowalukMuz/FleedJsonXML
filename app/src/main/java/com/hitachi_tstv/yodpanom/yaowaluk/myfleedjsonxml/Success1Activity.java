package com.hitachi_tstv.yodpanom.yaowaluk.myfleedjsonxml;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Success1Activity extends AppCompatActivity {

    private String _username;
    private String _password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        readInboundIntent();
        
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void readInboundIntent() {
        _username = getIntent().getStringExtra("USERNAME");
        _password = getIntent().getStringExtra("PASSWORD");
        String msg = String.format("username: %s\npassword: %s",_username,_password);
        Toast.makeText(Success1Activity.this, msg, Toast.LENGTH_SHORT).show();

    }

}
