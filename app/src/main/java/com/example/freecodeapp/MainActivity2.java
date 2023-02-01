package com.example.freecodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMatrix, checkBoxJoker;
    private RadioGroup rgMaritalStatus;

    private ProgressBar progressBar;

    private ListView citiesLW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        checkBoxHarry = findViewById(R.id.checkBoxHarry);
        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        progressBar = findViewById(R.id.progBar1);

        //Working with list view
        final ArrayList<String> cities = new ArrayList<>();

        cities.add("La Habana");
        cities.add("New York");
        cities.add("Chicago");
        cities.add("Madrid");
        cities.add("Londres");
        cities.add("Barcelona");
        cities.add("Berlin");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);

        citiesLW = findViewById(R.id.citiesLW);
        citiesLW.setAdapter(citiesAdapter);


        //Making cada elemento del listr view clickeable y que te lleve a algun lugar
        citiesLW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, cities.get(position) + " Selected", Toast.LENGTH_SHORT).show();

            }
        });

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }

            }
        });


        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity2.this, "You have checcked Harry Potter", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "You have checcked Harry Potter", Toast.LENGTH_SHORT).show();

                }
            }
        });

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity2.this, "Married", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity2.this, "Single", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        thread.start();
                        break;
                    case R.id.rbDivorced:
                        Toast.makeText(MainActivity2.this, "Divorce", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                        break;
                    default:
                        break;

                }
            }
        });


    }
}