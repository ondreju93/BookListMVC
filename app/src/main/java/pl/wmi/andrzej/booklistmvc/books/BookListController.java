package pl.wmi.andrzej.booklistmvc.books;

import java.util.Objects;

import pl.wmi.andrzej.booklistmvc.R;
import pl.wmi.andrzej.booklistmvc.list.ListController;
import pl.wmi.andrzej.booklistmvc.list.ListModel;
import pl.wmi.andrzej.booklistmvc.list.ListObserver;
import pl.wmi.andrzej.booklistmvc.list.View;

/**
 * Created by andrzej on 07.01.16.
 */
public class BookListController implements ListController {
    private final ListModel<Book> model;
    private final View<Book> view;

    public BookListController(final View<Book> view) {
        this.view = view;
        this.model = BookListModelFactory.createSQLiteModel(view);
        this.view.setObservable(this.model);
    }

    @Override
    public void addItem(String... params) {
        final Book newBook = new Book();

        if(!Objects.equals(params[0], "")){
            if(params.length > 1) {
                newBook.setTitle(params[0]);
                newBook.setAuthor(params[1]);
                model.addItem(newBook);
            } else {
                newBook.setTitle(params[0]);
                model.addItem(newBook);
            }
        } else {
            view.showAlert(view.getContext().getString(R.string.emptyTitleError));
        }
    }
}
