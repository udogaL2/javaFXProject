package view;

import config.Config;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

	public static Bookshelf bookshelf = null;

	public static Pagination pagination;


	public static Stage getStage(Bookshelf bookshelf)
	{
		if (bookshelfDetailStage == null)
		{
			bookshelfDetailStage = new Stage();
		}

		BookshelfDetailWindow.bookshelf = bookshelf;

		prepareStage();

		return bookshelfDetailStage;
	}

	private static void prepareStage()
	{
		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAIL_TITLE") + " " + bookshelf.getTitle());
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Group titleBar = new Group(subtitle, getButtonGroup());

		StackPane content = getContent();

		Group root = new Group(titleBar, content);
		Scene scene = new Scene(root);

		bookshelfDetailStage.setScene(scene);
		bookshelfDetailStage.setTitle(bookshelf.getTitle());
		bookshelfDetailStage.setWidth(Config.WINDOW_WIDTH);
		bookshelfDetailStage.setHeight(Config.WINDOW_HEIGHT);
		bookshelfDetailStage.setResizable(false);
		bookshelfDetailStage.setX(MainWindow.mainStage.getX() + 50);
		bookshelfDetailStage.setY(MainWindow.mainStage.getY() + 50);
	}

	private static Group getButtonGroup()
	{
		Group buttonGroup = new Group();

		Button createBookButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_ADD_NEW"));
		createBookButton.setLayoutX(700);
		createBookButton.setLayoutY(40);
		createBookButton.setOnAction(actionEvent -> {
			CreateBookWindow.getStage(bookshelf).show();
		});

		buttonGroup.getChildren().add(createBookButton);

		return buttonGroup;
	}

	private static StackPane getContent()
	{
		pagination = new Pagination();

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
		ObservableList<Book> bookList = BookshelfDetailWindow.bookshelf.getBookList();

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
		int pageCount = bookshelf.getBookList().size() / 12 + (bookshelf.getBookList().size() % 12 == 0 ? 0 : 1);

		pagination.setPageCount(pageCount != 0 ? pageCount : 1);
	}
}
