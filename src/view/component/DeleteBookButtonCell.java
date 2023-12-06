package view.component;

import controller.BookshelfController;
import javafx.scene.control.*;
import lib.Lang;
import model.Book;
import model.Bookshelf;
import view.MainWindow;

import java.util.Optional;

public class DeleteBookButtonCell extends TableCell<Book, Void>
{
	private final Button deleteButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DELETE"));

	DeleteBookButtonCell(TableView<Book> tableView)
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
				BookshelfController.deleteBookshelfById(MainWindow.bookshelfList, getTableRow().getItem().getId());

				MainWindow.updatePagination();
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
