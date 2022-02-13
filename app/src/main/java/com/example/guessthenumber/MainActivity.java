package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button main_game_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_game_button = (Button) findViewById(R.id.button3);
        main_game_button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, checking.class);
            startActivity(intent);
        });
    }
}