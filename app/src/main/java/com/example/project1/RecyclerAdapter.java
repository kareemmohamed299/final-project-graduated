package com.example.project1;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.connection.Api;
import com.example.project1.connection.cource;
import com.example.project1.connection.retrofit;
import com.example.project1.connection.student;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.core.content.ContextCompat.startActivity;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<cource> course1 = new ArrayList<>();
    private Context mContext;
    private ArrayList<String>c;
RecyclerAdapter(ArrayList<cource> course, Context context)
{
    this.course1 = course;
    mContext = context;
}
 private int[] images = { R.drawable.circle1,
            R.drawable.circle2,
            R.drawable.circle3,
            R.drawable.circle4,
            R.drawable.circle5,
            R.drawable.circle1,
            R.drawable.circle2,
            R.drawable.circle3,
            R.drawable.circle4,
            R.drawable.circle5
           };
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemImage;
        private TextView course_code, course_name,itemTitle;
        private CardView card_view;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            course_code = (TextView)itemView.findViewById(R.id.course_code);
            course_name = (TextView)itemView.findViewById(R.id.course_name);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.course_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        cource cource1 = course1.get(i);
        viewHolder.itemTitle.setText("comp");
        viewHolder.course_code.setText(cource1.getCode());
        viewHolder.course_name.setText(cource1.getName());
        viewHolder.itemImage.setImageResource(images[i]);

        viewHolder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                retrofit.getINSTANCE().getApi().courcedata(viewHolder.course_code.getText().toString())
                        .enqueue(new Callback<cource>(){
                    @Override
                    public void onResponse(Call<cource> call, Response<cource> response) {
                        if(response.isSuccessful())
                        {
                           cource cource = response.body();
                            c = new ArrayList<String>();
                             assert cource != null;
                            c.add(cource.getDuration());
                            c.add(cource.getEx_start());
                            c.add(cource.getEx_end());
                            c.add(cource.getDegree());
                            c.add(cource.getExam_name());
                            c.add(cource.getFname());
                            c.add(cource.getMname());
                            c.add(cource.getLname());
                            c.add(cource.getIdexam());
                            open();
                        }
                        else{
                            Snackbar.make(view, "NO data" ,Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();}
                        }
                    @Override
                    public void onFailure(Call<cource> call, Throwable t) {
                        Snackbar.make(view, t.getMessage() ,Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });

            }
        });


    }
    @Override
    public int getItemCount() {
        return course1.size();
    }
    public void open()
    {
        Intent intent = new Intent(mContext, course_info.class);
        intent.putStringArrayListExtra("c",c);
         mContext.startActivity(intent);
    }

}





