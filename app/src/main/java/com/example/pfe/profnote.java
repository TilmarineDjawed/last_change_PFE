package com.example.pfe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;

public class profnote extends Fragment {

    ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profnote, container, false);

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

        // Set up the click listeners for the EditText fields
        setUpEditTextListeners(view);

        return view;
    }

    private void setUpEditTextListeners(View view) {
        int[] editTextIds = {
                R.id.etudiant1txt, R.id.etudiant1cc1, R.id.etudiant1cc2, R.id.etudiant1exam,
                R.id.etudiant2txt,  R.id.etudiant2cc1, R.id.etudiant2cc2, R.id.etudiant2exam,
                R.id.etudiant3txt,  R.id.etudiant3cc1, R.id.etudiant3cc2, R.id.etudiant3exam,
                R.id.etudiant4txt,  R.id.etudiant4cc1, R.id.etudiant4cc2, R.id.etudiant4exam,
                R.id.etudiant5txt,  R.id.etudiant5cc1, R.id.etudiant5cc2, R.id.etudiant5exam,
                R.id.etudiant6txt,  R.id.etudiant6cc1, R.id.etudiant6cc2, R.id.etudiant6exam,
                R.id.etudiant7txt, R.id.etudiant7cc1, R.id.etudiant7cc2, R.id.etudiant7exam,
                R.id.etudiant8txt,  R.id.etudiant8cc1, R.id.etudiant8cc2, R.id.etudiant8exam
        };

        for (int id : editTextIds) {
            EditText editText = view.findViewById(id);
            editText.setFocusableInTouchMode(false); // Disable direct editing
            editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showEditDialog((EditText) v);
                }
            });
        }
    }

    private void showEditDialog(final EditText editText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Modifier l'information");

        // Create a layout inflater to inflate the custom dialog view
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_edit_student, null);
        builder.setView(dialogView);

        final EditText editStudentName = dialogView.findViewById(R.id.editStudentName);
        final EditText editStudentGrade = dialogView.findViewById(R.id.editStudentGrade);

        // Determine if the clicked field is for a name or a grade
        if (editText.getId() == R.id.etudiant1txt || editText.getId() == R.id.etudiant2txt ||
                editText.getId() == R.id.etudiant3txt || editText.getId() == R.id.etudiant4txt ||
                editText.getId() == R.id.etudiant5txt || editText.getId() == R.id.etudiant6txt ||
                editText.getId() == R.id.etudiant7txt || editText.getId() == R.id.etudiant8txt) {
            editStudentName.setVisibility(View.VISIBLE);
            editStudentGrade.setVisibility(View.GONE);
            editStudentName.setText(editText.getText().toString());
        } else {
            editStudentName.setVisibility(View.GONE);
            editStudentGrade.setVisibility(View.VISIBLE);
            editStudentGrade.setText(editText.getText().toString());
        }

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (editStudentName.getVisibility() == View.VISIBLE) {
                    editText.setText(editStudentName.getText().toString());
                } else {
                    editText.setText(editStudentGrade.getText().toString());
                }
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
