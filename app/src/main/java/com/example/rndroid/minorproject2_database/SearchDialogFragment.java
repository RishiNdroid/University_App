package com.example.rndroid.minorproject2_database;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Dialog To Show Student Details when Admin search for a perticular candidate
 */
public class SearchDialogFragment extends DialogFragment {

    String temp;
    AlertDialog.Builder builder;
    Cursor cursor;
    MyDatabase myDatabase;
    TextView textViewNo, textViewName, textViewMobile, textViewEmail, textViewSubject, textViewDescription, textViewDate;

    public SearchDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.openDB();
    }

    public View myView(final String emailID){
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_search_dialog, null);
        textViewNo = (TextView) v.findViewById(R.id.textview_studentNo_searchDialog);
        textViewName = (TextView) v.findViewById(R.id.textview_studentName_searchDialog);
        textViewMobile = (TextView) v.findViewById(R.id.textview_studentMobile_searchDialog);
        textViewEmail = (TextView) v.findViewById(R.id.textview_studentEmail_searchDialog);
        textViewSubject = (TextView) v.findViewById(R.id.textview_studentSubject_searchDialog);
        textViewDescription = (TextView) v.findViewById(R.id.textview_studentDescription_searchDialog);
        textViewDate = (TextView) v.findViewById(R.id.textview_studentDate_searchDialog);
        builder.setNegativeButton("Done", null);

        builder.setPositiveButton("Email", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFrag(emailID);
            }
        });
        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;
        builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_person_black_24dp);
        builder.setTitle("Student Details");
        cursor = null;
        temp = null;

        Bundle bundle = getArguments();
        if(bundle.containsKey("name")) {
            temp = bundle.getString("name");
            cursor = myDatabase.getStudentByName(temp);
            if (cursor != null) {
                    if (cursor.moveToNext()){
                        View v1 = myView(cursor.getString(cursor.getColumnIndex("semail")));
                        textViewNo.setText(cursor.getString(cursor.getColumnIndex("sno")));
                        textViewName.setText(cursor.getString(cursor.getColumnIndex("sname")));
                        textViewMobile.setText(cursor.getString(cursor.getColumnIndex("smobile")));
                        textViewEmail.setText(cursor.getString(cursor.getColumnIndex("semail")));
                        textViewSubject.setText(cursor.getString(cursor.getColumnIndex("ssubject")));
                        textViewDescription.setText(cursor.getString(cursor.getColumnIndex("sdescription")));
                        textViewDate.setText(cursor.getString(cursor.getColumnIndex("date")));
                        Toast.makeText(getActivity(), "" + temp, Toast.LENGTH_SHORT).show();
                        builder.setView(v1);
                }else {
                        builder.setMessage("Student Name Not Found");
                        builder.setPositiveButton("Done", null);
                    }
            }
        }else if (bundle.containsKey("cell")) {
            temp = bundle.getString("cell");
            cursor = myDatabase.getStudentByMobile(temp);
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    View v2 = myView(cursor.getString(cursor.getColumnIndex("semail")));
                    textViewNo.setText(cursor.getString(cursor.getColumnIndex("sno")));
                    textViewName.setText(cursor.getString(cursor.getColumnIndex("sname")));
                    textViewMobile.setText(cursor.getString(cursor.getColumnIndex("smobile")));
                    textViewEmail.setText(cursor.getString(cursor.getColumnIndex("semail")));
                    textViewSubject.setText(cursor.getString(cursor.getColumnIndex("ssubject")));
                    textViewDescription.setText(cursor.getString(cursor.getColumnIndex("sdescription")));
                    textViewDate.setText(cursor.getString(cursor.getColumnIndex("date")));
                    Toast.makeText(getActivity(), "" + temp, Toast.LENGTH_SHORT).show();
                    builder.setView(v2);
                }else {builder.setMessage("Mobile Number Not Found");builder.setPositiveButton("Done", null);}
            }
        }

        return dialog = builder.create();
    }

    @Override
    public void onDestroy() {
        myDatabase.closeDB();
        super.onDestroy();
    }
}
