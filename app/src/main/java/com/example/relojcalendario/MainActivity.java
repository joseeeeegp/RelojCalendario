package com.example.relojcalendario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_fecha;
    Button bt_hora;
    EditText et_fecha;
    EditText et_hora;
    private int dia, mes, ano, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_fecha = (Button) findViewById(R.id.idFecha);
        bt_hora = (Button) findViewById(R.id.idHora);
        et_fecha = (EditText) findViewById(R.id.editfecha);
        et_hora = (EditText) findViewById(R.id.edithora);

        bt_fecha.setOnClickListener((View.OnClickListener) this);
        bt_hora.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        if (v == bt_fecha) {
            final Calendar calendario = Calendar.getInstance();
            dia = calendario.get(Calendar.DAY_OF_MONTH);
            ano = calendario.get(Calendar.MONTH);
            mes = calendario.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    et_fecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    Toast.makeText(et_fecha.getContext(),"Selecionado: " +dayOfMonth + "/" + (month + 1) + "/" + year ,Toast.LENGTH_LONG).show();
                }
            }, dia, mes, ano);
            datePickerDialog.show();

        }
        if (v == bt_hora) {
            final Calendar calendario = Calendar.getInstance();
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    et_hora.setText(hourOfDay + " : " + minute);
                    Toast.makeText(et_fecha.getContext(),"Selecionado: " +hourOfDay + " : " + minute,Toast.LENGTH_LONG).show();
                }
            }, hora, minutos, false);
            timePickerDialog.show();
        }
    }
}
