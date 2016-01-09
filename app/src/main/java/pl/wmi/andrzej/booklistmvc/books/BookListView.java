package pl.wmi.andrzej.booklistmvc.books;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pl.wmi.andrzej.booklistmvc.R;
import pl.wmi.andrzej.booklistmvc.list.ListController;
import pl.wmi.andrzej.booklistmvc.list.ListObservable;
import pl.wmi.andrzej.booklistmvc.list.View;

public class BookListView extends AppCompatActivity implements View<Book> {

    public static final String SELECTED_BOOK = "selectedBook";

    private ListObservable<Book> observedModel;

    private ListController controller;

    private android.widget.ListView booksListView;

    private BookListAdapter bookListAdapter = new BookListAdapter();

    private EditText bookTitleEdit;

    private EditText bookAuthorEdit;

    private Button addBookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_view);

        //TODO abstraction for controller creation
        controller = new BookListController(this);

        booksListView = (android.widget.ListView) findViewById(R.id.booksListView);
        bookTitleEdit = (EditText) findViewById(R.id.bookTitleEdit);
        bookAuthorEdit = (EditText) findViewById(R.id.bookAuthorEdit);

        addBookButton = (Button) findViewById(R.id.addBookButton);
        addBookButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                BookListView.this.controller.addItem(bookTitleEdit.getText().toString(), bookAuthorEdit.getText().toString());
            }
        });

        booksListView.setAdapter(bookListAdapter);
        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, android.view.View view, int position, long l) {
                final TextView textView = (TextView) view;
                final Intent intent = new Intent(BookListView.this, BookShowView.class);

                Book selectedBook = (Book) booksListView.getAdapter().getItem(position);
                intent.putExtra(SELECTED_BOOK, selectedBook);
                startActivity(intent);
            }
        });

        update();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void setObservable(ListObservable<Book> listObservable) {
        this.observedModel = listObservable;
    }

    @Override
    public void update() {
        this.bookListAdapter.setBooks(observedModel.getItems());
        this.bookListAdapter.notifyDataSetChanged();
        this.booksListView.invalidateViews();
        this.booksListView.refreshDrawableState();
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return super.getApplicationContext();
    }

    private void refresh(){
        bookTitleEdit.setText(null);
        bookAuthorEdit.setText(null);
        update();
    }
}
