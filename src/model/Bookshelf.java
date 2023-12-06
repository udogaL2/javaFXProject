package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bookshelf
{
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty title;
	private final ObservableList<Book> bookList = FXCollections.observableArrayList();

	public Bookshelf(int id, String title)
	{
		this.id = new SimpleIntegerProperty(id);
		this.title = new SimpleStringProperty(title);
	}

	public String getTitle()
	{
		return title.get();
	}

	public void setTitle(String title)
	{
		this.title.set(title);
	}

	public void addBook(Book book)
	{
		bookList.add(book);
	}

	public ObservableList<Book> getBookList()
	{
		return bookList;
	}

	public int getId()
	{
		return id.get();
	}
}
