package controller;

import model.Book;

import java.util.Date;

public class BookController
{
	public static Book createNewBook(int id, String title, String description, Date publicationYear, String ISBN, String authors, String genres)
	{
		return new Book(id, title, description, publicationYear, ISBN, authors, genres);
	}
}