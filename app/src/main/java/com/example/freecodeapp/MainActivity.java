package com.example.freecodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Siempre se trabaja asi se declaran lads variables y elementos de las vistas y donde se vayan a usar ahi es donde se instancian
    private TextView txtName, txLastName, txEmail;
    private EditText editTextName, editTextLastName, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* editTextName = (EditText) findViewById(R.id.edtTxName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        txtName = findViewById(R.id.nameTW);
        txLastName = findViewById(R.id.lastNameTW);
        txEmail = findViewById(R.id.emailtextView);*/

        editTextName = (EditText) findViewById(R.id.editextName);
        txtName = findViewById(R.id.textHello);


        Button btnHello = findViewById(R.id.btnButton);
        btnHello.setOnClickListener(this);
        Button btnButton2 = findViewById(R.id.btnButton2);
        btnButton2.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    public void btnClick(View view) {


        /*String name = editTextName.getText().toString();
        String lastname = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();


        txtName.setText(name);
        txLastName.setText(lastname);
        txEmail.setText(email);*/


        // Button btn = findViewById(R.id.btnButton);


    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnButton:
                txtName.setText("Hello " + editTextName.getText().toString());
               
                break;
            case R.id.btnButton2:
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                break;
            default:
                break;

        }
    }
}