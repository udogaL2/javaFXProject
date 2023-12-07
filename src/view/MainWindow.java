package view;

import config.Config;
import controller.BookshelfController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lib.Lang;
import lib.Validator;
import model.Bookshelf;
import view.component.BookshelfTable;

public class MainWindow
{
	public static ObservableList<Bookshelf> bookshelfList;

	public final static Pagination pagination = new Pagination();

	public static Stage mainStage = null;

	public static Stage getStage()
	{
		if (mainStage == null)
		{
			mainStage = new Stage();

			if (Validator.isFileExists(Config.PATH_TO_SAVE))
			{
				bookshelfList = BookshelfController.unserialize();
			}

			prepareStage();
		}

		return mainStage;
	}

	private static void prepareStage()
	{
		mainStage.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_TITLE"));

		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_SUBTITLE"));
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Group titleBar = new Group(subtitle, getButtonGroup());

		StackPane content = getContent();

		Group root = new Group(titleBar, content);
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setWidth(Config.WINDOW_WIDTH);
		mainStage.setHeight(Config.WINDOW_HEIGHT);
		mainStage.setResizable(false);

		mainStage.setOnCloseRequest(t -> {
			BookshelfController.serialize(bookshelfList);

			Platform.exit();
			System.exit(0);
		});
	}

	private static Group getButtonGroup()
	{
		Group buttonGroup = new Group();

		Button createBookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_ADD_NEW"));
		createBookshelfButton.setLayoutX(700);
		createBookshelfButton.setLayoutY(40);
		createBookshelfButton.setOnAction(actionEvent ->
		{
			CreateBookshelfWindow.getStage().show();
		});

		Button saveBookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_SAVE_BOOKSHELF"));
		saveBookshelfButton.setLayoutX(600);
		saveBookshelfButton.setLayoutY(40);
		saveBookshelfButton.setOnAction(actionEvent -> {
			boolean result = BookshelfController.serialize(bookshelfList);
			Alert alert = new Alert(result ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
			alert.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_SAVE"));
			alert.setHeaderText(null);
			String contentText = result ? Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_SAVE_SUCCESSFULLY") : Lang.getInstance().getMessage("MAIN_WINDOW_CREATE_UNSUCCESSFULLY");
			alert.setContentText(contentText);

			alert.showAndWait();
		});

		buttonGroup.getChildren().add(createBookshelfButton);
		buttonGroup.getChildren().add(saveBookshelfButton);

		return buttonGroup;
	}

	private static StackPane getContent()
	{
		pagination.setPageFactory(MainWindow::getPage);
		pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
		pagination.setMaxPageIndicatorCount(5);

		updatePagination();

		StackPane layout = new StackPane(pagination);
		layout.setMinHeight(450);
		layout.setMaxHeight(450);
		layout.setLayoutX(10);
		layout.setLayoutY(100);

		return layout;
	}

	private static FlowPane getPage(int pageIndex)
	{
		FilteredList<Bookshelf> filteredData = new FilteredList<>(
				bookshelfList,
				bookshelf -> (
					bookshelfList.indexOf(bookshelf) < (pageIndex + 1) * Config.MAX_ITEMS_COUNT
					&& bookshelfList.indexOf(bookshelf) >= pageIndex * Config.MAX_ITEMS_COUNT
				)
		);
		SortedList<Bookshelf> sortedData = new SortedList<>(filteredData);

		TableView<Bookshelf> table = BookshelfTable.getTable(sortedData);

		table.setItems(sortedData);

		return new FlowPane(table);
	}

	public static void updatePagination()
	{
		int pageCount = bookshelfList.size() / 12 + (bookshelfList.size() % 12 == 0 ? 0 : 1);

		pagination.setPageCount(pageCount != 0 ? pageCount : 1);
	}
}
