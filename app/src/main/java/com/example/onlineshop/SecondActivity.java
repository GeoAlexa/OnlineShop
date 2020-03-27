package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void onSaveData(View view) {
        File file = new File(this.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "data_out.txt");
        FileOutputStream outputStream = null;
        try {
            String str = "SAVED_DATA";

            outputStream = new FileOutputStream(file);
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

