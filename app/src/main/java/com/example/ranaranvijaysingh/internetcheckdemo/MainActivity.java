package com.example.ranaranvijaysingh.internetcheckdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(MyApplication.isInternetAvailable
                        ? getResources().getColor(R.color.green)
                        : getResources().getColor(R.color.red));
                textView.setText(MyApplication.isInternetAvailable
                        ? "Click to refresh. Internet is available."
                        : "Click to refresh. Internet is not available."
                );
            }
        });
    }
}
