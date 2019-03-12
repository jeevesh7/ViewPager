package com.example.jeevesh.myapplication3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeevesh.myapplication3.model.Response;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Response> {

    public CustomAdapter(@NonNull Context context, ArrayList<Response> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_list_item, parent, false);
        }

        final Response response = getItem(position);
        TextView name = convertView.findViewById(R.id.name);
        name.setText(response.getName());
        TextView phone = convertView.findViewById(R.id.phone);
        phone.setText(response.getPhone());

        final CustomAdapter customAdapter = this;
        Button button = convertView.findViewById(R.id.delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAdapter.remove(response);
                customAdapter.notifyDataSetChanged();
            }
        });

    return convertView;
    }

}
