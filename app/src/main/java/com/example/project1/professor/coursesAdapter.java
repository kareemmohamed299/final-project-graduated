package com.example.project1.professor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;
import com.example.project1.connection.cource;
import java.util.ArrayList;
public class coursesAdapter extends RecyclerView.Adapter<coursesAdapter.ViewHolder> {
    private ArrayList<cource> course1;
    private ArrayList<String> doctor1;
    private Context mContext;
    public coursesAdapter(ArrayList<cource> course, ArrayList<String> doctor, Context context) {
        this.course1 = course;
        mContext = context;
        this.doctor1 = doctor;
    }
    private int[] images = {R.drawable.circle1,
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
    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        private TextView course_code, course_name, itemTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            course_code = (TextView) itemView.findViewById(R.id.course_code);
            course_name = (TextView) itemView.findViewById(R.id.course_name);
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
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

        viewHolder.itemTitle.setText("comp");
        viewHolder.course_code.setText(course1.get(i).getCode());
        viewHolder.course_name.setText(course1.get(i).getName());
        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent myIntent = new Intent(mContext, course_info_prof.class);
                myIntent.putExtra("coursedata",course1.get(i));
                myIntent.putStringArrayListExtra("doctordata",doctor1);
                mContext.startActivity(myIntent);
                /*retrofit.getINSTANCE().getApi().getstudent_doctor( viewHolder.course_code.getText().toString(), doctor1.get(5)  ).
                        enqueue(new Callback<List<student_doctor>>() {
                            @Override
                            public void onResponse(Call<List<student_doctor>> call, Response<List<student_doctor>> response) {
                                if(response.isSuccessful())
                                {
                                    for (int i = 0; i < response.body().size(); i++)
                                    {
                                        st_doctor.add(i, response.body().get(i));
                                    }
                                    retrofit.getINSTANCE().getApi().getquestiondoctor(doctor1.get(5),viewHolder.course_code.getText().toString()).
                                            enqueue(new Callback<List<questiondoctor>>() {
                                                @Override
                                                public void onResponse(Call<List<questiondoctor>> call, Response<List<questiondoctor>> response) {
                                                    if(response.isSuccessful())
                                                    {
                                                        for (int i = 0; i < response.body().size(); i++)
                                                        {
                                                            qes_doctor.add(i , response.body().get(i));
                                                        }
                                                        go();
                                                    }
                                                    else
                                                    {
                                                        Snackbar.make(v, "55555555555555" ,Snackbar.LENGTH_LONG)
                                                                .setAction("Action", null).show();
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<List<questiondoctor>> call, Throwable t) {
                                                    Snackbar.make(v, t.getMessage() ,Snackbar.LENGTH_LONG)
                                                            .setAction("Action", null).show();

                                                }
                                            });


                                }
                                else
                                    {
                                    Snackbar.make(v, "NO data" ,Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    }
                            }
                            @Override
                            public void onFailure(Call<List<student_doctor>> call, Throwable t) {
                                Snackbar.make(v, t.getMessage() ,Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                        });*/
            }
        });
    }
    @Override
    public int getItemCount() {
        return course1.size();
    }
}


