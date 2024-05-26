package com.example.pfe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView Admin;
    CardView Parent;
    CardView Prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Admin = findViewById(R.id.contributeCard);
        Parent = findViewById(R.id.contributeCard3);
        Prof = findViewById(R.id.contributeCard2);

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("userType", "Admin");
                startActivity(intent);
            }
        });

        Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("userType", "Parent");
                startActivity(intent);
            }
        });

        Prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("userType", "Prof");
                startActivity(intent);
            }
        });
    }
}
