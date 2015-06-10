package com.squeezo.android.outlet;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.squeezo.outlet.R;

import java.util.Calendar;

public class PostOfferActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private TimePickerDialog timePickerDialog;
    private Button btnFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_offer);

        btnFrom = (Button) findViewById(R.id.buttonFrom);
        Button btnPost = (Button) findViewById(R.id.buttonPost);
//        Spinner spnDuration = (Spinner) findViewById(R.id.spinnerDuration);

        final Calendar calendar = Calendar.getInstance();

        timePickerDialog = new TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);

        timePickerDialog.setCanceledOnTouchOutside(false);

        btnFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.updateTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
                timePickerDialog.show();
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Post", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        boolean lessThan10 = minute < 10;

        if (lessThan10)
            btnFrom.setText("From " + hourOfDay + ":0" + minute);
        else
            btnFrom.setText("From " + hourOfDay + ":" + minute);
    }
}
