package com.example.evaluacioncontinuav3.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.evaluacioncontinuav3.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AutoEntry {
    private static final String TAG = AutoEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String price;
    public final String description;

    public AutoEntry(String title, String dynamicUrl, String url, String price, String description) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.price = price;
        this.description = description;
    }

    public static List<AutoEntry> initProductEntryList (Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.autos);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON");
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo error al cerrar el input stream", exception);
            }
        }

        String jsonProductsString = writer.toString();
        Gson gson = new Gson();
        Type productListType = new TypeToken<ArrayList<AutoEntry>>(){

        }.getType();

        return gson.fromJson(jsonProductsString, productListType);
    }
}
