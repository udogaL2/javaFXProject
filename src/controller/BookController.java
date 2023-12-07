package controller;

import javafx.collections.ObservableList;
import model.Book;
import model.Bookshelf;
import model.SerializableBook;

public class BookController
{
	private static int lastId = 0;

	public static Book createNewBook(String title, String description, String publicationYear, String ISBN, String authors, String genres)
	{
		return new Book(++lastId, title, description, publicationYear, ISBN, authors, genres);
	}

	public static Book createNewBook(int id, String title, String description, String publicationYear, String ISBN, String authors, String genres)
	{
		return new Book(id, title, description, publicationYear, ISBN, authors, genres);
	}

	public static SerializableBook getSerializableBook(Book book)
	{
		if (book.getId() > lastId)
		{
			lastId = book.getId();
		}

		return new SerializableBook(
			book.getId(),
			book.getTitle(),
			book.getDescription(),
			book.getPublicationYear(),
			book.getISBN(),
			book.getAuthors(),
			book.getGenres()
		);
	}

	public static void deleteBookById(ObservableList<Book> bookList, int id)
	{
		for (int i = 0; i < bookList.size(); i++)
		{
			if (bookList.get(i).getId() == id)
			{
				bookList.remove(i);

				break;
			}
		}
	}
}