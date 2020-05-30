package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<example> exampleList;

    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateFakeData();
        recyclerViewConfig();
    }

    public void generateFakeData(){
         exampleList = new ArrayList<>();
        exampleList.add(new example("Cricket",R.drawable.cricket));
        exampleList.add(new example("Football",R.drawable.football));
        exampleList.add(new example("Badminton",R.drawable.badminton));
        exampleList.add(new example("Cycling",R.drawable.cycling));
        exampleList.add(new example("Volleyball",R.drawable.volleyball));
        exampleList.add(new example("Lawn Tennis",R.drawable.lawntennis));
        exampleList.add(new example("Chudia Ud",R.drawable.chudiaud));
    }

    public void recyclerViewConfig() {
        //Config for RV
        recyclerView = findViewById(R.id.recyclerView);
        //Performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

}
