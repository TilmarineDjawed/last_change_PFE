package com.example.pfe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class absence extends Fragment {

    ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_absence, container, false);

        // Find the back button after inflating the layout
        back = view.findViewById(R.id.back);

        // Set an onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use getActivity() as the context for the Intent
                Intent intent = new Intent(getActivity(), mainparent.class);
                startActivity(intent);
            }
        });

        // Find all TextViews for each subject
        TextView[] absenceTextViews = {
                view.findViewById(R.id.nonjustifier),
                view.findViewById(R.id.justifier),
                view.findViewById(R.id.justifier2),
                view.findViewById(R.id.pasdabsence),
                view.findViewById(R.id.pasdabsence2),
                view.findViewById(R.id.pasdabsence3),
                view.findViewById(R.id.nonjustifier2),
                view.findViewById(R.id.justifier3),
                view.findViewById(R.id.justifier4)
        };

        // Iterate through all TextViews and set the appropriate onClickListener
        for (TextView textView : absenceTextViews) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentText = textView.getText().toString().toLowerCase();
                    if (currentText.equals("non justifier")) {
                        showJustifyDialog(textView);
                    } else if (currentText.equals("justifier")) {
                        // Do nothing
                    } else if (currentText.equals("pas d'absence")) {
                        // Do nothing
                    }
                }
            });
        }

        return view;
    }

    private void showJustifyDialog(TextView textView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Justification d'absence");
        builder.setMessage("Voulez-vous justifier l'absence par email ?");
        builder.setPositiveButton("Justifier par email", (dialog, which) -> {
            // Intent to open Gmail
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"email@example.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Justification d'absence");
            intent.putExtra(Intent.EXTRA_TEXT, "Bonjour, \n\nJe souhaite justifier l'absence de mon enfant.");
            try {
                startActivity(Intent.createChooser(intent, "Envoyer l'email..."));
                // Update the TextView text to "justifier"
                textView.setText("justifier");
            } catch (android.content.ActivityNotFoundException ex) {
                // Handle error if no email clients are installed
            }
        });
        builder.setNegativeButton("Annuler", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
