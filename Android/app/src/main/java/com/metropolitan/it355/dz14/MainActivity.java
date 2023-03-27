package com.metropolitan.it355.dz14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.metropolitan.it355.dz14.client.RetrofitClient;
import com.metropolitan.it355.dz14.model.Member;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView idTextView;
    TextView nameTextView;
    TextView phoneTextView;
    TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idTextView = findViewById(R.id.idTextView);
        nameTextView = findViewById(R.id.nameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        emailTextView = findViewById(R.id.emailTextView);

        fetchData();
    }

    private void fetchData() {
        // TODO: 27.3.2023. fetch
        Call<Member> call = RetrofitClient.getInstance().getMyApi().getMember(1);
        call.enqueue(new Callback<Member>() {
            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {
                Member member = response.body();

                idTextView.setText(Integer.toString(member.getId()));
                nameTextView.setText(member.getName());
                phoneTextView.setText(member.getPhone());
                emailTextView.setText(member.getEmail());
            }

            @Override
            public void onFailure(Call<Member> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}