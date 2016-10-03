package com.miguelcr.a01_simplelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 30/9/16.
 */

public class FootballTeamAdapter extends ArrayAdapter {
    Context ctx;
    int layoutResource;
    List<FootballTeam> items;


    public FootballTeamAdapter(Context context, int resource, List<FootballTeam> objects) {
        super(context, resource, objects);

        ctx = context;
        layoutResource = resource;
        items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutWithValues = inflater.inflate(layoutResource, parent, false);

        // Get the information for the current FootballTeam
        FootballTeam current = items.get(position);
        String logo = current.getLogo();
        String name = current.getName();
        String city = current.getCity();

        // SEt the info in our view components
        ImageView imageViewLogo = (ImageView)layoutWithValues
                .findViewById(R.id.imageViewLogo);
        TextView textViewName = (TextView)layoutWithValues
                .findViewById(R.id.textViewName);
        TextView textViewCity = (TextView)layoutWithValues
                .findViewById(R.id.textViewCity);

        Picasso.with(ctx)
                .load(logo)
                .resize(96, 96)
                .into(imageViewLogo);

        textViewName.setText(name);
        textViewCity.setText(city);

        return layoutWithValues;
    }
}
