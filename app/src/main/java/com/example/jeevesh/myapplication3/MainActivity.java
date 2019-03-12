package com.example.jeevesh.myapplication3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeevesh.myapplication3.model.Response;
import com.example.jeevesh.myapplication3.retrofit.WebAPIHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.internal.DiskLruCache;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText name;
    private EditText age;
    private EditText phone;
    private Button button;
    private ProgressDialog progressDialog;
    private WebAPIHelper webAPIHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), ViewPagerActivity.class);
        startActivity(intent);
        init();
        finish();
        setSharprefval();
    }

    // saving shared preferences example data
    private void editSharPref(String name, String age, String phone){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (name!=null)
            editor.putString("name", name);
        if (age!=null)
            editor.putString("age", age);
        if (phone!=null)
            editor.putString("phone", phone);

        editor.commit();
    }

    public void sendData(View view){

                if (name.getText().toString().isEmpty() && age.getText().toString().isEmpty() && phone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter some values first!", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Sending data");
                    progressDialog.show();

                    webAPIHelper.getData(new Callback<Response>() {

                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            progressDialog.dismiss();
                            Response res = response.body();
                            if (res.getData()!=null) {
                                Toast.makeText(MainActivity.this, res.getData().getName() + "," + res.getData().getAge() + "," + res.getData().getPhone(), Toast.LENGTH_SHORT).show();
                                editSharPref(res.getData().getName(), res.getData().getAge(), res.getData().getPhone());
                            } else {
                                Toast.makeText(MainActivity.this, res.getName() +","+ res.getAge()+","+res.getPhone(), Toast.LENGTH_SHORT).show();
                                editSharPref(res.getName(), res.getAge(), res.getPhone());
                            }
                            setSharprefval();
                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Sending Data Failed", Toast.LENGTH_SHORT).show();
                            t.printStackTrace();
                        }
                    }, name.getText().toString(), age.getText().toString(), phone.getText().toString());                }


        }

    private void setSharprefval(){
        name.setHint(sharedPreferences.getString("name", "name"));
        age.setHint(sharedPreferences.getString("age", "age"));
        phone.setHint(sharedPreferences.getString("phone", "phone"));
    }

    private void init(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        webAPIHelper = new WebAPIHelper();
        webAPIHelper.init(MainActivity.this);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        button = findViewById(R.id.button);
    }
}
