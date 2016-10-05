package com.miguelcr.callphonedatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcr.callphonedatabase.db.CallPhone;

import java.util.List;

/**
 * Created by miguelcampos on 3/10/16.
 */

public class CallPhoneAdapter extends ArrayAdapter<CallPhone> {
    Context ctx;
    int layout;
    List<CallPhone> values;

    public CallPhoneAdapter(Context context, int resource,
                            List<CallPhone> objects) {

        super(context, resource, objects);
        ctx = context;
        layout = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(layout, parent, false);

        // 1. find the different components
        ImageView typeIcon = (ImageView) v.findViewById(R.id.imageViewCallType);
        TextView contactNameText = (TextView) v.findViewById(R.id.textViewContactName);
        TextView phoneNumberText = (TextView) v.findViewById(R.id.textViewPhoneNumber);
        TextView callTimeText = (TextView) v.findViewById(R.id.textViewTime);

        // 2. Get the current item to draw
        CallPhone current = values.get(position);

        // 3. Set the information in the view components
        contactNameText.setText(current.getContactName());
        phoneNumberText.setText(current.getPhoneNumber());
        callTimeText.setText(current.getTime());

        switch (current.getCallType()) {
            case 0: typeIcon.setImageResource(R.drawable.ic_phone_in);
                break;
            case 1: typeIcon.setImageResource(R.drawable.ic_phone_out);
                break;
            case 2: typeIcon.setImageResource(R.drawable.ic_phone_lost);
                break;
        }

        return v;

    }
}
