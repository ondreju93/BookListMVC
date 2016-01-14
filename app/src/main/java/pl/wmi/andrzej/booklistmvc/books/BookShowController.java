package pl.wmi.andrzej.booklistmvc.books;

import pl.wmi.andrzej.booklistmvc.list.ListModel;
import pl.wmi.andrzej.booklistmvc.show.ShowController;
import pl.wmi.andrzej.booklistmvc.common.View;

/**
 * Created by andrzej on 09.01.16.
 */
public class BookShowController implements ShowController {
    private final ListModel<Book> model;
    private final View<Book> view;

    public BookShowController(final View<Book> view) {
        this.view = view;
        this.model = BookListModelFactory.createSQLiteModel(view);
        this.view.setObservable(this.model);
    }

    @Override
    public void deleteItem(Long id) {
        model.deleteItem(id);
    }
}
