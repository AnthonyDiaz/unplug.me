package com.unplugme.view.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.unplugme.R;

public class LoginActivity extends AppCompatActivity {
    TextView login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = (TextView) findViewById(R.id.login_button_text);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProfilerActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        }
    }

