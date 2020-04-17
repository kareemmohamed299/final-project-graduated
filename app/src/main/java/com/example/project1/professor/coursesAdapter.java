package com.example.project1.professor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

import com.example.project1.connection.cource;
import com.example.project1.connection.doctor_course;
import com.example.project1.connection.retrofit;
import com.example.project1.connection.student_doctor;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class coursesAdapter extends RecyclerView.Adapter<coursesAdapter.ViewHolder> {

    private ArrayList<doctor_course> course1 = new ArrayList<>();
    private ArrayList<String> doctor1 = new ArrayList<>();
    private ArrayList<student_doctor> st_doctor = new ArrayList<>();
    private Context mContext;

    public coursesAdapter(ArrayList<doctor_course> course, ArrayList<String> doctor, Context context) {
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

            course_name =
                    (TextView) itemView.findViewById(R.id.course_name);


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

        viewHolder.itemTitle.setText("comp");
        viewHolder.course_code.setText(course1.get(i).getCode());
        viewHolder.course_name.setText(course1.get(i).getName());
        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                retrofit.getINSTANCE().getApi().getstudent_doctor("1", viewHolder.course_code.getText().toString(), doctor1.get(5)  ).
                        enqueue(new Callback<List<student_doctor>>() {
                            @Override
                            public void onResponse(Call<List<student_doctor>> call, Response<List<student_doctor>> response) {
                                if(response.isSuccessful())
                                {
                                    for (int i = 0; i < response.body().size(); i++)
                                    {
                                        st_doctor.add(i, response.body().get(i));
                                    }

                                    go();
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
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return course1.size();
    }


    public void go() {
        Intent myIntent = new Intent(mContext, course_info_prof.class);
        myIntent.putParcelableArrayListExtra("student_doctor",st_doctor);
        mContext.startActivity(myIntent);
    }
}


