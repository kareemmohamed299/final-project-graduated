package com.example.project1.professor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

import com.example.project1.connection.doctor_course;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class coursesAdapter extends RecyclerView.Adapter<coursesAdapter.ViewHolder> {

    private ArrayList<doctor_course> course1 = new ArrayList<>();
    private Context mContext;

    public coursesAdapter(ArrayList<doctor_course> course, Context context)
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

    public ImageView itemImage;

    private TextView course_code, course_name,itemTitle;
    public ViewHolder(View itemView) {

        super(itemView);
        itemImage = (ImageView)itemView.findViewById(R.id.item_image);
        itemTitle = (TextView)itemView.findViewById(R.id.item_title);
        course_code = (TextView)itemView.findViewById(R.id.course_code);

        course_name =
                (TextView)itemView.findViewById(R.id.course_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int position = getAdapterPosition();

                Snackbar.make(v, "Click detected on item " + position,
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
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
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.itemTitle.setText("comp");
        viewHolder.course_code.setText(course1.get(i).getCode());
        viewHolder.course_name.setText(course1.get(i).getName());
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return course1.size();
    }
}





