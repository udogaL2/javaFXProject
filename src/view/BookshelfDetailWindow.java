package view;

import config.Config;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lib.Lang;
import model.Book;
import model.Bookshelf;
import view.component.BookTable;

public class BookshelfDetailWindow
{
	public static Stage bookshelfDetailStage = null;

	public final static Pagination pagination = new Pagination();

	public static ObservableList<Book> bookList = null;

	public static Stage getStage(Bookshelf bookshelf)
	{
		if (bookshelfDetailStage == null)
		{
			bookshelfDetailStage = new Stage();
		}

		BookshelfDetailWindow.bookList = bookshelf.getBookList();

		prepareStage();

		return bookshelfDetailStage;
	}

	private static void prepareStage()
	{
		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_CREATE"));
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Group titleBar = new Group(subtitle, getButtonGroup());

		StackPane content = getContent();

		Group root = new Group(titleBar, content);
		Scene scene = new Scene(root);

		bookshelfDetailStage.setScene(scene);
		bookshelfDetailStage.setWidth(Config.WINDOW_WIDTH);
		bookshelfDetailStage.setHeight(Config.WINDOW_HEIGHT);
		bookshelfDetailStage.setResizable(false);
	}

	private static Group getButtonGroup()
	{
		Group buttonGroup = new Group();

		Button createBookButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_ADD_NEW"));
		createBookButton.setLayoutX(700);
		createBookButton.setLayoutY(40);
		createBookButton.setOnAction(actionEvent ->
		{

		});

		buttonGroup.getChildren().add(createBookButton);

		return buttonGroup;
	}

	private static StackPane getContent()
	{
		pagination.setPageFactory(BookshelfDetailWindow::getPage);
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

	private static Group getPage(int pageIndex)
	{
		FilteredList<Book> filteredData = new FilteredList<>(
				bookList,
				book -> (
					bookList.indexOf(book) < (pageIndex + 1) * Config.MAX_ITEMS_COUNT
					&& bookList.indexOf(book) >= pageIndex * Config.MAX_ITEMS_COUNT
				)
		);
		SortedList<Book> sortedData = new SortedList<>(filteredData);

		TableView<Book> table = BookTable.getTable(sortedData);

		table.setItems(sortedData);

		return new Group(table);
	}

	public static void updatePagination()
	{
		int pageCount = bookList.size() / 12 + (bookList.size() % 12 == 0 ? 0 : 1);

		pagination.setPageCount(pageCount != 0 ? pageCount : 1);
	}
}
