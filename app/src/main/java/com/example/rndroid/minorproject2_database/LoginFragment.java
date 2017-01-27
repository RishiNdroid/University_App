package com.example.rndroid.minorproject2_database;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    Button buttonLogin,buttonReqPass;
    EditText editTextUsername,editTextPass, editTextReqPass;
    String name, pass;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_login,null);
        editTextUsername = (EditText) v.findViewById(R.id.edittext_username_loginfrag);
        editTextPass = (EditText) v.findViewById(R.id.edittext_password_loginfrag);
        editTextReqPass = (EditText) v.findViewById(R.id.edittext_registeredEmail_loginfrag);
        buttonLogin = (Button) v.findViewById(R.id.button_login_loginfrag);
        buttonReqPass = (Button) v.findViewById(R.id.button_req_pass_loginfrag);//we will do this code later

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("credential",0);

                name = sp.getString("ename", null);
                pass = sp.getString("pass", null);
                if (editTextUsername.getText().toString().isEmpty() || editTextPass.getText().toString().isEmpty() ) {
                    Toast.makeText(getActivity(), "Please Fill Username and Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (name != null && pass != null && name.equals(editTextUsername.getText().toString()) && pass.equals(editTextPass.getText().toString())){
                        Toast.makeText(getActivity(), "Welcome"+editTextUsername.getText().toString(), Toast.LENGTH_SHORT).show();
                        MainActivity m = (MainActivity) getActivity();
                        m.changeFrag("adminfrag");
                    }else if (name == null && pass == null || !name.equals(editTextUsername.getText().toString()) && !pass.equals(editTextPass.getText().toString())){
                        Toast.makeText(getActivity(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                        editTextPass.setText("");
                        editTextUsername.setText("");
                        editTextUsername.requestFocus();
                    }
                }
            }
        });

        buttonReqPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         }
        });
        // Inflate the layout for this fragment
        return v;
    }

}
