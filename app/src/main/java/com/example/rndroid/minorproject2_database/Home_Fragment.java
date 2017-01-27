package com.example.rndroid.minorproject2_database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {
    MainActivity m;
    Button buttonLogin, buttonRegister;
    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_home_,null);
        m = (MainActivity) getActivity();
        buttonLogin = (Button) v.findViewById(R.id.button_login_homefragment);
        buttonRegister = (Button) v.findViewById(R.id.button_register_homefragment);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m.changeFrag("loginfrag");
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.changeFrag("registerfrag");
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
