package com.example.pauljs.dapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ArrayList<String> list;
    private ListView listView;
    private ListAdapter adapter;
    private Button view_results_button;
    private Button final_info_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();
        Date date = new Date();
        List<Notification> notifications = Notification.getSortedNotifications();
        for(Notification notification : notifications) {
            list.add(notification.message);
        }

        String[] array = new String[] {};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.toArray(array));
        listView.setAdapter(adapter);

//        view_results_button = (Button) findViewById(R.id.view_results_button);
//        view_results_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CombinedChartActivity.class);
//                startActivity(intent);
//            }
//        });
//        final_info_button = (Button) findViewById(R.id.button2);
//        final_info_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Final_Info.class);
//                startActivity(intent);
//            }
//        });
//        Log.i("Date 1", date.toString());
//        Log.i("Date 2", new Date(2015 - 1900,1,1).toString());
//        Log.i("Compare", date.before(new Date(2015 - 1900,10,8)) + "");
//        if(date.after(new Date(2015 - 1900,10,8))) {
//            final_info_button.setVisibility(View.VISIBLE);
//        } else {
//            final_info_button.setVisibility(View.INVISIBLE);
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = this.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
