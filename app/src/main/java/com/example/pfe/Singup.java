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

public class Singup extends AppCompatActivity {

    Button signup;
    ImageButton back;
    EditText emailEdit, passEdit, userEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_singup);

        back = findViewById(R.id.back);
        signup = findViewById(R.id.signup);
        emailEdit = findViewById(R.id.emailedit);
        passEdit = findViewById(R.id.passedit);
        userEdit = findViewById(R.id.useredit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Singup.this, Login.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString();
                String password = passEdit.getText().toString();
                String username = userEdit.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Singup.this, "Veuillez entrer votre nom d'utilisateur", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Singup.this, "Veuillez entrer votre adresse email", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(Singup.this, "Veuillez entrer une adresse email valide", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Singup.this, "Veuillez entrer votre mot de passe", Toast.LENGTH_SHORT).show();
                } else {
                    // Continue to the main activity if all fields are valid
                    Intent intent = new Intent(Singup.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
