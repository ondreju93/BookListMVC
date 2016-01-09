package pl.wmi.andrzej.booklistmvc.list;

import android.content.Context;

/**
 * Created by andrzej on 07.01.16.
 */
public interface View<T> extends ListObserver<T>{
    void showAlert(final String message);
    Context getContext();
}
