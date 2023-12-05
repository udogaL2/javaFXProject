import javafx.collections.transformation.SortedList;
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

		TableColumn<Bookshelf, String> idColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_ID"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		idColumn.setMinWidth(83);
		idColumn.setMaxWidth(83);
		table.getColumns().add(idColumn);

		TableColumn<Bookshelf, String> titleColumn = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_TITLE"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
		titleColumn.setMinWidth(500);
		titleColumn.setMaxWidth(500);
		table.getColumns().add(titleColumn);

		TableColumn<Bookshelf, Void> detailsButton = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAILS"));
		detailsButton.setCellFactory(param -> new DetailButtonCell(table));
		detailsButton.setMinWidth(100);
		detailsButton.setMaxWidth(100);
		table.getColumns().add(detailsButton);

		TableColumn<Bookshelf, Void> deleteButton = new TableColumn<>(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE"));
		deleteButton.setCellFactory(param -> new DeleteButtonCell(table));
		deleteButton.setMinWidth(80);
		deleteButton.setMaxWidth(80);
		table.getColumns().add(deleteButton);

		return table;
	}
}
