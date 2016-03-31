package com.novsu.antonivanov.exampleproject.CustomBehavior;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.novsu.antonivanov.exampleproject.R;
import com.novsu.antonivanov.exampleproject.utils.AppLogger;
import com.novsu.antonivanov.exampleproject.utils.GuiUtil;

/**
 * Created by olga.melehina on 16.02.2016.
 */
public class TitleTextBehavior extends CoordinatorLayout.Behavior<TextView> {

    private final Context mContext;
    private final int mToolbarHeight;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    protected float first_text_size = 0f;

    public TitleTextBehavior(Context context, AttributeSet attrs) {
        mContext = context;
        mToolbarHeight = GuiUtil.getToolbarHeight(context);
        log("mToolbarHeight = " + mToolbarHeight);

    }

    protected void init(AppBarLayout appBarLayout, TextView child) {
        if (appBarLayout == null) return;
        if (child == null) return;
        for (int i = 0; i < appBarLayout.getChildCount(); i++) {
            View appbar_child = appBarLayout.getChildAt(i);
            if (appbar_child instanceof CollapsingToolbarLayout) {
                mCollapsingToolbarLayout = (CollapsingToolbarLayout) appbar_child;
                break;
            }
        }
        first_text_size = child.getTextSize();

    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        //log("dependency = " + dependency);
        if (dependency instanceof AppBarLayout) {
            boolean isInit = (mAppBarLayout != null);
            mAppBarLayout = (AppBarLayout) dependency;
            //init only for first time
            if (!isInit) {
                init(mAppBarLayout, child);
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

        AppBarLayout appBarLayout = (AppBarLayout) dependency;
        int rang =  /*getAppBarRang(dependency);/*/appBarLayout.getTotalScrollRange();
        log("height = " + mToolbarHeight);
        int offset = getAppBarOffset(appBarLayout);
        log("rang = " + rang + " offset = " + offset);
        updateFraction(child, (float) (/*rang -*/ offset) / rang);
        return true;
    }

    /**
     * @param child    is floating TextView, which animated from first position to toolbar title
     * @param fraction is % of  invisible part (or height) of appBarLayout,i.e how much distance already went
     *                 from 1.0 to 0.0
     */


    protected void updateFraction(TextView child, float fraction) {

        if (child == null)
            return;


        //change translation
        AppLogger.log("fraction = " + fraction);
        //log("fraction = " + fraction);
        float rest_fraction = 1.0f - fraction;
        //log("rest_fraction = " + rest_fraction);
        float textLeftPadding = child.getTotalPaddingLeft();
        float translateX = (getToolbarHeight() - textLeftPadding) * rest_fraction;
        // log("updateFraction translateX = " + translateX);
        float finishTextSize = child.getContext().getResources().getDimension(R.dimen.text_size_title_toolbar); //convertDpToPixel(android text_size_title_material_toolbar, child.getContext()); //toolbar textSize = 15dp

        //log("textSize =  " + textSize + " toolbarTextSize = " + toolbarTextSize);

        //закоментировал нижу строчку ! ОДНУ не знаю что она делала, но приложение падало!
        //float textTopPadding = child.getTotalPaddingTop();

        float topLimitY = (getToolbarHeight() - finishTextSize) / 2/* - textTopPadding*/;
        float translateY = (getToolbarHeight() - topLimitY) * rest_fraction;
        // log("updateFraction translateY = " + translateY);
        child.setTranslationX(translateX);
        child.setTranslationY(-translateY);
        //change alpha
       /* final float start_fraction = 0.2f;
        if(fraction < start_fraction){
            child.setAlpha(fraction/start_fraction);
        }else {
            child.setAlpha(1);
        }*/
        //change textSize

        float delta_text_size = first_text_size - finishTextSize;
        //log("first_text_size = " + first_text_size);
        //log("finishTextSize = " + finishTextSize);
        //log("delta_text_size = " + delta_text_size);
        float scale = (finishTextSize + delta_text_size * fraction) / first_text_size;
        //log("scale = " + scale);
        //child.setScaleX(scale);
        //log("final_text_size = " + first_text_size*scale);
        child.setTextSize(TypedValue.COMPLEX_UNIT_PX, first_text_size * scale);

        if (mCollapsingToolbarLayout != null) {
            mCollapsingToolbarLayout.setTitle(fraction == 0 ? child.getText() : "");
            child.setVisibility(fraction == 0 ? View.INVISIBLE : View.VISIBLE);
        }
        //change alpha of Collapsing
        /*if(mCollapsingToolbarLayout != null){
            if(fraction < 0.3f){
                mCollapsingToolbarLayout.setAlpha((0.3f - fraction)/0.3f);
            }else {
                mCollapsingToolbarLayout.setAlpha(1f);
            }

        }*/

    }


    protected int getAppBarRang(View dependency) {
        if (dependency == null) return 0;
        return dependency.getHeight() - getToolbarHeight();
    }

    protected int getAppBarOffset(AppBarLayout dependency) {
        if (dependency == null)
            return 0;
        log(" getAppBarOffset" + dependency.getHeight() + " " + dependency.getBottom() + " " + dependency.getTop());
        return dependency.getTotalScrollRange() + dependency.getTop();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public int getToolbarHeight() {
        return mToolbarHeight;
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }


    protected void log(String message) {
        AppLogger.log(getClass().getSimpleName() + " " + message);
    }
}
