package controller;

import model.Book;
import model.SerializableBook;

import java.util.Date;

public class BookController
{
	public static Book createNewBook(int id, String title, String description, String publicationYear, String ISBN, String authors, String genres)
	{
		return new Book(id, title, description, publicationYear, ISBN, authors, genres);
	}

	public static SerializableBook getSerializableBook(Book book)
	{
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
}