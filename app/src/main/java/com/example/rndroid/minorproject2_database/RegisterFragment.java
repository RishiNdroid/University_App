package com.example.rndroid.minorproject2_database;


import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;
import java.util.TreeSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    MainActivity mainActivity;
    EditText editTextEno, editTextEname, editTextEmail, editTextPass, editTextConfirm, editTextPassHint;
    Button buttonRegister, buttonLogin;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_register, container, false);
        editTextEname = (EditText) v.findViewById(R.id.edittextEmpName_registerfrag);
        editTextEno = (EditText) v.findViewById(R.id.edittextEmpNumber_registerfrag);
        editTextPass = (EditText) v.findViewById(R.id.edittextpassword_registerfrag);
        editTextConfirm = (EditText) v.findViewById(R.id.edittextconfirm_pass_registerfrag);
        editTextPassHint = (EditText) v.findViewById(R.id.edittextpassword_hint_registerfrag);
        editTextEmail = (EditText) v.findViewById(R.id.edittextEmail_registerfrag);
        buttonLogin = (Button) v.findViewById(R.id.buttonLogin_registerfrag);
        buttonRegister = (Button) v.findViewById(R.id.buttonRegister_registerfrag);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    TreeSet<String> empDetail = new TreeSet<>();
//                empDetail.add(editTextEno.getText().toString());
//                empDetail.add(editTextEname.getText().toString());
//                empDetail.add(editTextEmail.getText().toString());
//                empDetail.add(editTextPass.getText().toString());
//                empDetail.add(editTextPassHint.getText().toString());

                    if ((!editTextConfirm.getText().toString().equals(editTextPass.getText().toString())) || editTextEno.getText().toString().isEmpty() ||
                            editTextEname.getText().toString().isEmpty() || editTextEmail.getText().toString().isEmpty() ||
                            editTextConfirm.getText().toString().isEmpty() || editTextPassHint.getText().toString().isEmpty() ||
                            editTextPass.getText().toString().isEmpty()) {

                        Toast.makeText(getActivity(), "Please Fill All Details Correctly", Toast.LENGTH_SHORT).show();
                    } else {
                        SharedPreferences sp = getActivity().getSharedPreferences("credential", 0);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("eno", editTextEno.getText().toString());
                        editor.putString("ename", editTextEname.getText().toString());
                        editor.putString("email", editTextEmail.getText().toString());
                        editor.putString("pass", editTextPass.getText().toString());
                        editor.putString("passhint", editTextPassHint.getText().toString());

                        editor.commit();
                        Toast.makeText(getActivity(), "saved", Toast.LENGTH_SHORT).show();
                        editTextEno.requestFocus();
                        editTextEno.setText("");
                        editTextEname.setText("");
                        editTextEmail.setText("");
                        editTextPass.setText("");
                        editTextConfirm.setText("");
                        editTextPassHint.setText("");
                    }
                }
            });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m = (MainActivity) getActivity();
                m.changeFrag("loginfrag");
            }
        });
        return v;
    }

}
