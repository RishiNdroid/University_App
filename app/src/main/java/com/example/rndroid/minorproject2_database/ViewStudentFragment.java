package com.example.rndroid.minorproject2_database;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewStudentFragment extends Fragment {

    SimpleCursorAdapter cursorAdapter;
    Cursor cursor;
    MyDatabase myDatabase;
    ListView listView;
    public ViewStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.openReadableDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_view_student,container,false);
        listView = (ListView) v.findViewById(R.id.listview_viewStudentDetails);

        cursor = myDatabase.getStudentDetails();

        cursorAdapter = new SimpleCursorAdapter(getActivity(),R.layout.viewstudent_row,cursor,
                new String[]{"sno", "sname", "smobile", "semail", "ssubject"}, new int[]{R.id.textviewStudentNo_viewStudent_row,R.id.textviewStudentName_viewStudent_row
        ,R.id.textviewStudentMobile_viewStudent_row,R.id.textviewStudentSubject_viewStudent_row,R.id.textviewStudentEmail_viewStudent_row});

        listView.setAdapter(cursorAdapter);

        return v;
    }

    @Override
    public void onDestroy() {
        myDatabase.closeDB();
        super.onDestroy();
    }
}
