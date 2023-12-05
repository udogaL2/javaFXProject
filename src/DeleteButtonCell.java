import controller.BookshelfController;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import lib.Lang;
import model.Bookshelf;

import java.util.Optional;

public class DeleteButtonCell extends TableCell<Bookshelf, Void>
{
	private final Button deleteButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE"));

	DeleteButtonCell(TableView<Bookshelf> tableView)
	{
		deleteButton.setMinWidth(75);
		deleteButton.setMaxWidth(75);

		deleteButton.setOnAction(event -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_TITLE") + " " + getTableRow().getItem().getTitle());
			alert.setHeaderText(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_DESCRIPTION"));

			ButtonType confirmButton = new ButtonType(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_CONFIRM"), ButtonBar.ButtonData.YES);
			ButtonType cancelButton = new ButtonType(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_CANCEL"), ButtonBar.ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().clear();
			alert.getButtonTypes().addAll(confirmButton, cancelButton);

			alert.getDialogPane().setMaxWidth(350);

			Optional<ButtonType> result = alert.showAndWait();

			if (result.get() == confirmButton)
			{
				BookshelfController.deleteBookshelfById(Main.bookshelfList, getTableRow().getItem().getId());

				Main.updatePagination();
			}
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
