package com.xieyao.tvdemo.detail;

import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

import com.xieyao.tvdemo.R;

public class CustomFullWidthDetailsOverviewRowPresenter extends FullWidthDetailsOverviewRowPresenter {

    public CustomFullWidthDetailsOverviewRowPresenter(Presenter detailsPresenter) {
        super(detailsPresenter);
    }

    public CustomFullWidthDetailsOverviewRowPresenter(Presenter detailsPresenter, DetailsOverviewLogoPresenter logoPresenter) {
        super(detailsPresenter, logoPresenter);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.custom_fullwidth_details_overview;
    }
}
