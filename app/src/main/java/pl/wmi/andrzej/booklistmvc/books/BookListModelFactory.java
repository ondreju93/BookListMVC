package pl.wmi.andrzej.booklistmvc.books;

import pl.wmi.andrzej.booklistmvc.list.ListModel;
import pl.wmi.andrzej.booklistmvc.common.View;

/**
 * Created by andrzej on 09.01.16.
 */
public class BookListModelFactory {
    static ListModel<Book> createSQLiteModel(final View<Book> view){
        return new SQLiteBookListModel(view);
    }
}
