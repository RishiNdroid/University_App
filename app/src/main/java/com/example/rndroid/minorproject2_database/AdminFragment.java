package com.example.rndroid.minorproject2_database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment extends Fragment implements View.OnClickListener {
    MainActivity mainActivity;
    Button buttonPHD, buttonMPHIL, buttonStudProject, buttonFacultyPublication, buttonGoogleSync, buttonView, buttonSearch;
    public AdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_admin, container, false);
        buttonPHD = (Button) v.findViewById(R.id.button_phd_adminFrag);
        buttonPHD.setOnClickListener(this);
        buttonMPHIL = (Button) v.findViewById(R.id.button_mphil_adminFrag);
        buttonMPHIL.setOnClickListener(this);
        buttonStudProject = (Button) v.findViewById(R.id.button_studProject_adminFrag);
        buttonStudProject.setOnClickListener(this);
        buttonFacultyPublication = (Button) v.findViewById(R.id.button_facultyPublication_adminFrag);
        buttonFacultyPublication.setOnClickListener(this);
        buttonGoogleSync = (Button) v.findViewById(R.id.button_googlesync_adminFrag);
        buttonView = (Button) v.findViewById(R.id.button_view_adminFrag);
        buttonView.setOnClickListener(this);
        buttonSearch = (Button) v.findViewById(R.id.button_search_adminFrag);
        buttonSearch.setOnClickListener(this);
        mainActivity = (MainActivity) getActivity();
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_phd_adminFrag : mainActivity.changeFrag("enterstudentdetails");break;
            case R.id.button_mphil_adminFrag : mainActivity.changeFrag("enterstudentdetails");break;
            case R.id.button_studProject_adminFrag : mainActivity.changeFrag("enterstudentdetails");break;
            case R.id.button_facultyPublication_adminFrag : mainActivity.changeFrag("enterstudentdetails");break;
            case R.id.button_view_adminFrag : mainActivity.changeFrag("viewstudent");break;
            case R.id.button_search_adminFrag : mainActivity.changeFrag("searchstudent");break;
        }

    }


}
