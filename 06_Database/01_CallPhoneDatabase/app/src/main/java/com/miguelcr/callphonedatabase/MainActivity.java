package com.miguelcr.callphonedatabase;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelcr.callphonedatabase.db.CallPhone;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<CallPhone> callPhones;

    // callType 0>Incomming, 1>Outgoing, 2>Lost

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ListView component
        lista = (ListView)findViewById(R.id.listViewCallPhones);

        //2. List of elements >>> CallPhone elements
        callPhones = new ArrayList<CallPhone>();

        CallPhone c1 = new CallPhone();
        c1.setContactName("John");
        c1.setTime("1:00am");
        c1.setCallType(1);
        c1.setPhoneNumber("+48611553377");

        CallPhone c2 = new CallPhone();
        c2.setContactName("Mary");
        c2.setTime("2:35pm");
        c2.setCallType(2);
        c2.setPhoneNumber("+48788443377");

        // add the callphone created to the list
        callPhones.add(c1);
        callPhones.add(c2);

        // 3. Adapter
        CallPhoneAdapter adapter = new CallPhoneAdapter(
                this,
                R.layout.call_phone_item,
                callPhones);

        // 4. Connect ListView <-> Adapter
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

        // Connect the long click in ListView with
        // ContextMenu
        registerForContextMenu(lista);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +
                callPhones.get(position).getPhoneNumber()));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_callphone_menu, menu);

        // Customize the ContextMenu title with the current contactName
        AdapterView.AdapterContextMenuInfo info;
        info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(callPhones.get(info.position).getContactName());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete_call:
                //TODO: delete call phone selected

                return true;
            case R.id.send_message:
                //TODO: send message to the phone number selected
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hello, "+callPhones.get(info.position).getContactName());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
