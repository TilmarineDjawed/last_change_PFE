package com.example.pfe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class grades extends Fragment {

    ImageButton back;
    Button buttonTrim1, buttonTrim2, buttonTrim3;
    CardView cardViewTrim1, cardViewTrim2, cardViewTrim3;
    TextView noteMathTrim1, noteScienceTrim1;
    TextView noteMathTrim2, noteScienceTrim2;
    TextView noteMathTrim3, noteScienceTrim3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grades, container, false);

        // Find the views
        back = view.findViewById(R.id.back);
        buttonTrim1 = view.findViewById(R.id.button2); // Assuming button2 is Trimester 1
        buttonTrim2 = view.findViewById(R.id.button3); // Assuming button3 is Trimester 2
        buttonTrim3 = view.findViewById(R.id.button4); // Assuming button4 is Trimester 3
        cardViewTrim1 = view.findViewById(R.id.cardViewTrim1);
        cardViewTrim2 = view.findViewById(R.id.cardViewTrim2);
        cardViewTrim3 = view.findViewById(R.id.cardViewTrim3);

        // Note TextViews for Trimester 1
        noteMathTrim1 = view.findViewById(R.id.noteMathTrim1);
        noteScienceTrim1 = view.findViewById(R.id.noteScienceTrim1);

        // Note TextViews for Trimester 2
        noteMathTrim2 = view.findViewById(R.id.noteMathTrim2);
        noteScienceTrim2 = view.findViewById(R.id.noteScienceTrim2);

        // Note TextViews for Trimester 3
        noteMathTrim3 = view.findViewById(R.id.noteMathTrim3);
        noteScienceTrim3 = view.findViewById(R.id.noteScienceTrim3);

        // Set an onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mainparent.class);
                startActivity(intent);
            }
        });

        // Set onClickListeners for the trimester buttons
        buttonTrim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNotesForTrimester(1);
            }
        });

        buttonTrim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNotesForTrimester(2);
            }
        });

        buttonTrim3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNotesForTrimester(3);
            }
        });

        // Initialize the first trimester as visible
        updateNotesForTrimester(1);

        return view;
    }

    private void updateNotesForTrimester(int trimester) {
        // Hide all CardViews first
        cardViewTrim1.setVisibility(View.GONE);
        cardViewTrim2.setVisibility(View.GONE);
        cardViewTrim3.setVisibility(View.GONE);

        switch (trimester) {
            case 1:
                // Update notes for Trimester 1
                noteMathTrim1.setText("Math: 15");
                noteScienceTrim1.setText("Science: 14");
                cardViewTrim1.setVisibility(View.VISIBLE);
                break;
            case 2:
                // Update notes for Trimester 2
                noteMathTrim2.setText("Math: 12");
                noteScienceTrim2.setText("Science: 13");
                cardViewTrim2.setVisibility(View.VISIBLE);
                break;
            case 3:
                // Update notes for Trimester 3
                noteMathTrim3.setText("Math: 14");
                noteScienceTrim3.setText("Science: 15");
                cardViewTrim3.setVisibility(View.VISIBLE);
                break;
        }
    }
}
