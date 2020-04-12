package com.example.project1.correction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.project1.R;
import com.example.project1.questions.question;

public class result extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);


        recyclerView =
                (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new GridLayoutManager(result.this,3);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new answerAdapter();
        recyclerView.setAdapter(adapter);

    }


}
