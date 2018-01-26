package com.kai.currencypal.common.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.kai.currencypal.R;
import com.kai.currencypal.common.base.BaseActivity;

/**
 * LaunchPresenter
 *
 * @author Kai
 *         Created on 1/25/2018
 *         Copyright © 2017 CurrencyPal. All rights reserved.
 */
public class Router {

    private final static String TAG = Router.class.getSimpleName();

    public static void launchActivity(Context context, Class activity, boolean clearStack, TransitionAnimations.ANIMATION_TYPE animationType) {
        Intent intent = new Intent(context, activity);
        if (clearStack)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        launchActivityInternal(intent, context, null, null, 0, animationType);
    }

    private static void launchActivityInternal(Intent intent, Context context, Bundle extras, Bundle options, int requestCode, TransitionAnimations.ANIMATION_TYPE animationType) {
        if (extras == null)
            extras = new Bundle();

        extras.putSerializable(BaseActivity.EXTRA_ANIMATION, animationType);
        intent.putExtras(extras);

        if (requestCode == 0) {
            context.startActivity(intent, options);
        } else {
            ((Activity) context).startActivityForResult(intent, requestCode, options);
        }

        if (animationType != TransitionAnimations.ANIMATION_TYPE.NO_ANIMATION) {
            ((Activity) context).overridePendingTransition(animationType.getInAnimation(), R.anim.anim_no_anim);
        }

    }
}
