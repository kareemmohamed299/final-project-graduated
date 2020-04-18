package com.example.project1.professor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
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
    SearchView searchView;
    int counter =0;
    TextView item_counter;
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
      //  searchView = (SearchView) findViewById(R.id.search_view1);
        item_counter = findViewById(R.id.item_counter);
        item_counter.setText("My App");
        showheadsAdapter = new showheadsAdapter(qes_doctor,show_heads.this);
        recyclerView.setAdapter(showheadsAdapter);
        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                showheadsAdapter.getFilter().filter(newText);
                return false;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contexual_menu,menu);

        return true;
    }


    @Override
    public boolean onLongClick(View v) {
        iscontexualmodeenable = true;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.contexual_menu);
        toolbar.setBackgroundColor(Color.GREEN);
        showheadsAdapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return  true;
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
        item_counter.setText(counter+" itemselected");
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
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
        toolbar.inflateMenu(R.menu.contexual_menu);
        counter = 0;
        selection_qes_doctor.clear();
        showheadsAdapter.notifyDataSetChanged();
        toolbar.setBackgroundColor(Color.GREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


}
