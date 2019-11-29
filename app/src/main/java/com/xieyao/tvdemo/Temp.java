package com.xieyao.tvdemo;

import android.util.Log;

import com.xieyao.tvdemo.data.Repo;
import com.xieyao.tvdemo.models.Channel;
import com.xieyao.tvdemo.models.MovieResult;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Temp {

    private void test() {
        Repo repo = new Repo();
        try {
            repo.getRows(Channel.createDefaultChannels())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<MovieResult>() {
                        @Override
                        public void accept(MovieResult movieResult) throws Exception {
                            Log.e("TEST, onNext", movieResult.toString());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.e("TEST, onError", throwable.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
