import controller.BookshelfController;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lib.Lang;
import model.Bookshelf;

import java.util.Optional;

public class DetailButtonCell extends TableCell<Bookshelf, Void>
{
	private final Button deleteButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAILS"));

	DetailButtonCell(TableView<Bookshelf> tableView)
	{
		deleteButton.setMinWidth(95);
		deleteButton.setMaxWidth(95);

		deleteButton.setOnAction(event -> {
			Stage newWindow = BookshelfDetailWindow.getStage(getTableRow().getItem());

			newWindow.show();
		});
	}

	@Override
	protected void updateItem(Void item, boolean empty)
	{
		super.updateItem(item, empty);
		if (empty)
		{
			setGraphic(null);
		} else
		{
			setGraphic(deleteButton);
		}
	}
}
