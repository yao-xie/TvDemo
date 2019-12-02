package com.xieyao.tvdemo.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class Utils {

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
        return uiModeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION;
    }

    public static String getAssetsJson(Context context, String fileName) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static boolean isEmpty(@Nullable Collection collection) {
        return (null == collection || collection.size() == 0) ? true : false;
    }
}
