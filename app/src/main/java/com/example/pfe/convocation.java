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

public class convocation extends Fragment {

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

    TextView mathConvocation;
    TextView scienceConvocation;
    TextView frenchConvocation;
    TextView englishConvocation;
    TextView arabicConvocation;
    TextView artConvocation;
    TextView islamicConvocation;
    TextView histgeoConvocation;
    TextView civiqueConvocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convocation, container, false);

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

        // Find the TextViews for convocations
        mathConvocation = view.findViewById(R.id.mathConvocation);
        scienceConvocation = view.findViewById(R.id.scienceConvocation);
        frenchConvocation = view.findViewById(R.id.frenchConvocation);
        englishConvocation = view.findViewById(R.id.englishConvocation);
        arabicConvocation = view.findViewById(R.id.arabicConvocation);
        artConvocation = view.findViewById(R.id.artConvocation);
        islamicConvocation = view.findViewById(R.id.islamicConvocation);
        histgeoConvocation = view.findViewById(R.id.histgeoConvocation);
        civiqueConvocation = view.findViewById(R.id.civiqueConvocation);

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
                showConvocationDialog("Convocation pour Mathématiques", "Vous êtes convoqué pour une réunion sur les concepts de base le 05/06/2024 à 10h.", mathConvocation);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Science", "Vous êtes convoqué pour une discussion sur les projets de laboratoire le 06/06/2024 à 11h.", scienceConvocation);
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Français", "Vous êtes convoqué pour une séance de correction de vos compositions le 07/06/2024 à 12h.", frenchConvocation);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Anglais", "Vous êtes convoqué pour une évaluation de votre prononciation le 08/06/2024 à 13h.", englishConvocation);
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Arabe", "Vous êtes convoqué pour un atelier d'amélioration de l'écriture le 09/06/2024 à 14h.", arabicConvocation);
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Arts", "Vous êtes convoqué pour une session de présentation de vos projets artistiques le 10/06/2024 à 15h.", artConvocation);
            }
        });

        islamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Études Islamiques", "Vous êtes convoqué pour une discussion approfondie sur les textes sacrés le 11/06/2024 à 16h.", islamicConvocation);
            }
        });

        histgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Histoire et Géographie", "Vous êtes convoqué pour une réunion de révision des projets de cartographie le 12/06/2024 à 17h.", histgeoConvocation);
            }
        });

        civique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConvocationDialog("Convocation pour Éducation Civique", "Vous êtes convoqué pour une discussion sur votre projet citoyen le 13/06/2024 à 18h.", civiqueConvocation);
            }
        });

        return view;
    }

    private void showConvocationDialog(String title, String message, final TextView convocationTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                convocationTextView.setText(message);  // Update the TextView with the new convocation
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
