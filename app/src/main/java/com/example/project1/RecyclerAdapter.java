package com.example.project1;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.connection.cource;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<cource> course1 = new ArrayList<>();
    private Context mContext;
    private int item;
public RecyclerAdapter(ArrayList<cource> course, Context  context)
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
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView course_code;
        public TextView course_name;
        public CardView card_view;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            course_code = (TextView)itemView.findViewById(R.id.course_code);
            course_name = (TextView)itemView.findViewById(R.id.course_name);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent myIntent = new Intent(courses_demo.this.getActivity(), course_info.class);
                    startActivity(myIntent);
                }
            });*/
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
        cource cource1 = course1.get(i);
        viewHolder.itemTitle.setText("comp");
        viewHolder.course_code.setText(cource1.getCode());
        viewHolder.course_name.setText(cource1.getName());
        viewHolder.itemImage.setImageResource(images[i]);

        viewHolder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, course_info.class);
                mContext.startActivity(intent);
            }
        });


    }
    @Override
    public int getItemCount() {
        return course1.size();
    }

}





