package view.component;

import javafx.collections.transformation.SortedList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lib.Lang;
import model.Bookshelf;

public class BookshelfTable
{
	public static TableView<Bookshelf> getTable(SortedList<Bookshelf> sortedData)
	{
		TableView<Bookshelf> table = new TableView<Bookshelf>(sortedData);

		table.setEditable(false);
		table.setMaxWidth(765);
		table.setMinWidth(765);
		table.setPlaceholder(new Label(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_EMPTY_STATE")));

		TableColumn<Bookshelf, String> idColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_ID"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		idColumn.setMinWidth(83);
		idColumn.setMaxWidth(83);
		idColumn.setSortable(false);
		table.getColumns().add(idColumn);

		TableColumn<Bookshelf, String> titleColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_TITLE"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
		titleColumn.setMinWidth(500);
		titleColumn.setMaxWidth(500);
		titleColumn.setSortable(false);
		table.getColumns().add(titleColumn);

		TableColumn<Bookshelf, Void> detailsButton = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAILS"));
		detailsButton.setCellFactory(param -> new DetailButtonCell(table));
		detailsButton.setMinWidth(100);
		detailsButton.setMaxWidth(100);
		detailsButton.setSortable(false);
		table.getColumns().add(detailsButton);

		TableColumn<Bookshelf, Void> deleteButton = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE"));
		deleteButton.setCellFactory(param -> new DeleteBookshelfButtonCell(table));
		deleteButton.setMinWidth(80);
		deleteButton.setMaxWidth(80);
		deleteButton.setSortable(false);
		table.getColumns().add(deleteButton);

		return table;
	}
}
