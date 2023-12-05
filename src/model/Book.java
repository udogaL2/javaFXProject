package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book
{
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty title;
	private final SimpleStringProperty description;
	private final SimpleStringProperty publicationYear;
	private final SimpleStringProperty ISBN;
	private final SimpleStringProperty authors;
	private final SimpleStringProperty genres;

	public Book(int id, String title, String description, String publicationYear, String ISBN, String authors, String genres)
	{
		this.id = new SimpleIntegerProperty(id);
		this.title = new SimpleStringProperty(title);
		this.description = new SimpleStringProperty(description);
		this.publicationYear = new SimpleStringProperty(publicationYear);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.authors = new SimpleStringProperty(authors);
		this.genres = new SimpleStringProperty(genres);
	}

	public String getTitle()
	{
		return title.get();
	}

	public void setTitle(String title)
	{
		this.title.set(title);
	}

	public String getDescription()
	{
		return description.get();
	}

	public void setDescription(String description)
	{
		this.description.set(description);
	}

	public String getPublicationYear()
	{
		return publicationYear.get();
	}

	public void setPublicationYear(String publicationYear)
	{
		this.publicationYear.set(publicationYear);
	}

	public String getISBN()
	{
		return ISBN.get();
	}

	public void setISBN(String ISBN)
	{
		this.ISBN.set(ISBN);
	}

	public String getAuthors()
	{
		return authors.get();
	}

	public void setAuthors(String authors)
	{
		this.authors.set(authors);
	}

	public String getGenres()
	{
		return genres.get();
	}

	public void setGenres(String genres)
	{
		this.genres.set(genres);
	}

	public int getId()
	{
		return id.get();
	}
}
