package com.example.schiffers.chatting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.schiffers.chatting.adapter.chatAdapter;
import com.example.schiffers.chatting.models.chat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    List<chat> mData = new ArrayList<chat>();

    EditText namaku;
    EditText chatku;
    Calendar c1= Calendar.getInstance();
    SimpleDateFormat sdf1=new SimpleDateFormat("d/M/yyy");
    String waktu;
    String nama;
    String chating;
    Integer foto=R.drawable.player;
    private SharedPreference sharedPreference;
    Activity context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        namaku=(EditText)findViewById(R.id.edtusr);
        chatku=(EditText)findViewById(R.id.edtmes);
        sharedPreference=new SharedPreference();
        mData=sharedPreference.getValue(context);

    }
    public void isidata(Integer poto,String nama, String chat, String tangal )
    {
        mData.add(new chat(poto,nama,chat,tangal));
    }

    public void kirimPesan(View view) {

        waktu=sdf1.format(c1.getTime()).toString();
        nama=namaku.getText().toString();
        chating=chatku.getText().toString();
        isidata(foto,nama,chating,waktu);
        sharedPreference.clearSharedPrefence(context);
        sharedPreference.removeSharedPrefence(context);
        sharedPreference.save(context,mData);
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);

        startActivity(intent);
    }

}
