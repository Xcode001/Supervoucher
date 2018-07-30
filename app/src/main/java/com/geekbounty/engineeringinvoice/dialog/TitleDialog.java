package com.geekbounty.engineeringinvoice.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.geekbounty.engineeringinvoice.R;

/**
 * Created by Mussa on 7/24/2018.
 */

public class TitleDialog extends AppCompatDialogFragment{

    private EditText dialog_title;
    private TitleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.title_dialog, null);

        builder.setView(view)
                .setTitle("Title")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = dialog_title.getText().toString().trim();
                        listener.applyTitle(title);
                    }
                });
        dialog_title = view.findViewById(R.id.title_et);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (TitleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement TitleDialogListener");
        }
    }

    public interface TitleDialogListener{
        void applyTitle(String title);
    }
}
