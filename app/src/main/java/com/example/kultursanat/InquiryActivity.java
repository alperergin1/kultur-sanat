package com.example.kultursanat;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InquiryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        ListView listView = findViewById(R.id.listView2);

        // Örnek öğe listesi oluştur
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("Hyundai / Accend / Blue / 1.3");

        // ArrayAdapter oluştur ve ListView'a bağla
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);
    }
}
