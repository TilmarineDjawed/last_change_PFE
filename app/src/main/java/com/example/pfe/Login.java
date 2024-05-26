package com.example.pfe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    ImageButton back;
    Button login;
    TextView signup;
    EditText emailEdit, passEdit;
    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        back = findViewById(R.id.back);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        emailEdit = findViewById(R.id.emailedit);
        passEdit = findViewById(R.id.passedit);

        // Get the userType from the intent
        userType = getIntent().getStringExtra("userType");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Singup.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString();
                String password = passEdit.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Veuillez remplir les champs Email et Mot de passe", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(Login.this, "Veuillez entrer une adresse email valide", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = null;
                    if (userType != null) {
                        switch (userType) {
                            case "Admin":
                                intent = new Intent(Login.this, mainadmin.class);
                                break;
                            case "Parent":
                                intent = new Intent(Login.this, choixprofil.class);
                                break;
                            case "Prof":
                                intent = new Intent(Login.this, mainprof.class);
                                break;
                        }
                        if (intent != null) {
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
