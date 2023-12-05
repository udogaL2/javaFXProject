package model;

import java.util.Date;

public class Book
{
	private final int id;
	private String title;
	private String description;
	private Date publicationYear;
	private String ISBN;
	private String authors;
	private String genres;

	public Book(int id, String title, String description, Date publicationYear, String ISBN, String authors, String genres)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.publicationYear = publicationYear;
		this.ISBN = ISBN;
		this.authors = authors;
		this.genres = genres;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getPublicationYear()
	{
		return publicationYear;
	}

	public void setPublicationYear(Date publicationYear)
	{
		this.publicationYear = publicationYear;
	}

	public String getISBN()
	{
		return ISBN;
	}

	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}

	public String getAuthors()
	{
		return authors;
	}

	public void setAuthors(String authors)
	{
		this.authors = authors;
	}

	public String getGenres()
	{
		return genres;
	}

	public void setGenres(String genres)
	{
		this.genres = genres;
	}

	public int getId()
	{
		return id;
	}
}
