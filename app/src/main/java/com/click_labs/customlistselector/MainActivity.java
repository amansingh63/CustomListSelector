package com.click_labs.customlistselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.click_labs.customlistselector.responsemodel.CommonData;
import com.click_labs.customlistselector.retrofitclient.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        ((Button) findViewById(R.id.button)).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        RetrofitClient.getApiInterface().getCommonData().enqueue(new Callback<CommonData>() {
            @Override
            public void onResponse(Call<CommonData> call, Response<CommonData> response) {

                if (list.size() > 0) {
                    list.clear();
                }
                for (int i = 0; i < response.body().getSTATESAPP().size(); i++) {
                    list.add((response.body().getSTATESAPP().get(i).getStateName()));
                }
                showDialogue();

            }

            @Override
            public void onFailure(Call<CommonData> call, Throwable t) {

            }
        });


    }

    private void showDialogue() {
        CustomListSelector.showCustomListSelector(this, list).setMessage("Select State").show(new CustomListAdapter.OnListItemSelectedListener() {
            @Override
            public void onListItemSelected(int position, String listItem) {
                Toast.makeText(MainActivity.this, listItem, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
