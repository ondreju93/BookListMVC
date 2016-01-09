package pl.wmi.andrzej.booklistmvc.list;

import java.util.List;

/**
 * Created by andrzej on 07.01.16.
 */
public interface ListModel <T> extends ListObservable <T>{
    T getItem(final Long id);
    void addItem(T item);
    void deleteItem(final Long id);
}
