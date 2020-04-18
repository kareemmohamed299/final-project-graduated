package com.example.project1.professor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SearchView;
import android.widget.TextView;


import com.example.project1.R;
import com.example.project1.connection.questiondoctor;

import java.util.ArrayList;

public class show_heads extends AppCompatActivity implements View.OnLongClickListener {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    showheadsAdapter showheadsAdapter;
    private ArrayList<questiondoctor> qes_doctor = new ArrayList<>();
    private ArrayList<questiondoctor> selection_qes_doctor = new ArrayList<>();
    private Toolbar toolbar;
    int counter =0;
    TextView item_counter;
    SearchView searchView;
     public  boolean iscontexualmodeenable=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_heads);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("MY APP");
        qes_doctor = getIntent().getParcelableArrayListExtra("question_doctor");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(show_heads.this,1);
        recyclerView.setLayoutManager(layoutManager);
        searchView = (SearchView) findViewById(R.id.search_view5);
        item_counter = findViewById(R.id.item_counter);
        item_counter.setText("My App");
        showheadsAdapter = new showheadsAdapter(qes_doctor,show_heads.this);
        recyclerView.setAdapter(showheadsAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                showheadsAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.normal_menu,menu);

        return true;
    }


    @Override
    public boolean onLongClick(View v) {
        iscontexualmodeenable = true;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.contexual_menu);
        getSupportActionBar().setTitle("0 item selected");
        toolbar.setBackgroundColor(Color.GREEN);
        showheadsAdapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    public void MakeSelection(View v , int adapterposition) {
        if(((CheckBox)v).isChecked())
        {
            selection_qes_doctor.add(qes_doctor.get(adapterposition));
            counter ++;
            updatecounter();
        }
        else
        {
            selection_qes_doctor.remove(qes_doctor.get(adapterposition));
            counter --;
            updatecounter();
        }
    }
    public  void updatecounter()
    {
        item_counter.setText(counter+" item selected");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.delete)
        {
            showheadsAdapter.remove(selection_qes_doctor);
            RemoveContexualActionMode();
        }
        /*else if(item.getItemId()==R.id.home)
        {
            RemoveContexualActionMode();
            showheadsAdapter.notifyDataSetChanged();
        }*/
        return true;
    }

    private void RemoveContexualActionMode() {
        iscontexualmodeenable = false;
        item_counter.setText("My App");
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.normal_menu);
        counter = 0;
        selection_qes_doctor.clear();
        showheadsAdapter.notifyDataSetChanged();
        toolbar.setBackgroundColor(Color.GREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


}
