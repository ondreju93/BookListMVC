package pl.wmi.andrzej.booklistmvc.common;

import android.content.Context;

import pl.wmi.andrzej.booklistmvc.list.ListObserver;

/**
 * Created by andrzej on 07.01.16.
 */
public interface View<T> extends ListObserver<T> {
    void showAlert(final String message);
    Context getContext();
}
