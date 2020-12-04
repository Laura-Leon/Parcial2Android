package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase db;
    private TextView Tpregunta;
    private EditText Enumero;
    private Button okbtn;
    private  Pregunta pregunta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tpregunta  =  findViewById(R.id.Tpregunta);
        Enumero = findViewById(R.id.Enumero);
        okbtn = findViewById(R.id.okbtn);

        db = FirebaseDatabase.getInstance();

        okbtn.setOnClickListener(this);
        loadDatabase();

    }

    private void loadDatabase() {
        DatabaseReference ref = (DatabaseReference) db.getReference().child("preguntas/PA");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                        Tpregunta.setText(" ");
                        for (DataSnapshot child: data.getChildren()) {

                          pregunta = child.getValue(Pregunta.class);

                            Tpregunta.setText(pregunta.getNuevaPregunta()+"\n");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.okbtn:


                String puntaje = Enumero.getText().toString();
                int contable = Integer.parseInt(puntaje);

                DatabaseReference references = db.getReference().child("preguntas/PA/Promedio");
                Numero numero = new Numero(contable);
                references.push().setValue(numero);
                break;


        }
    }
}