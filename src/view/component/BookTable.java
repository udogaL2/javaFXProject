package view.component;

import javafx.collections.transformation.SortedList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lib.Lang;
import model.Book;

public class BookTable
{
	public static TableView<Book> getTable(SortedList<Book> sortedData)
	{
		TableView<Book> table = new TableView<Book>(sortedData);

		table.setEditable(false);
		table.setMaxWidth(765);
		table.setMinWidth(765);
		table.setPlaceholder(new Label(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_EMPTY_STATE")));

		TableColumn<Book, String> idColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_ID"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		idColumn.setMinWidth(40);
		idColumn.setMaxWidth(40);
		idColumn.setSortable(false);
		table.getColumns().add(idColumn);

		TableColumn<Book, String> titleColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_TITLE"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
		titleColumn.setMinWidth(110);
		titleColumn.setMaxWidth(110);
		titleColumn.setSortable(false);
		table.getColumns().add(titleColumn);

		TableColumn<Book, String> descriptionColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_DESCRIPTION"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
		descriptionColumn.setMinWidth(150);
		descriptionColumn.setMaxWidth(150);
		descriptionColumn.setSortable(false);
		table.getColumns().add(descriptionColumn);

		TableColumn<Book, String> publicationYearColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_YEAR"));
		publicationYearColumn.setCellValueFactory(new PropertyValueFactory<>("PublicationYear"));
		publicationYearColumn.setMinWidth(60);
		publicationYearColumn.setMaxWidth(60);
		publicationYearColumn.setSortable(false);
		table.getColumns().add(publicationYearColumn);

		TableColumn<Book, String> ISBNColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_ISBN"));
		ISBNColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		ISBNColumn.setMinWidth(80);
		ISBNColumn.setMaxWidth(80);
		ISBNColumn.setSortable(false);
		table.getColumns().add(ISBNColumn);

		TableColumn<Book, String> authorsColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_AUTHORS"));
		authorsColumn.setCellValueFactory(new PropertyValueFactory<>("Authors"));
		authorsColumn.setMinWidth(125);
		authorsColumn.setMaxWidth(125);
		authorsColumn.setSortable(false);
		table.getColumns().add(authorsColumn);

		TableColumn<Book, String> genresColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_GENRES"));
		genresColumn.setCellValueFactory(new PropertyValueFactory<>("Genres"));
		genresColumn.setMinWidth(120);
		genresColumn.setMaxWidth(120);
		genresColumn.setSortable(false);
		table.getColumns().add(genresColumn);

		TableColumn<Book, Void> deleteButton = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE"));
		deleteButton.setCellFactory(param -> new DeleteBookButtonCell(table));
		deleteButton.setMinWidth(80);
		deleteButton.setMaxWidth(80);
		deleteButton.setSortable(false);
		table.getColumns().add(deleteButton);

		return table;
	}
}
