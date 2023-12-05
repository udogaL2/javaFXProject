package view;

import lib.Parser;
import model.Book;

import java.util.ArrayList;

public class BookView
{
	public static ArrayList<String> getBookFields(Book book)
	{
		ArrayList<String> result = new ArrayList<>();

		result.add(Integer.toString(book.getId()));
		result.add(book.getTitle());
		result.add(book.getDescription());
		result.add(book.getISBN());
		result.add(book.getAuthors());
		result.add(book.getGenres());
		result.add(Parser.parseDateToString(book.getPublicationYear()));

		return result;
	}
}
