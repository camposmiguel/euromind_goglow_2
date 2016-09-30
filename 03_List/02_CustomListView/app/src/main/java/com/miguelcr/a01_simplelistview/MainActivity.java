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

        FootballTeam leicester = new FootballTeam(
                R.drawable.ic_leicester_city,
                "Leicester City FC",
                "London, UK"
        );

        FootballTeam barcelona = new FootballTeam(
                R.drawable.ic_barcelona,
                "Barça FC",
                "Barcelona, Spain"
        );

        FootballTeam madrid = new FootballTeam(
                R.drawable.ic_madrid,
                "Real Madrid CF",
                "Madrid, Spain"
        );

        footbalTeams.add(leicester);
        footbalTeams.add(barcelona);
        footbalTeams.add(madrid);


        // 3. Adapter to show String[] in ListView
        FootballTeamAdapter adapter = new FootballTeamAdapter(
                MainActivity.this,
                R.layout.football_team_item,
                footbalTeams
        );

        lista.setAdapter(adapter);

    }


}
