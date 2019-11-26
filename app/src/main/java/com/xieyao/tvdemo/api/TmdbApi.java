package com.xieyao.tvdemo.api;

import com.xieyao.tvdemo.models.MovieResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xieyao on 2019-10-11.
 */
public interface TmdbApi {

    @GET("{path1}/{path2}?")
    Observable<MovieResult> getPopularMovies(@Path("path1") String p1, @Path("path2") String p2, @Query("page") int page);

}
