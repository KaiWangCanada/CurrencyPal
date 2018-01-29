package com.kai.service.utilities;

/**
 * LaunchPresenter
 *
 * @author Kai
 *         Created on 1/29/2018
 *         Copyright © 2017 CurrencyPal. All rights reserved.
 */
public class TimeUtils {
    public static long getCurrentMinutes() {
        return (System.currentTimeMillis() / (60 * 1000));
    }

    public static boolean lessThan30Minutes(long preTime) {
        return ((getCurrentMinutes() - preTime) <= 30);
    }
}
