package view;

import controller.BookshelfController;
import model.Bookshelf;

import java.util.ArrayList;

public class BookshelfView
{
	public static ArrayList<String> getBookshelfFields(Bookshelf bookshelf)
	{
		ArrayList<String> result = new ArrayList<>();

		result.add(Integer.toString(bookshelf.getId()));
		result.add(bookshelf.getTitle());
		result.add(Integer.toString(BookshelfController.getBookCount(bookshelf)));

		return result;
	}
}
