package com.example.rndroid.minorproject2_database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailStudentFragment extends Fragment {
    EditText editTextTo, editTextSubject, editTextComposer;
    Button buttonSend, buttonClose;

    public EmailStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_email_student, container, false);
        editTextTo = (EditText) v.findViewById(R.id.compose_email_to);
        editTextSubject = (EditText) v.findViewById(R.id.compose_email_subject);
        editTextComposer = (EditText) v.findViewById(R.id.compose_email_text);
        buttonSend = (Button) v.findViewById(R.id.button_send);
        buttonClose = (Button) v.findViewById(R.id.button_close);
        Bundle b = getArguments();
        String email = b.getString("emailid");
        editTextTo.setText(email);
        editTextTo.setEnabled(false);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Email Sent", Toast.LENGTH_SHORT).show();
                editTextComposer.setText("");
                editTextSubject.setText("");
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFrag("adminfrag");
            }
        });

        return v;
    }

}
