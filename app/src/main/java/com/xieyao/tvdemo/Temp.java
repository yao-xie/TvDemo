package com.xieyao.tvdemo;

import android.text.TextUtils;

import com.xieyao.tvdemo.api.ApiClient;
import com.xieyao.tvdemo.models.MovieResult;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Temp {

//    private void test() {
//        Repo repo = new Repo();
//        try {
//            repo.getRows(Channel.createDefaultChannels())
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Consumer<MovieResult>() {
//                        @Override
//                        public void accept(MovieResult movieResult) throws Exception {
//                            Log.e("TEST, onNext", movieResult.toString());
//                        }
//                    }, new Consumer<Throwable>() {
//                        @Override
//                        public void accept(Throwable throwable) throws Exception {
//                            Log.e("TEST, onError", throwable.getMessage());
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public Observable<MovieResult> getResults(final int index) throws Exception {
        String path1 = null;
        String path2 = null;
        switch (index) {
            case 0: {
                path1 = "movie";
                path2 = "popular";
                break;
            }
            case 1: {
                path1 = "movie";
                path2 = "top_rated";
                break;
            }
            case 2: {
                path1 = "movie";
                path2 = "upcoming";
                break;
            }
            case 3: {
                path1 = "tv";
                path2 = "on_the_air";
                break;
            }
            case 4: {
                path1 = "tv";
                path2 = "popular";
                break;
            }
            case 5: {
                path1 = "tv";
                path2 = "top_rated";
                break;
            }
        }
        if (TextUtils.isEmpty(path1) || TextUtils.isEmpty(path2)) {
            return null;
        }
        return ApiClient.getInstance().getService().getMovies(path1, path2, 1)
                .flatMap(new Function<MovieResult, ObservableSource<MovieResult>>() {
                    @Override
                    public ObservableSource<MovieResult> apply(MovieResult movieResult) throws Exception {
                        movieResult.setIndex(index);
                        return Observable.just(movieResult);
                    }
                });
    }


//    public Observable<MovieResult> getRows(List<Channel> rows) throws Exception {
//        List<Observable<MovieResult>> list = new ArrayList<>();
//        for (int i = 0; i < rows.size(); i++) {
//            list.add(getResults(rows.get(i).index));
//        }
//        return Observable.merge(list);
//    }


}
