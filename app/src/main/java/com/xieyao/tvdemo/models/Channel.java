package com.xieyao.tvdemo.models;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    public static final String MOVIE_POPULAR = "Movie Popular";
    public static final String MOVIE_TOP_RATED = "Movie Top Rated";
    public static final String MOVIE_UPCOMING = "Movie Upcoming";
    public static final String TV_ON_THE_AIR = "TV On The Air";
    public static final String TV_POPUPAR = "TV Popular";
    public static final String TV_TOP_RATED = "TV Top Rated";

    public int index;
    private String name;

    public Channel() {
    }

    public Channel(int index) {
        this.index = index;
    }

    public String getName() {
        switch (index) {
            case 0:
                return MOVIE_POPULAR;
            case 1:
                return MOVIE_TOP_RATED;
            case 2:
                return MOVIE_UPCOMING;
            case 3:
                return TV_ON_THE_AIR;
            case 4:
                return TV_POPUPAR;
            case 5:
                return TV_TOP_RATED;
            default:
                return "";
        }
    }

    public Channel(String name) {
        this.name = name;
    }

    public static List<Channel> createDefaultChannels() {
        List<Channel> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Channel(i));
        }
        return list;
    }

}
