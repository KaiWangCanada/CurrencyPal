package com.kai.service.base;

/**
 * Callback
 * Description
 *
 * @author Oleksiy
 *         Created on 2017-05-03
 *         Copyright © 2015 Plastic Mobile. All rights reserved.
 */

public abstract class Callback<T> {
    public abstract void onSuccess(T object);

    public abstract void onFailure(int errorCode, String errorMsg);
}
