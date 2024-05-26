package com.example.pfe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

public class homework extends Fragment {
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

    TextView mathHomeworkDesc;
    TextView scienceHomeworkDesc;
    TextView frenchHomeworkDesc;
    TextView englishHomeworkDesc;
    TextView arabicHomeworkDesc;
    TextView artHomeworkDesc;
    TextView islamicHomeworkDesc;
    TextView histgeoHomeworkDesc;
    TextView civiqueHomeworkDesc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homework, container, false);

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

        // Find the TextViews for homework descriptions
        mathHomeworkDesc = view.findViewById(R.id.mathHomeworkDesc);
        scienceHomeworkDesc = view.findViewById(R.id.scienceHomeworkDesc);
        frenchHomeworkDesc = view.findViewById(R.id.frenchHomeworkDesc);
        englishHomeworkDesc = view.findViewById(R.id.englishHomeworkDesc);
        arabicHomeworkDesc = view.findViewById(R.id.arabicHomeworkDesc);
        artHomeworkDesc = view.findViewById(R.id.artHomeworkDesc);
        islamicHomeworkDesc = view.findViewById(R.id.islamicHomeworkDesc);
        histgeoHomeworkDesc = view.findViewById(R.id.histgeoHomeworkDesc);
        civiqueHomeworkDesc = view.findViewById(R.id.civiqueHomeworkDesc);

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
                showHomeworkDialog("Math Homework", "Devoir à faire : \n1. Exercices 1 à 5 \n2. Révisions des chapitres 2 et 3 \nDate de remise 28/05/2024", mathHomeworkDesc);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("Science Homework", "Devoir à faire : \n1. Chapitre 4 \n2. Projets 1 et 2 \nDate de remise 29/05/2024", scienceHomeworkDesc);
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("French Homework", "Devoir à faire : \n1. Lecture pages 10-20 \n2. Exercices 3 et 4 \nDate de remise 30/05/2024", frenchHomeworkDesc);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("English Homework", "Devoir à faire : \n1. Writing essay \n2. Vocabulary test \nDate de remise 31/05/2024", englishHomeworkDesc);
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("Arabic Homework", "Devoir à faire : \n1. Poème pages 5-7 \n2. Exercices 1 et 2 \nDate de remise 01/06/2024", arabicHomeworkDesc);
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("Art Homework", "Devoir à faire : \n1. Peinture \n2. Sculpture \nDate de remise 02/06/2024", artHomeworkDesc);
            }
        });

        islamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("Islamic Homework", "Devoir à faire : \n1. Lecture pages 50-60 \n2. Exercices 5 et 6 \nDate de remise 03/06/2024", islamicHomeworkDesc);
            }
        });

        histgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("History & Geography Homework", "Devoir à faire : \n1. Chapitre 10 \n2. Cartographie \nDate de remise 04/06/2024", histgeoHomeworkDesc);
            }
        });

        civique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeworkDialog("Civic Education Homework", "Devoir à faire : \n1. Projet citoyen \n2. Essai sur la citoyenneté \nDate de remise 05/06/2024", civiqueHomeworkDesc);
            }
        });

        return view;
    }

    private void showHomeworkDialog(String title, String message, final TextView homeworkDescTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                homeworkDescTextView.setText(message);  // Update the TextView with the new homework description
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
