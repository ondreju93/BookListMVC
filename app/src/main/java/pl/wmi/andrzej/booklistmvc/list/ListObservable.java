package pl.wmi.andrzej.booklistmvc.list;

import java.util.List;

/**
 * Created by andrzej on 07.01.16.
 */
public interface ListObservable <T>{
    void attach(ListObserver listObserver);
    List<T> getItems();
}
