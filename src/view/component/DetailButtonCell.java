package view.component;

import javafx.scene.control.*;
import javafx.stage.Stage;
import lib.Lang;
import model.Bookshelf;
import view.BookshelfDetailWindow;

public class DetailButtonCell extends TableCell<Bookshelf, Void>
{
	private final Button deleteButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAILS"));

	DetailButtonCell(TableView<Bookshelf> tableView)
	{
		deleteButton.setMinWidth(95);
		deleteButton.setMaxWidth(95);

		deleteButton.setOnAction(event -> {
			Bookshelf b = getTableRow().getItem();
			Stage newWindow = BookshelfDetailWindow.getStage(b);

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
