package model;

import java.util.ArrayList;

public class Bookshelf
{
	private final int id;
	private String title;
	private final ArrayList<Book> bookList = new ArrayList<>();

	public Bookshelf(int id, String title)
	{
		this.id = id;
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void addBook(Book book)
	{
		bookList.add(book);
	}

	public ArrayList<Book> getBookList()
	{
		return bookList;
	}

	public int getId()
	{
		return id;
	}
}
