package com.example.pfe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class choixprofil extends AppCompatActivity {
    ImageButton back;
    CardView profilcard;
    CardView profilcard2;
    CardView profilcard3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choixprofil);
        back = findViewById(R.id.back);
        profilcard = findViewById(R.id.profilcard);
        profilcard2 = findViewById(R.id.profilcard2);
        profilcard3 = findViewById(R.id.profilcard3);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choixprofil.this, Login.class);
                startActivity(intent);
            }
        });

        profilcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choixprofil.this, mainparent.class);
                startActivity(intent);
            }
        });

        profilcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choixprofil.this, mainparent.class);
                startActivity(intent);
            }
        });

        profilcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choixprofil.this, mainparent.class);
                startActivity(intent);
            }
        });




    }
}