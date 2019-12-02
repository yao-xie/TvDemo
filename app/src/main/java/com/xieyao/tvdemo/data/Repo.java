package com.xieyao.tvdemo.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xieyao.tvdemo.api.ApiClient;
import com.xieyao.tvdemo.models.Channel;
import com.xieyao.tvdemo.models.MovieResult;
import com.xieyao.tvdemo.utils.Utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


public class Repo {

    public List<Channel> getChannels(Context context) {
        String jsonString = Utils.getAssetsJson(context, "main.json");
        Type typeOfObjectsList = new TypeToken<ArrayList<Channel>>() {
        }.getType();
        return new Gson().fromJson(jsonString, typeOfObjectsList);
    }


    public Observable<MovieResult> getSimilarMovies(final int movieId) throws Exception {
        if (0 == movieId) {
            return null;
        }
        return ApiClient.getInstance().getService().getSimilarMovies(movieId);
    }

}
