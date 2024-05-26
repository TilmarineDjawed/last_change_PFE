package com.example.pfe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class cahiercharge extends Fragment {

    ImageButton back;
    CardView contributeCard3;
    ConstraintLayout parentLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cahiercharge, container, false);

        // Find the back button and other views after inflating the layout
        back = view.findViewById(R.id.back);
        contributeCard3 = view.findViewById(R.id.contributeCard);
        parentLayout = view.findViewById(R.id.constraintLayout);

        // Set an onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use getActivity() as the context for the Intent
                Intent intent = new Intent(getActivity(), mainprof.class);
                startActivity(intent);
            }
        });

        // Set an onClickListener for the contributeCard3
        contributeCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExerciseDialog();
            }
        });

        return view;
    }

    private void showExerciseDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Exercices à faire");

        // Create a LinearLayout to hold the EditText views
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);

        // Add an input field for the date
        final EditText dateInput = new EditText(getActivity());
        dateInput.setHint("Date");
        dateInput.setInputType(InputType.TYPE_CLASS_DATETIME);
        layout.addView(dateInput);

        // Add an input field for the exercises
        final EditText exercisesInput = new EditText(getActivity());
        exercisesInput.setHint("Exercices à faire");
        exercisesInput.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(exercisesInput);

        builder.setView(layout);

        builder.setPositiveButton("Envoyer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Retrieve the entered text and send the exercises
                String date = dateInput.getText().toString();
                String exercises = exercisesInput.getText().toString();
                // Send the exercises here (implement this part)
            }
        });

        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
