package com.example.rndroid.minorproject2_database;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterStudentDetailFragment extends Fragment implements View.OnClickListener {

    public static final int DATEPICKER_FRAGMENT = 1;
    MainActivity mainActivity;
    EditText editTextStudno, editTextStudname, editTextStudEmail, editTextStudMobile, editTextSubject, editTextStudDescription;
    Button buttonBack, buttonSave, buttonDate;
    TextView textViewDate;
    MyDatabase myDatabase;
    public EnterStudentDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.openDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_enter_student_detail, container, false);
        editTextStudno = (EditText) v.findViewById(R.id.edittextStudentNumber_enterStudent);
        editTextStudname = (EditText) v.findViewById(R.id.edittextStudentName_enterStudent);
        editTextStudEmail = (EditText) v.findViewById(R.id.edittext_emailID_enterStudent);
        editTextStudMobile = (EditText) v.findViewById(R.id.edittext_Mobile_enterStudent);
        editTextSubject = (EditText) v.findViewById(R.id.edittext_subject_enterStudent);
        editTextStudDescription = (EditText) v.findViewById(R.id.edittext_description_enterStudent);
        textViewDate = (TextView) v.findViewById(R.id.textview_date_enterStudent);

        buttonDate = (Button) v.findViewById(R.id.button_date_enterStudent);
        buttonDate.setOnClickListener(this);
        buttonSave = (Button) v.findViewById(R.id.buttonSave_enterStudent);
        buttonSave.setOnClickListener(this);
        buttonBack = (Button) v.findViewById(R.id.buttonBack_enterStudent);
        buttonBack.setOnClickListener(this);
        mainActivity = (MainActivity) getActivity();

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_date_enterStudent :
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.setTargetFragment(this, DATEPICKER_FRAGMENT);
                dialog.show(getFragmentManager().beginTransaction(),"mydialog");
                break;

            case R.id.buttonSave_enterStudent:

                if ((editTextStudno.getText().toString().isEmpty()|| editTextStudname.getText().toString().trim().isEmpty() ||
                    editTextStudMobile.getText().toString().trim().isEmpty()|| editTextStudEmail.getText().toString().trim().isEmpty() || editTextSubject.getText().toString().trim().isEmpty() ||
                    editTextStudDescription.getText().toString().trim().isEmpty()|| textViewDate.getText().toString().isEmpty()) == false){

                    if (editTextStudEmail.getText().toString().contains("@")){
                        myDatabase.insert(editTextStudno.getText().toString().trim(), editTextStudname.getText().toString().trim(), editTextStudMobile.getText().toString().trim(),
                                editTextStudEmail.getText().toString().trim(), editTextSubject.getText().toString().trim(), editTextStudDescription.getText().toString().trim(),
                                textViewDate.getText().toString());
                        Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                        editTextStudDescription.setText("");
                        editTextStudno.setText("");
                        editTextSubject.setText("");
                        editTextStudEmail.setText("");
                        editTextStudMobile.setText("");
                        editTextStudname.setText("");
                        textViewDate.setText("Pick Date");
                        editTextStudno.requestFocus();
                        break;
                    }else {
                        Toast.makeText(getActivity(), "Invalid Email ID", Toast.LENGTH_SHORT).show();
                        editTextStudEmail.setText(""); editTextStudEmail.requestFocus();
                        break;
                    }
                }else {
                    Toast.makeText(getActivity(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
                    break;
                }



            case R.id.buttonBack_enterStudent: mainActivity.changeFrag("back"); break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case DATEPICKER_FRAGMENT:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    String date = bundle.getString("date");
                    textViewDate.setText(date);
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(getActivity(), "Invalid Date", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        myDatabase.closeDB();
        super.onDestroy();
    }
}
