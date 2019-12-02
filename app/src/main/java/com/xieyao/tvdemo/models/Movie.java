/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.xieyao.tvdemo.models;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xieyao.tvdemo.BuildConfig;

/*
 * Movie class represents video entity with title, description, image thumbs and video url.
 */
public class Movie implements Parcelable {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    @Expose
    private String originalLanguage;

    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    @Expose
    private String originalTitle;

    @SerializedName("video")
    @Expose
    private boolean video;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    @Expose
    private String posterPath;

    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    @Expose
    private String releaseDate;

    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    @Expose
    private double voteAverage;

    @SerializedName("popularity")
    @Expose
    private double popularity;

    @SerializedName("adult")
    @Expose
    private boolean adult;

    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    @Expose
    private int voteCount;

    @SerializedName("runtime")
    @ColumnInfo(name = "runtime")
    @Expose
    private int runTime;

    private int favorite;

    public Movie() {
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        overview = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        video = in.readByte() != 0;
        title = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        releaseDate = in.readString();
        voteAverage = in.readDouble();
        popularity = in.readDouble();
        adult = in.readByte() != 0;
        voteCount = in.readInt();
        runTime = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isVideo() {
        return video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath() {
        return TextUtils.isEmpty(backdropPath) ? posterPath : backdropPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return
                "MovieItem{" +
                        "id = '" + id + '\'' +
                        ",overview = '" + overview + '\'' +
                        ",original_language = '" + originalLanguage + '\'' +
                        ",original_title = '" + originalTitle + '\'' +
                        ",video = '" + video + '\'' +
                        ",title = '" + title + '\'' +
//                        ",genre_ids = '" + genreIds + '\'' +
                        ",poster_path = '" + posterPath + '\'' +
                        ",backdrop_path = '" + backdropPath + '\'' +
                        ",release_date = '" + releaseDate + '\'' +
                        ",vote_average = '" + voteAverage + '\'' +
                        ",popularity = '" + popularity + '\'' +
                        ",adult = '" + adult + '\'' +
                        ",vote_count = '" + voteCount + '\'' +
                        ",runtime = '" + runTime + '\'' +
                        "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(overview);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeString(releaseDate);
        dest.writeDouble(voteAverage);
        dest.writeDouble(popularity);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeInt(voteCount);
        dest.writeInt(runTime);
    }

    public static Movie fromContentValues(ContentValues values) {
        Movie movieItem = new Movie();
        if (values.containsKey("id")) {
            movieItem.id = values.getAsInteger("id");
        }
        if (values.containsKey("overview")) {
            movieItem.overview = values.getAsString("overview");
        }
        if (values.containsKey("original_language")) {
            movieItem.originalLanguage = values.getAsString("original_language");
        }
        if (values.containsKey("original_title")) {
            movieItem.originalTitle = values.getAsString("original_title");
        }
        if (values.containsKey("video")) {
            movieItem.video = values.getAsBoolean("video");
        }
        if (values.containsKey("title")) {
            movieItem.title = values.getAsString("title");
        }
        if (values.containsKey("poster_path")) {
            movieItem.posterPath = values.getAsString("poster_path");
        }
        if (values.containsKey("backdrop_path")) {
            movieItem.backdropPath = values.getAsString("backdrop_path");
        }
        if (values.containsKey("release_date")) {
            movieItem.releaseDate = values.getAsString("release_date");
        }
        if (values.containsKey("vote_average")) {
            movieItem.voteAverage = values.getAsDouble("vote_average");
        }
        if (values.containsKey("popularity")) {
            movieItem.popularity = values.getAsDouble("popularity");
        }
        if (values.containsKey("adult")) {
            movieItem.adult = values.getAsBoolean("adult");
        }
        if (values.containsKey("vote_count")) {
            movieItem.voteCount = values.getAsInteger("vote_count");
        }
        if (values.containsKey("runtime")) {
            movieItem.runTime = values.getAsInteger("runtime");
        }
        if (values.containsKey("favorite")) {
            movieItem.favorite = values.getAsInteger("favorite");
        }
        return movieItem;
    }

    public String getBackgroundImageUrl() {
        return BuildConfig.BASE_URL_IMG + BuildConfig.BASE_URL_IMG_BACKDROP_SIZE + getBackdropPath();
    }

    public String getCardImageUrl() {
        return BuildConfig.BASE_URL_IMG + BuildConfig.BASE_URL_IMG_CARD_SIZE + getBackdropPath();
    }

    public String getPosterImageUrl() {
        return BuildConfig.BASE_URL_IMG + BuildConfig.BASE_URL_IMG_POSTER_SIZE + posterPath;
    }

    public String getDescription() {
        return overview;
    }

    public String getScore() {
        if (Math.abs(voteAverage - 0d) <= 0.01d) {
            return "N/A";
        }
        return String.valueOf(voteAverage);
    }

    // TODO: 12/2/19
    public String getVideoUrl() {
        return null;
    }

    public String getReleaseYear() {
        return (null != releaseDate && releaseDate.length() > 4) ? releaseDate.substring(0, 4) : "";
    }

}
