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

public class remarque extends Fragment {

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

    TextView mathRemarque;
    TextView scienceRemarque;
    TextView frenchRemarque;
    TextView englishRemarque;
    TextView arabicRemarque;
    TextView artRemarque;
    TextView islamicRemarque;
    TextView histgeoRemarque;
    TextView civiqueRemarque;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remarque, container, false);

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

        // Find the TextViews for remarks
        mathRemarque = view.findViewById(R.id.mathRemarque);
        scienceRemarque = view.findViewById(R.id.scienceRemarque);
        frenchRemarque = view.findViewById(R.id.frenchRemarque);
        englishRemarque = view.findViewById(R.id.englishRemarque);
        arabicRemarque = view.findViewById(R.id.arabicRemarque);
        artRemarque = view.findViewById(R.id.artRemarque);
        islamicRemarque = view.findViewById(R.id.islamicRemarque);
        histgeoRemarque = view.findViewById(R.id.histgeoRemarque);
        civiqueRemarque = view.findViewById(R.id.civiqueRemarque);

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
                showRemarqueDialog("Remarque pour Mathématiques", "Les étudiants doivent se concentrer davantage sur les concepts de base.", mathRemarque);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Science", "Les expériences de laboratoire doivent être menées avec plus de précision.", scienceRemarque);
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Français", "Les compositions doivent être plus structurées et cohérentes.", frenchRemarque);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Anglais", "Travailler sur la prononciation et l'usage correct des temps verbaux.", englishRemarque);
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Arabe", "Améliorer l'écriture cursive et la grammaire.", arabicRemarque);
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Arts", "Utiliser une plus grande variété de matériaux dans les projets.", artRemarque);
            }
        });

        islamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Études Islamiques", "Approfondir la compréhension des textes sacrés.", islamicRemarque);
            }
        });

        histgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Histoire et Géographie", "Faire plus de recherches pour les projets.", histgeoRemarque);
            }
        });

        civique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemarqueDialog("Remarque pour Éducation Civique", "Participer activement aux discussions de classe.", civiqueRemarque);
            }
        });

        return view;
    }

    private void showRemarqueDialog(String title, String message, final TextView remarqueTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                remarqueTextView.setText(message);  // Update the TextView with the new remark
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
