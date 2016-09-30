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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ListView lista;
    List<FootballTeam> footbalTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ListView Component
        lista = (ListView) findViewById(R.id.listViewFootballTeams);

        // 2. An array of data
        footbalTeams = new ArrayList<FootballTeam>();

        footbalTeams.add(new FootballTeam(
                "https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_(crest).svg/1010px-FC_Barcelona_(crest).svg.png",
                "Leicester City FC",
                "London, UK"
        ));
        footbalTeams.add(new FootballTeam(
                "https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_(crest).svg/1010px-FC_Barcelona_(crest).svg.png",
                "Barça FC",
                "Barcelona, Spain"
        ));
        footbalTeams.add(new FootballTeam(
                "https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_(crest).svg/1010px-FC_Barcelona_(crest).svg.png",
                "Real Madrid CF",
                "Madrid, Spain"
        ));


        // 3. Adapter to show String[] in ListView
        FootballTeamAdapter adapter = new FootballTeamAdapter(
                MainActivity.this,
                R.layout.football_team_item,
                footbalTeams
        );

        lista.setAdapter(adapter);

    }


}
