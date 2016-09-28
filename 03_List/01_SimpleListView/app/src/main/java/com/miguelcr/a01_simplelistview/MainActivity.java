package com.miguelcr.a01_simplelistview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    String[] footbalTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ListView Component
        lista = (ListView) findViewById(R.id.listViewFootballTeams);

        // 2. An array of data
        footbalTeams = new String[]
                {"1. Chrobry Głogów",
                        "2. Real Madrid",
                        "3. Barcelona FC",
                        "4. Athletico de Madrid",
                        "5. Sevilla FC"
                };

        // 3. Adapter to show String[] in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                footbalTeams
        );

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,
                "Football team: "+footbalTeams[position],
                Toast.LENGTH_LONG).show();

        view.animate().rotationX(360).setDuration(2000).start();
        view.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));

        // Change the text color
        TextView text = (TextView) view.findViewById(android.R.id.text1);
        text.setTextColor(ContextCompat.getColor(this,android.R.color.white));
    }
}
