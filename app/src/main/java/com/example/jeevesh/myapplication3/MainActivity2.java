package com.example.jeevesh.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jeevesh.myapplication3.model.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.hobbiesList);

        ArrayList<Response> arrayList = new ArrayList<>();

        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));
        arrayList.add(new Response("hashj", "9070498"));

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), arrayList);
        listView.setAdapter(customAdapter);

        }
}
