package pl.wmi.andrzej.booklistmvc.books;

import android.content.Context;

import pl.wmi.andrzej.booklistmvc.list.ListModel;
import pl.wmi.andrzej.booklistmvc.list.ListObserver;
import pl.wmi.andrzej.booklistmvc.list.View;

/**
 * Created by andrzej on 09.01.16.
 */
public class BookListModelFactory {
    static ListModel<Book> createSQLiteModel(final View<Book> view){
        return new SQLiteBookListModel(view);
    }
}
