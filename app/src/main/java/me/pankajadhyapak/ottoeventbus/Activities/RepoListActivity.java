package me.pankajadhyapak.ottoeventbus.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.pankajadhyapak.ottoeventbus.Api.GitApi;
import me.pankajadhyapak.ottoeventbus.Model.Repo;
import me.pankajadhyapak.ottoeventbus.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by PA035636 on 8/11/2015.
 */
public class RepoListActivity extends ActionBarActivity {
    ProgressBar pbar;
    String API = "https://api.github.com";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewactivity);

        pbar = (ProgressBar)findViewById(R.id.pb);

        Intent intent = getIntent();

        String username = intent.getStringExtra("username");
        pbar.setVisibility(View.VISIBLE);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API)
                .build();

        GitApi service = restAdapter.create(GitApi.class);


        service.getUserRepo(username, new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                pbar.setVisibility(View.INVISIBLE);
                ListView listView = (ListView)findViewById(R.id.listView);

                ArrayList<String> repo = new ArrayList<>(repos.size());
                for(Repo r : repos){
                    repo.add(r.getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (RepoListActivity.this, android.R.layout.simple_list_item_1, repo);
                listView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                pbar.setVisibility(View.INVISIBLE);
                Toast.makeText(RepoListActivity.this, "oops !! Something Went Wrong ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
