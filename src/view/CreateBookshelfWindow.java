package view;

import config.Config;
import controller.BookshelfController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lib.Lang;
import lib.Validator;
import model.Bookshelf;

public class CreateBookshelfWindow
{
	public static Stage createBookshelfStage = null;

	private static TextField titleTextField;

	public static Stage getStage()
	{
		if (createBookshelfStage == null)
		{
			createBookshelfStage = new Stage();
		}

		prepareStage();

		return createBookshelfStage;
	}

	private static void prepareStage()
	{
		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_CREATE"));
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Group subtitleGroup = new Group(subtitle, getButtonGroup());

		Group content = new Group(subtitleGroup, getTextFieldGroup());

		Scene scene = new Scene(content);

		createBookshelfStage.setScene(scene);
		createBookshelfStage.setWidth(Config.WINDOW_WIDTH);
		createBookshelfStage.setHeight(Config.WINDOW_HEIGHT / 2);
		createBookshelfStage.setResizable(false);
		createBookshelfStage.setX(MainWindow.mainStage.getX() + 50);
		createBookshelfStage.setY(MainWindow.mainStage.getY() + 50);
	}

	private static Group getButtonGroup()
	{
		Group buttonGroup = new Group();

		Button saveBookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_SAVE_BOOKSHELF"));
		saveBookshelfButton.setLayoutX(600);
		saveBookshelfButton.setLayoutY(40);
		saveBookshelfButton.setOnAction(actionEvent -> {
			String title = titleTextField.getText();

			boolean result = Validator.isStringValid(title, 256);

			MainWindow.bookshelfList.add(BookshelfController.createNewBookshelf(title));

			Alert alert = new Alert(result ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
			alert.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_CREATION"));
			alert.setHeaderText(null);
			String contentText = result ? Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_CREATE_SUCCESSFULLY") : Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_SAVE_UNSUCCESSFULLY");
			alert.setContentText(contentText);

			alert.showAndWait();

			if (result)
			{
				MainWindow.updatePagination();
				createBookshelfStage.close();
			}
		});

		buttonGroup.getChildren().add(saveBookshelfButton);

		return buttonGroup;
	}

	private static Group getTextFieldGroup()
	{
		Group textFieldGroup = new Group();

		Text titleText = new Text("Название книжной полки");
		titleText.setLayoutX(50);
		titleText.setLayoutY(134);

		titleTextField = new TextField();
		titleTextField.setText("");
		titleTextField.setLayoutX(250);
		titleTextField.setLayoutY(120);
		titleTextField.setMinWidth(200);

		textFieldGroup.getChildren().add(titleText);
		textFieldGroup.getChildren().add(titleTextField);

		return textFieldGroup;
	}
}
