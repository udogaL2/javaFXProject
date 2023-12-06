package model;

import java.io.Serializable;

public record SerializableBook(
		int id,
		String title,
		String description,
		String publicationYear,
		String ISBN,
		String authors,
		String genres
) implements Serializable {}
