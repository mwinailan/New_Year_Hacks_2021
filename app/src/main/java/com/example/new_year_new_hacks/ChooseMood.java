package com.example.new_year_new_hacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseMood extends AppCompatActivity {
    private Button anger;
    private Button sadness, anxiety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mood);
        anger = findViewById(R.id.buttonAnger);
        anger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseMood.this, AngerGif.class));
            }
        });
        sadness = findViewById(R.id.buttonSadness);
        sadness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseMood.this, SadnessGif.class));
            }
        });
        anxiety = findViewById(R.id.buttonAnxiety);
        anxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseMood.this, AnxietyGif.class));
            }
        });
    }
}