package controller;

import config.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import model.Book;
import model.Bookshelf;
import model.SerializableBook;
import model.SerializableBookshelf;

import java.io.*;
import java.util.ArrayList;

public class BookshelfController
{
	private static int lastId = 0;

	public static Bookshelf createNewBookshelf(String title)
	{
		return new Bookshelf(++lastId, title);
	}

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

	public static SerializableBookshelf getSerializableBookshelf(Bookshelf bookshelf)
	{
		ArrayList<SerializableBook> serializableBookList = new ArrayList<>();

		for (Book book: bookshelf.getBookList())
		{
			serializableBookList.add(BookController.getSerializableBook(book));
		}

		return new SerializableBookshelf(bookshelf.getId(), bookshelf.getTitle(), serializableBookList);
	}

	public static boolean serialize(ObservableList<Bookshelf> bookshelfList)
	{
		ArrayList<SerializableBookshelf> serializableBookshelfList = new ArrayList<>();

		for (Bookshelf bookshelf: bookshelfList)
		{
			serializableBookshelfList.add(getSerializableBookshelf(bookshelf));
		}

		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(Config.PATH_TO_SAVE);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(serializableBookshelfList);

			objectOutputStream.close();
			fileOutputStream.close();

			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}

	public static ObservableList<Bookshelf> unserialize()
	{
		ObservableList<Bookshelf> bookshelfList = FXCollections.observableArrayList();

		try
		{
			FileInputStream fileInputStream = new FileInputStream(Config.PATH_TO_SAVE);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			ArrayList<SerializableBookshelf> serializableBookshelfList = (ArrayList<SerializableBookshelf>) objectInputStream.readObject();

			for (SerializableBookshelf serializableBookshelf: serializableBookshelfList)
			{
				Bookshelf bookshelf = createNewBookshelf(serializableBookshelf.id(), serializableBookshelf.title());

				if (serializableBookshelf.id() > lastId)
				{
					lastId = serializableBookshelf.id();
				}

				for (SerializableBook serializableBook: serializableBookshelf.bookList())
				{
					bookshelf.addBook(BookController.createNewBook(
						serializableBook.id(),
						serializableBook.title(),
						serializableBook.description(),
						serializableBook.publicationYear(),
						serializableBook.ISBN(),
						serializableBook.authors(),
						serializableBook.genres()
					));
				}

				bookshelfList.add(bookshelf);
			}

			objectInputStream.close();
			fileInputStream.close();

			return bookshelfList;

		} catch (IOException | ClassNotFoundException e)
		{
			return FXCollections.observableArrayList();
		}
	}
}
