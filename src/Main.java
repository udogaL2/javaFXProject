import config.Config;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lib.Lang;
import model.Bookshelf;

public class Main extends Application
{
	public final static ObservableList<Bookshelf> bookshelfList = FXCollections.observableArrayList(
			new Bookshelf(1, "test 1"), new Bookshelf(2, "test 2"),
			new Bookshelf(3, "test"), new Bookshelf(4, "test 2"),
			new Bookshelf(5, "test 1"), new Bookshelf(6, "test 2"),
			new Bookshelf(7, "test 1"), new Bookshelf(8, "test 2"),
			new Bookshelf(9, "test 1"), new Bookshelf(10, "test 2"),
			new Bookshelf(11, "test 1"), new Bookshelf(12, "test 2"),
			new Bookshelf(13, "test 1"), new Bookshelf(14, "test 2"),
			new Bookshelf(15, "test 1"), new Bookshelf(16, "test 2"),
			new Bookshelf(17, "test 1"), new Bookshelf(18, "test 2"),
			new Bookshelf(19, "test 1"), new Bookshelf(20, "test 2"),
			new Bookshelf(21, "test 1"), new Bookshelf(22, "test 2"),
			new Bookshelf(23, "test 1"), new Bookshelf(24, "test 2")
	);

	public final static Pagination pagination = new Pagination();

	public static Stage mainStage = null;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		mainStage = stage;

		prepareStage();

		mainStage.show();
	}

	private void prepareStage()
	{
		mainStage.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_TITLE"));

		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_SUBTITLE"));
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Group titleBar = new Group(subtitle, getButtonGroup());

		StackPane content = getContent(mainStage);

		Group root = new Group(titleBar, content);
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setWidth(Config.WINDOW_WIDTH);
		mainStage.setHeight(Config.WINDOW_HEIGHT);
		mainStage.setResizable(false);

		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				Platform.exit();
				System.exit(0);
			}
		});
	}

	private Group getButtonGroup()
	{
		Group buttonGroup = new Group();

		Button createBookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_ADD_NEW_BOOKSHELF"));
		createBookshelfButton.setLayoutX(700);
		createBookshelfButton.setLayoutY(40);
		createBookshelfButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent actionEvent)
			{

			}
		});

		Button saveBookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_SAVE_BOOKSHELF"));
		saveBookshelfButton.setLayoutX(600);
		saveBookshelfButton.setLayoutY(40);
		saveBookshelfButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent actionEvent)
			{
				// TODO: сохранение данных
			}
		});

		buttonGroup.getChildren().add(createBookshelfButton);
		buttonGroup.getChildren().add(saveBookshelfButton);

		return buttonGroup;
	}

	private StackPane getContent(Stage stage)
	{
		pagination.setPageFactory(this::getPage);
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

	private FlowPane getPage(int pageIndex)
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
		pagination.setPageCount(bookshelfList.size() / 12 + (bookshelfList.size() % 12 == 0 ? 0 : 1));
	}
}