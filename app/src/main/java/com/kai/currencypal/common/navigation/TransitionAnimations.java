package com.kai.currencypal.common.navigation;

import com.kai.currencypal.R;

/**
 * LaunchPresenter
 *
 * @author Kai
 *         Created on 1/25/2018
 *         Copyright © 2017 CurrencyPal. All rights reserved.
 */
public class TransitionAnimations {
    public enum ANIMATION_TYPE {
        NO_ANIMATION(0, 0, 0, 0),
        FROM_BOTTOM(R.anim.anim_slide_in_bottom, R.anim.anim_slide_out_bottom, R.anim.anim_slide_in_bottom, R.anim.anim_slide_out_bottom),
        FROM_TOP(R.anim.anim_slide_in_top, 0, 0, R.anim.anim_slide_out_top),
        FROM_RIGHT(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left, R.anim.anim_slide_in_left, R.anim.anim_slide_out_right),
        FROM_LEFT(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right, R.anim.anim_slide_in_right, R.anim.anim_slide_out_left),
        FADE_IN(R.anim.fade_in, 0, R.anim.fade_in, 0);

        private int inAnimation;
        private int outAnimation;
        private int popInAnimation;
        private int popOutAnimation;

        ANIMATION_TYPE(int in, int out, int popIn, int popOut) {
            inAnimation = in;
            outAnimation = out;
            popInAnimation = popIn;
            popOutAnimation = popOut;
        }

        public int getInAnimation() {
            return inAnimation;
        }

        public int getOutAnimation() {
            return outAnimation;
        }

        public int getPopInAnimation() {
            return popInAnimation;
        }

        public int getPopOutAnimation() {
            return popOutAnimation;
        }
    }
}
