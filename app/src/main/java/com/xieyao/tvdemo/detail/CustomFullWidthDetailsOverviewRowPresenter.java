package com.xieyao.tvdemo.detail;

import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

import com.xieyao.tvdemo.R;

public class CustomFullWidthDetailsOverviewRowPresenter extends FullWidthDetailsOverviewRowPresenter {

    public CustomFullWidthDetailsOverviewRowPresenter(Presenter detailsPresenter) {
        super(detailsPresenter);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.custom_fullwidth_details_overview;
    }

}
