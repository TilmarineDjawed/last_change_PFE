package com.example.pfe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class mainparent extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    CardView Grade;
    CardView Homework;
    CardView Remarque;
    CardView profdisponible;
    CardView edt;
    CardView absence;
    CardView attestation;
    CardView convocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainparent);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout2);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Grade = findViewById(R.id.grade);
        Homework = findViewById(R.id.homework);
        Remarque = findViewById(R.id.remarque);
        profdisponible = findViewById(R.id.profdisponible);
        edt = findViewById(R.id.edt);
        absence = findViewById(R.id.absence);
        attestation = findViewById(R.id.attestation);
        convocation = findViewById(R.id.convocation);

        Grade.setOnClickListener(v -> openFragment(new grades()));
        Homework.setOnClickListener(v -> openFragment(new homework()));
        absence.setOnClickListener(v -> openFragment(new absence()));
        Remarque.setOnClickListener(v -> openFragment(new remarque()));
        profdisponible.setOnClickListener(v -> openFragment(new profdisponible()));
        edt.setOnClickListener(v -> openFragment(new edt()));
        attestation.setOnClickListener(v -> openFragment(new certificat()));
        convocation.setOnClickListener(v -> openFragment(new convocation()));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

         if (id == R.id.nav_changerprofil) {
            Intent intent = new Intent(this, choixprofil.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.message) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"example@gmail.com"}); // optional, if you want to prefill the recipient
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
        } }else if (id == R.id.nav_logout) {
            showLogoutConfirmationDialog();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void showLogoutConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with logout
                        Intent intent = new Intent(mainparent.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish(); // close the current activity
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.drawer_layout2, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
