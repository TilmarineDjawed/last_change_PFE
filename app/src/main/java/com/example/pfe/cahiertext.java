package com.example.pfe;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class cahiertext extends Fragment {

    ImageButton back;
    ConstraintLayout parentLayout;
    LinearLayout cardContainer;
    CardView contributeCard;
    TextView dateTextView, courTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cahiertext, container, false);

        back = view.findViewById(R.id.back);
        parentLayout = view.findViewById(R.id.constraintLayout);
        cardContainer = view.findViewById(R.id.cardContainer);
        contributeCard = view.findViewById(R.id.contributeCard);
        dateTextView = contributeCard.findViewById(R.id.date);
        courTextView = contributeCard.findViewById(R.id.cour);

        // Set an onClickListener for the back button
        back.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), mainprof.class);
            startActivity(intent);
        });

        // Set an onClickListener for the contributeCard
        contributeCard.setOnClickListener(v -> showExerciseDialog(dateTextView, courTextView));

        // Set an onClickListener for the add button
        view.findViewById(R.id.addButton).setOnClickListener(v -> addNewCard());

        return view;
    }

    private void showExerciseDialog(TextView dateTextView, TextView courTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("");

        // Create a LinearLayout to hold the EditText views
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);

        // Add an input field for the date
        final EditText dateInput = new EditText(getActivity());
        dateInput.setHint("Date");
        dateInput.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(dateInput);

        // Add an input field for the exercises
        final EditText exercisesInput = new EditText(getActivity());
        exercisesInput.setHint("Exercices à faire");
        exercisesInput.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(exercisesInput);

        builder.setView(layout);

        builder.setPositiveButton("Envoyer", (dialog, which) -> {
            String date = dateInput.getText().toString();
            String exercises = exercisesInput.getText().toString();

            // Update the clicked card's TextViews
            dateTextView.setText(date);
            courTextView.setText(exercises);
        });

        builder.setNegativeButton("Annuler", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void addNewCard() {
        CardView newCard = (CardView) LayoutInflater.from(getActivity())
                .inflate(R.layout.card_layout2, cardContainer, false);

        TextView newDateTextView = newCard.findViewById(R.id.date);
        TextView newCourTextView = newCard.findViewById(R.id.cour);

        newCard.setOnClickListener(v -> showExerciseDialog(newDateTextView, newCourTextView));

        cardContainer.addView(newCard);
    }
}