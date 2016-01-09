package pl.wmi.andrzej.booklistmvc.list;

/**
 * Created by andrzej on 07.01.16.
 */
public interface ListObserver <T>{
    void setObservable(ListObservable<T> listObservable);
    void update();
}
