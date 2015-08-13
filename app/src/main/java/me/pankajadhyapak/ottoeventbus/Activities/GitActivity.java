package me.pankajadhyapak.ottoeventbus.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.pankajadhyapak.ottoeventbus.Api.GitApi;
import me.pankajadhyapak.ottoeventbus.Model.GitModel;
import me.pankajadhyapak.ottoeventbus.Model.Repo;
import me.pankajadhyapak.ottoeventbus.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GitActivity extends ActionBarActivity {

    Button click;
    EditText edit_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git);

        click = (Button)findViewById(R.id.button);
        edit_user = (EditText) findViewById(R.id.edit);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edit_user.getText().toString();
                if(user.isEmpty()){
                    Toast.makeText(GitActivity.this,"Enter User Name",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(GitActivity.this, RepoListActivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }
            }
        });


//

//            click = (Button) findViewById(R.id.button);
//            tv = (TextView) findViewById(R.id.tv);
//            edit_user = (EditText) findViewById(R.id.edit);
//            pbar = (ProgressBar) findViewById(R.id.pb);
//            pbar.setVisibility(View.INVISIBLE);
//            click.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String user = edit_user.getText().toString();
//                    pbar.setVisibility(View.VISIBLE);
//                    RestAdapter restAdapter = new RestAdapter.Builder()
//                            .setEndpoint(API).build();
//                    GitApi git = restAdapter.create(GitApi.class);
////                    git.getUserDetails(user, new Callback<GitModel>() {
////                        @Override
////                        public void success(GitModel gitmodel, Response response) {
////                            tv.setText("Github Name :" + gitmodel.getName() + "\nWebsite :" + gitmodel.getBlog() + "\nCompany Name :" + gitmodel.getCompany());
////                            pbar.setVisibility(View.INVISIBLE);
////                        }
////
////                        @Override
////                        public void failure(RetrofitError error) {
////                            tv.setText(error.getMessage());
////                            pbar.setVisibility(View.INVISIBLE);
////                        }
////                    });
//
//                    git.getUserRepo(user, new Callback<Repo>() {
//
//                        @Override
//                        public void success(Repo repo, Response response) {
//
//                        }
//
//                        @Override
//                        public void failure(RetrofitError error) {
//
//                        }
//                    });
//
//                }
//            });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_git, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
