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

package com.xieyao.tvdemo.consumption;

import android.net.Uri;
import android.os.Bundle;

import androidx.leanback.app.VideoSupportFragment;
import androidx.leanback.app.VideoSupportFragmentGlueHost;
import androidx.leanback.media.MediaPlayerAdapter;
import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.leanback.widget.PlaybackControlsRow;

import com.xieyao.tvdemo.detail.DetailsActivity;
import com.xieyao.tvdemo.models.Movie;
import com.xieyao.tvdemo.models.Trailer;

/**
 * Handles video playback with media controls.
 */
public class PlaybackVideoFragment extends VideoSupportFragment {

    private PlaybackTransportControlGlue<MediaPlayerAdapter> mTransportControlGlue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        final Movie movie = (Movie) getActivity().getIntent().getSerializableExtra(DetailsActivity.MOVIE);
//
//        VideoSupportFragmentGlueHost glueHost = new VideoSupportFragmentGlueHost(PlaybackVideoFragment.this);
//
//        MediaPlayerAdapter playerAdapter = new MediaPlayerAdapter(getActivity());
//        playerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE);
//
//        mTransportControlGlue = new PlaybackTransportControlGlue<>(getActivity(), playerAdapter);
//        mTransportControlGlue.setHost(glueHost);
//        mTransportControlGlue.setTitle(movie.getTitle());
//        mTransportControlGlue.setSubtitle(movie.getDescription());
//        mTransportControlGlue.playWhenPrepared();
//        playerAdapter.setDataSource(Uri.parse(movie.getVideoUrl()));

        final Trailer trailer = (Trailer) getActivity().getIntent().getSerializableExtra(DetailsActivity.TRAILER);
        VideoSupportFragmentGlueHost glueHost = new VideoSupportFragmentGlueHost(PlaybackVideoFragment.this);
        MediaPlayerAdapter playerAdapter = new MediaPlayerAdapter(getActivity());
        playerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE);
        mTransportControlGlue = new PlaybackTransportControlGlue<>(getActivity(), playerAdapter);
        mTransportControlGlue.setHost(glueHost);
        mTransportControlGlue.setTitle(trailer.getName());
        mTransportControlGlue.setSubtitle(trailer.getDescription());
        mTransportControlGlue.playWhenPrepared();
        playerAdapter.setDataSource(Uri.parse(trailer.getVideoUrl()));
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mTransportControlGlue != null) {
            mTransportControlGlue.pause();
        }
    }
}