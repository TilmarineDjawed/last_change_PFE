package com.example.pfe;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class mainadmin extends AppCompatActivity {


    CardView student;
    CardView teacher;
    CardView absenceprof;
    CardView absenceetudiant;
    CardView edtetudiant;
    CardView edtexam;
    CardView bulletin;
    CardView attestation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mainadmin);
        student = findViewById(R.id.student);
        teacher = findViewById(R.id.teacher);
        absenceprof = findViewById(R.id.absenceprof);
        absenceetudiant = findViewById(R.id.absenceetudiant);
        edtetudiant = findViewById(R.id.edtetudiant);
        edtexam = findViewById(R.id.edtexam);
        bulletin = findViewById(R.id.bulletins);
        attestation = findViewById(R.id.certificat);


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new studentadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new teacheradmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });
        absenceetudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new absenceetudiantadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });
        absenceprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new edtadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });

        edtetudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new edtadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });
        edtexam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new edtexamadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });

        bulletin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new gradesadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });

        attestation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new cetificatadmin();
                FragmentTransaction fragmenttansaction = getSupportFragmentManager().beginTransaction();
                fragmenttansaction.replace(R.id.mainadmin,fragment).commit();
            }
        });


    }
}