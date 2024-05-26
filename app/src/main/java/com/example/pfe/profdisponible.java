package com.example.pfe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class profdisponible extends Fragment {

    ImageButton back;
    CardView math;
    CardView science;
    CardView french;
    CardView english;
    CardView arabic;
    CardView art;
    CardView islamic;
    CardView histgeo;
    CardView civique;

    TextView mathDisponible;
    TextView scienceDisponible;
    TextView frenchDisponible;
    TextView englishDisponible;
    TextView arabicDisponible;
    TextView artDisponible;
    TextView islamicDisponible;
    TextView histgeoDisponible;
    TextView civiqueDisponible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profdisponible, container, false);

        // Find the back button after inflating the layout
        back = view.findViewById(R.id.back);
        math = view.findViewById(R.id.math);
        science = view.findViewById(R.id.science);
        french = view.findViewById(R.id.french);
        english = view.findViewById(R.id.english);
        arabic = view.findViewById(R.id.arabic);
        art = view.findViewById(R.id.art);
        islamic = view.findViewById(R.id.islamic);
        histgeo = view.findViewById(R.id.histgeo);
        civique = view.findViewById(R.id.civique);

        // Find the TextViews for professor availability
        mathDisponible = view.findViewById(R.id.mathDisponible);
        scienceDisponible = view.findViewById(R.id.scienceDisponible);
        frenchDisponible = view.findViewById(R.id.frenchDisponible);
        englishDisponible = view.findViewById(R.id.englishDisponible);
        arabicDisponible = view.findViewById(R.id.arabicDisponible);
        artDisponible = view.findViewById(R.id.artDisponible);
        islamicDisponible = view.findViewById(R.id.islamicDisponible);
        histgeoDisponible = view.findViewById(R.id.histgeoDisponible);
        civiqueDisponible = view.findViewById(R.id.civiqueDisponible);

        // Set an onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use getActivity() as the context for the Intent
                Intent intent = new Intent(getActivity(), mainparent.class);
                startActivity(intent);
            }
        });

        // Set click listeners for each CardView
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur de Mathématiques", "Le professeur de mathématiques est disponible le lundi de 10h à 12h.", mathDisponible);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur de Science", "Le professeur de science est disponible le mardi de 11h à 13h.", scienceDisponible);
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur de Français", "Le professeur de français est disponible le mercredi de 12h à 14h.", frenchDisponible);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur d'Anglais", "Le professeur d'anglais est disponible le jeudi de 13h à 15h.", englishDisponible);
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur d'Arabe", "Le professeur d'arabe est disponible le vendredi de 14h à 16h.", arabicDisponible);
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur d'Arts", "Le professeur d'arts est disponible le samedi de 15h à 17h.", artDisponible);
            }
        });

        islamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur d'Études Islamiques", "Le professeur d'études islamiques est disponible le dimanche de 16h à 18h.", islamicDisponible);
            }
        });

        histgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur d'Histoire et Géographie", "Le professeur d'histoire et géographie est disponible le lundi de 17h à 19h.", histgeoDisponible);
            }
        });

        civique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisponibleDialog("Disponibilité du Professeur d'Éducation Civique", "Le professeur d'éducation civique est disponible le mardi de 18h à 20h.", civiqueDisponible);
            }
        });

        return view;
    }

    private void showDisponibleDialog(String title, String message, final TextView disponibleTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                disponibleTextView.setText(message);  // Update the TextView with the new availability description
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
