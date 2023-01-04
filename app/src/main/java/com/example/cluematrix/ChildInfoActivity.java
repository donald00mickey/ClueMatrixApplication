package com.example.cluematrix;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluematrix.retrofold.adapter.InformationRecyclerAdapter;
import com.example.cluematrix.retrofold.adapter.SliderAdapter;
import com.example.cluematrix.retrofold.adapter.SubjectRecyclerAdapter;
import com.example.cluematrix.retrofold.model.Informations;
import com.example.cluematrix.retrofold.model.Subjects;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class ChildInfoActivity extends AppCompatActivity {
    //declaring vies
    RecyclerView subjectsRecyclerView;
    RecyclerView informationRecyclerView;
    ArrayList<Subjects> subjectsArrayList = new ArrayList<>();
    ArrayList<Informations> informationArrayList = new ArrayList<>();
    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_info);

        //initializing views
        subjectsRecyclerView = findViewById(R.id.subjectsRecyclerView);
        informationRecyclerView = findViewById(R.id.informationRecyclerView);
        sliderView = findViewById(R.id.image_slider);

        //method for holding data in image slider
        getSlider();
        //method for holding data in subject model class
        setSubjectInViewHolder();
        //method for holding data in information model class
        setInformationInViewHolder();
    }

    //for showing images in slider
    private void getSlider() {
        String url1 = "https://images.pexels.com/photos/695644/pexels-photo-695644.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
        String url2 = "https://images.pexels.com/photos/952670/pexels-photo-952670.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
        String url3 = "https://images.pexels.com/photos/623147/pexels-photo-623147.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
        String[] images = {url1, url2, url3};
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SWAP);
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.startAutoCycle();
    }

    //for showing subjects in recycler view
    private void setSubjectInViewHolder() {
        subjectsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ChildInfoActivity.this, LinearLayoutManager.HORIZONTAL, false);
        subjectsRecyclerView.setLayoutManager(layoutManager);
        subjectsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        subjectsArrayList.add(new Subjects("Marathi"));
        subjectsArrayList.add(new Subjects("Hindi"));
        subjectsArrayList.add(new Subjects("English"));
        subjectsArrayList.add(new Subjects("Science"));
        subjectsArrayList.add(new Subjects("Mathematics"));
        subjectsArrayList.add(new Subjects("History"));
        subjectsArrayList.add(new Subjects("Geography"));
        subjectsRecyclerView.setAdapter(new SubjectRecyclerAdapter(subjectsArrayList));
    }

    //for showing information about children's classes
    private void setInformationInViewHolder() {
        informationRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        informationRecyclerView.setLayoutManager(layoutManager);
        informationRecyclerView.setItemAnimator(new DefaultItemAnimator());

        informationArrayList.add(new Informations(R.drawable.ic_assignment, R.drawable.right_arrow_ic, "Assignment"));
        informationArrayList.add(new Informations(R.drawable.ic_teacher, R.drawable.right_arrow_ic, "Teachers"));
        informationArrayList.add(new Informations(R.drawable.ic_attendance, R.drawable.right_arrow_ic, "Attendance"));
        informationArrayList.add(new Informations(R.drawable.ic_timetable, R.drawable.right_arrow_ic, "Timetable"));
        informationArrayList.add(new Informations(R.drawable.ic_holidays, R.drawable.right_arrow_ic, "Holidays"));
        informationArrayList.add(new Informations(R.drawable.ic_exam, R.drawable.right_arrow_ic, "Exam"));
        informationArrayList.add(new Informations(R.drawable.ic_result, R.drawable.right_arrow_ic, "Result"));
        informationRecyclerView.setAdapter(new InformationRecyclerAdapter(informationArrayList));
    }
}