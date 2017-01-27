package com.example.rndroid.minorproject2_database;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment {


    public DatePickerFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(java.util.Calendar.YEAR);
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        int month = calendar.get(java.util.Calendar.MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String tempDate = i2 +"/"+ (i1+1) +"/"+ i;

                Intent intent = new Intent();
                intent.putExtra("date", tempDate);
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                dismiss();

            }
        }, year, month, day);
        d = datePickerDialog;

        return d;
    }


}
