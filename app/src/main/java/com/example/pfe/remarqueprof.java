package com.example.pfe;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class remarqueprof extends Fragment {

    ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_remarqueprof, container, false);

        // Find the back button after inflating the layout
        back = view.findViewById(R.id.back);

        // Set an onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use getActivity() as the context for the Intent
                Intent intent = new Intent(getActivity(), mainprof.class);
                startActivity(intent);
            }
        });

        // Find and set onClickListeners for all CardViews
        int[] cardViewIds = {
                R.id.contributeCardetudiant1,
                R.id.contributeCardetudiant2,
                R.id.contributeCardetudiant3,
                R.id.contributeCardetudiant4,
                R.id.contributeCardetudiant5,
                R.id.contributeCardetudiant6,
                R.id.contributeCardetudiant7,
                R.id.contributeCardetudiant8,
                R.id.contributeCardetudiant9,
                R.id.contributeCardetudiant10,
                R.id.contributeCardetudiant11,
                R.id.contributeCardetudiant12,
                R.id.contributeCardetudiant13,
                R.id.contributeCardetudiant14,
                R.id.contributeCardetudiant15,
                R.id.contributeCardetudiant16
        };

        for (int id : cardViewIds) {
            CardView cardView = view.findViewById(id);
            cardView.setOnClickListener(cardViewClickListener);
        }

        return view;
    }

    private final View.OnClickListener cardViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showRemarqueDialog();
        }
    };

    private void showRemarqueDialog() {
        // Create an alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Inflate the custom layout/view
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_remark, null);
        builder.setView(dialogView);

        // Initialize the views in the dialog
        EditText editTextRemarque = dialogView.findViewById(R.id.editTextRemarque);
        View buttonEnvoyer = dialogView.findViewById(R.id.buttonEnvoyer);

        // Create and show the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String remarque = editTextRemarque.getText().toString().trim();
                if (!remarque.isEmpty()) {
                    Toast.makeText(getActivity(), "Remarque envoyée: " + remarque, Toast.LENGTH_SHORT).show();
                    // Handle sending the remarque to your backend or processing it as needed
                    alertDialog.dismiss();
                } else {
                    Toast.makeText(getActivity(), "Veuillez entrer une remarque", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
