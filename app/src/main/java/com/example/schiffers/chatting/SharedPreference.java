package com.example.schiffers.chatting;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Contacts;

import com.example.schiffers.chatting.models.chat;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SharedPreference {
    public static final  String PREFS_NAME="AOP_PREF";
    public static final  String PREFS_KEY="AOP_PREF_list";
    public SharedPreference()
    {
        super();
    }
    public void save(Context context,List<chat> list){
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor=settings.edit();
        Gson gson=new Gson();
        String jsonchat=gson.toJson(list);
        editor.putString(PREFS_KEY,jsonchat);
        editor.commit();
    }
    public ArrayList<chat> getValue(Context context)
    {
        SharedPreferences settings;
        List<chat> list;
        settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        if(settings.contains(PREFS_KEY))
        {
            String jsonchat=settings.getString(PREFS_KEY,null);
            Gson gson=new Gson();
            chat[] chatitem=gson.fromJson(jsonchat, chat[].class);
            list= Arrays.asList(chatitem);
            list=new ArrayList<chat>(list);
        }
        else
        {
            return null;
        }

        return  (ArrayList<chat>) list;


    }

    public void clearSharedPrefence(Context context)
    {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor=settings.edit();
        editor.clear();
        editor.commit();
    }

    public void removeSharedPrefence(Context context)
    {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor=settings.edit();
        editor.remove(PREFS_KEY);
        editor.commit();
    }

}