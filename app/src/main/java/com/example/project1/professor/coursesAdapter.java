package com.example.project1.professor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.google.android.material.snackbar.Snackbar;

public class coursesAdapter extends RecyclerView.Adapter<coursesAdapter.ViewHolder> {





private String[] titles = {"comp",
        "comp",
        "comp",
        "comp",
        "comp",
        "comp","comp",
        "comp","comp",
        "comp"
        };


private String[] titles3 = {"303",
        "305",
        "204",
        "311",
        "202",
        "205","302",
        "309","301",
        "304"
        };


private String[] details = {"Artifical\nIntelligence",
        "Cryptography", "Advanced\nCompiler",
        "Image\nProcessing", "Cyper\nSecurity",
        "Software\nEngineering", "Design\nAlgorithm",
        "Advanced\nProgramming", "Computer\nGraphic",
        "Multimedia"};

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
    public TextView itemTitle;
    public TextView itemTitle3;
    public TextView itemDetail;

    public ViewHolder(View itemView) {
        super(itemView);
        itemImage = (ImageView)itemView.findViewById(R.id.item_image);
        itemTitle = (TextView)itemView.findViewById(R.id.item_title);
        itemTitle3 = (TextView)itemView.findViewById(R.id.course_code);

        itemDetail =
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
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemTitle3.setText(titles3[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}





