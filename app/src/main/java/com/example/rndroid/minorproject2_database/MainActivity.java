package com.example.rndroid.minorproject2_database;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;

    public void changeFrag(String fragName){
        fm = getSupportFragmentManager();

       if (fragName.equals("loginfrag")) {
           LoginFragment loginFragment = new LoginFragment();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, loginFragment);
           ft.addToBackStack(null);
           ft.commit();
       }else if (fragName.equals("adminfrag")){
           AdminFragment adminFragment = new AdminFragment();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, adminFragment);
           ft.addToBackStack(null);
           ft.commit();
       }else if (fragName.equals("enterstudentdetails")){
           EnterStudentDetailFragment detailFragment = new EnterStudentDetailFragment();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, detailFragment);
           ft.addToBackStack(null);
           ft.commit();
       }else if (fragName.equals("back")){
           fm.popBackStack();
       }else if (fragName.equals("viewstudent")) {
           ViewStudentFragment studentFragment = new ViewStudentFragment();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, studentFragment);
           ft.addToBackStack(null);
           ft.commit();
       }else if (fragName.equals("searchstudent")){
           SearchStydentFragment searchStudentFragment = new SearchStydentFragment();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, searchStudentFragment);
           ft.addToBackStack(null);
           ft.commit();
       }else if (fragName.contains("@")){
           EmailStudentFragment emailStudentFragment = new EmailStudentFragment();
           Bundle bundle = new Bundle();
           bundle.putString("emailid", fragName);
           emailStudentFragment.setArguments(bundle);
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, emailStudentFragment);
           ft.commit();
       }
       else {
           RegisterFragment registerFragment = new RegisterFragment();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.container1, registerFragment);
           ft.addToBackStack(null);
           ft.commit();
       }
    }

    public void myDialog(String inputName, String inputCell) {
        FragmentManager manager = getSupportFragmentManager();
        if (inputName != null && inputCell == null){
            SearchDialogFragment searchDialogFragment = new SearchDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name",inputName);
            searchDialogFragment.setArguments(bundle);
            searchDialogFragment.show(manager,null);
            FragmentTransaction ft = manager.beginTransaction();
            ft.commit();
        }
        else if (inputName == null && inputCell != null){
            SearchDialogFragment searchDialogFragment = new SearchDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("cell",inputCell);
            searchDialogFragment.setArguments(bundle);
            searchDialogFragment.show(manager,null);
            FragmentTransaction ft = manager.beginTransaction();
            ft.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            Home_Fragment homeFragment = new Home_Fragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container1,homeFragment);
            ft.commit();
        }
    }
}
