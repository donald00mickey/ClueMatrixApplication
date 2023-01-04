package com.example.cluematrix;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluematrix.retrofold.RetrofitClient;
import com.example.cluematrix.retrofold.adapter.RecyclerAdapter;
import com.example.cluematrix.retrofold.model.ClueResponse;
import com.example.cluematrix.retrofold.model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiFetchingActivity extends AppCompatActivity {
    //declaring variable
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_fetching);

        //setting up recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //sending it to background thread
        Handler handler = new Handler();
        Runnable runnable = this::getDataFromClient;
        Thread thread = new Thread(() -> handler.post(runnable));
        thread.start();
    }

    //method for network call
    private void getDataFromClient() {
        Call<ClueResponse> call = RetrofitClient.getInstance().getApi().getData();
        call.enqueue(new Callback<ClueResponse>() {
            @Override
            public void onResponse(@NonNull Call<ClueResponse> call, @NonNull Response<ClueResponse> response) {
                assert response.body() != null;
                ClueResponse clueResponse = response.body();
                List<Data> dataList = clueResponse.getData();
                recyclerView.setAdapter(new RecyclerAdapter(dataList));
                Toast.makeText(ApiFetchingActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<ClueResponse> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}