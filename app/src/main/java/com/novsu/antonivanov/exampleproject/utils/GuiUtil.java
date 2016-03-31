package com.novsu.antonivanov.exampleproject.utils;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * Date creation: 31.03.2016.
 */
public class GuiUtil {

    public static int getToolbarHeight(Context context) {
        if (context == null) return 0;
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        int height = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return height;
    }
}
