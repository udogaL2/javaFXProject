package controller;

import model.Book;
import model.Bookshelf;

public class BookshelfController
{
	public static Bookshelf createNewBookshelf(int id, String title)
	{
		return new Bookshelf(id, title);
	}

	public static void addBookToBookshelf(Bookshelf bookshelf, Book book)
	{
		bookshelf.addBook(book);
	}

	public static int getBookCount(Bookshelf bookshelf)
	{
		return bookshelf.getBookList().size();
	}
}
