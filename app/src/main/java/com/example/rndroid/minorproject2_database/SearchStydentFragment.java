package com.example.rndroid.minorproject2_database;


import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchStydentFragment extends Fragment implements View.OnClickListener {

    String name, cell;
    SearchDialogFragment searchDialogFragment;
    MainActivity mainActivity;
    EditText editTextName, editTextCell;
    Button buttonGoName, buttonGoCell;
    MyDatabase myDatabase;

    public SearchStydentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_search_stydent, container, false);
        editTextName = (EditText) v.findViewById(R.id.edittext_name_searchfrag);
        editTextCell = (EditText) v.findViewById(R.id.edittext_Cell_searchfrag);
        buttonGoName = (Button) v.findViewById(R.id.button_goName_searchfrag);
        buttonGoCell = (Button) v.findViewById(R.id.button_goCell_searchfrag);
        buttonGoName.setOnClickListener(this);
        buttonGoCell.setOnClickListener(this);
        mainActivity = (MainActivity) getActivity();

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_goName_searchfrag :
                mainActivity.myDialog(editTextName.getText().toString().trim().toUpperCase(), null);
                editTextName.setText("");
                editTextName.requestFocus();
                break;

            case R.id.button_goCell_searchfrag :
                mainActivity.myDialog(null, editTextCell.getText().toString());
                editTextCell.setText("");
                editTextCell.requestFocus();
                break;
        }
    }
}
