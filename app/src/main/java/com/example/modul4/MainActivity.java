package com.example.modul4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    EditText tanggal,waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanggal = findViewById(R.id.tanggal);
        waktu = findViewById(R.id.waktu);
    }
    //set tanggal
    public void setTanggal(View view) {
        final Calendar c = Calendar.getInstance();
        int thn = c.get(Calendar.YEAR);
        int bln = c.get(Calendar.MONTH);
        int tgl = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new
                DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                        tanggal.setText(thn + "-" + (bln+ 1) + "-" + tgl);
                    }
                },thn,bln,tgl);
        datePickerDialog.show();
    }
    //set Waktu
    public void setWaktu(View view) {
        final Calendar c = Calendar.getInstance();
        int jam = c.get(Calendar.HOUR_OF_DAY);
        int menit = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new
                TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int jam, int menit) {
                        waktu.setText(jam + ":" + menit);
                    }
                },jam,menit,false);
        timePickerDialog.show();
    }
}