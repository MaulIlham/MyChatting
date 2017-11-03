package com.example.schiffers.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.schiffers.chatting.adapter.chatAdapter;
import com.example.schiffers.chatting.models.chat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<chat> mData = new ArrayList<chat>();
    private SharedPreference sharedPreference;
    Activity context=this;
    //deklarasi variabel reyclerview
    RecyclerView recyc;
    chatAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //-----

        recyc=(RecyclerView)findViewById(R.id.recycler);
        sharedPreference=new SharedPreference();
        mData=sharedPreference.getValue(context);
        ad=new chatAdapter(this,mData);
        recyc.setAdapter(ad);
        recyc.setLayoutManager(new LinearLayoutManager(this));



        //------------
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            CreateMes(view);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

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

    public void CreateMes(View view) {
        sharedPreference.clearSharedPrefence(this);
        sharedPreference.removeSharedPrefence(this);
        sharedPreference.save(this,mData);
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
