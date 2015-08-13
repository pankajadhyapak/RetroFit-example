package me.pankajadhyapak.ottoeventbus.Api;

import java.util.List;

import me.pankajadhyapak.ottoeventbus.Model.GitModel;
import me.pankajadhyapak.ottoeventbus.Model.Repo;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by PA035636 on 8/11/2015.
 */
public interface GitApi {

    @GET("/users/{user}")
    public void getUserDetails(@Path("user") String user, Callback<GitModel> response);

    @GET("/users/{user}/repos")
    public void getUserRepo(@Path("user") String user, Callback<List<Repo>> response);

}
