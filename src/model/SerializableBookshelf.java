package model;

import java.io.Serializable;
import java.util.ArrayList;

public record SerializableBookshelf(int id, String title, ArrayList<SerializableBook> bookList) implements Serializable {}
