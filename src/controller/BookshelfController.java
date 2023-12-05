package controller;

import javafx.collections.ObservableList;
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

	public static void deleteBookshelfById(ObservableList<Bookshelf> bookshelfList, int id)
	{
		for (int i = 0; i < bookshelfList.size(); i++)
		{
			if (bookshelfList.get(i).getId() == id)
			{
				bookshelfList.remove(i);

				break;
			}
		}
	}
}
