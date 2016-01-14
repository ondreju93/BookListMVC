package pl.wmi.andrzej.booklistmvc.books;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pl.wmi.andrzej.booklistmvc.R;
import pl.wmi.andrzej.booklistmvc.list.ListObservable;
import pl.wmi.andrzej.booklistmvc.show.ShowController;
import pl.wmi.andrzej.booklistmvc.common.View;

public class BookShowView extends AppCompatActivity implements View<Book> {

    private static final String ANOTHER_BOOK_READ = "Another book read!";

    private ShowController controller;

    private EditText showBookTitleEdit;

    private EditText showBookAuthorEdit;

    private Button alreadyReadButton;

    private Book selectedBook;

    private ListObservable<Book> observedModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book_view);

        controller = new BookShowController(this);
        selectedBook = getIntent().getParcelableExtra(BookListView.SELECTED_BOOK);

        showBookTitleEdit = (EditText) findViewById(R.id.showBookTitle);
        showBookTitleEdit.setText(selectedBook.getTitle());
        showBookAuthorEdit = (EditText) findViewById(R.id.showBookAuthor);
        showBookAuthorEdit.setText(selectedBook.getAuthor());

        alreadyReadButton = (Button) findViewById(R.id.alreadyReadButton);
        alreadyReadButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                controller.deleteItem(selectedBook.getId());
            }
        });
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return super.getApplicationContext();
    }

    @Override
    public void setObservable(ListObservable<Book> listObservable) {
        this.observedModel = listObservable;
    }

    @Override
    public void update() {
        showAlert(ANOTHER_BOOK_READ);
        finish();
    }
}
