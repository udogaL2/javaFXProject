package view;

import config.Config;
import controller.BookController;
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

public class CreateBookWindow
{
	public static Stage createBookStage = null;

	private static Bookshelf bookshelf;

	private static TextField titleTextField;
	private static TextField descriptionTextField;
	private static TextField publicationYearTextField;
	private static TextField ISBNTextField;
	private static TextField authorsTextField;
	private static TextField genresTextField;

	public static Stage getStage(Bookshelf bookshelf)
	{
		if (createBookStage == null)
		{
			createBookStage = new Stage();
		}

		CreateBookWindow.bookshelf = bookshelf;

		prepareStage();

		return createBookStage;
	}

	private static void prepareStage()
	{
		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE"));
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Group subtitleGroup = new Group(subtitle, getButtonGroup());

		Group content = new Group(subtitleGroup, getTextFieldGroup());

		Scene scene = new Scene(content);

		createBookStage.setScene(scene);
		createBookStage.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE"));
		createBookStage.setWidth(Config.WINDOW_WIDTH);
		createBookStage.setHeight(Config.WINDOW_HEIGHT);
		createBookStage.setResizable(false);
		createBookStage.setX(MainWindow.mainStage.getX() + 50);
		createBookStage.setY(MainWindow.mainStage.getY() + 50);
	}

	private static Group getButtonGroup()
	{
		Group buttonGroup = new Group();

		Button saveBookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_SAVE_BOOKSHELF"));
		saveBookshelfButton.setLayoutX(600);
		saveBookshelfButton.setLayoutY(40);
		saveBookshelfButton.setOnAction(actionEvent -> {
			String title = titleTextField.getText();
			String description = descriptionTextField.getText();
			String publicationYear = publicationYearTextField.getText();
			String ISBN = ISBNTextField.getText();
			String authors = authorsTextField.getText();
			String genres = genresTextField.getText();

			boolean result =
				Validator.isStringValid(title, 100)
				&& Validator.isStringValid(description, 250)
				&& Validator.isStringValid(publicationYear, 5)
				&& Validator.isNumeric(publicationYear)
				&& Validator.isStringValid(ISBN, 15)
				&& Validator.isNumeric(ISBN)
				&& Validator.isStringValid(authors, 60)
				&& Validator.isStringValid(genres, 60)
			;

			Alert alert = new Alert(result ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
			alert.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATION"));
			alert.setHeaderText(null);
			String contentText =
				result
				? Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_SUCCESSFULLY")
				: Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_UNSUCCESSFULLY");
			alert.setContentText(contentText);

			alert.showAndWait();

			if (result)
			{
				bookshelf.addBook(BookController.createNewBook(
					title,
					description,
					publicationYear,
					ISBN,
					authors,
					genres
				));

				BookshelfDetailWindow.updatePagination();
				createBookStage.close();
			}
		});

		buttonGroup.getChildren().add(saveBookshelfButton);

		return buttonGroup;
	}

	private static Group getTextFieldGroup()
	{
		Group textFieldGroup = new Group();

		Text titleText = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_TITLE"));
		titleText.setLayoutX(50);
		titleText.setLayoutY(164);

		titleTextField = new TextField();
		titleTextField.setText("");
		titleTextField.setLayoutX(250);
		titleTextField.setLayoutY(150);
		titleTextField.setMinWidth(400);

		Text descriptionText = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_DESCRIPTION"));
		descriptionText.setLayoutX(50);
		descriptionText.setLayoutY(194);

		descriptionTextField = new TextField();
		descriptionTextField.setText("");
		descriptionTextField.setLayoutX(250);
		descriptionTextField.setLayoutY(180);
		descriptionTextField.setMinWidth(400);

		Text publicationYearText = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_PUBLICATION_YEAR"));
		publicationYearText.setLayoutX(50);
		publicationYearText.setLayoutY(224);

		publicationYearTextField = new TextField();
		publicationYearTextField.setText("");
		publicationYearTextField.setLayoutX(250);
		publicationYearTextField.setLayoutY(210);
		publicationYearTextField.setMinWidth(400);

		Text ISBNText = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_ISBN"));
		ISBNText.setLayoutX(50);
		ISBNText.setLayoutY(254);

		ISBNTextField = new TextField();
		ISBNTextField.setText("");
		ISBNTextField.setLayoutX(250);
		ISBNTextField.setLayoutY(240);
		ISBNTextField.setMinWidth(400);

		Text authorsText = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_AUTHORS"));
		authorsText.setLayoutX(50);
		authorsText.setLayoutY(284);

		authorsTextField = new TextField();
		authorsTextField.setText("");
		authorsTextField.setLayoutX(250);
		authorsTextField.setLayoutY(270);
		authorsTextField.setMinWidth(400);

		Text genresText = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_BOOK_CREATE_GENRES"));
		genresText.setLayoutX(50);
		genresText.setLayoutY(314);

		genresTextField = new TextField();
		genresTextField.setText("");
		genresTextField.setLayoutX(250);
		genresTextField.setLayoutY(300);
		genresTextField.setMinWidth(400);

		textFieldGroup.getChildren().add(titleText);
		textFieldGroup.getChildren().add(titleTextField);
		textFieldGroup.getChildren().add(descriptionText);
		textFieldGroup.getChildren().add(descriptionTextField);
		textFieldGroup.getChildren().add(publicationYearText);
		textFieldGroup.getChildren().add(publicationYearTextField);
		textFieldGroup.getChildren().add(ISBNText);
		textFieldGroup.getChildren().add(ISBNTextField);
		textFieldGroup.getChildren().add(authorsText);
		textFieldGroup.getChildren().add(authorsTextField);
		textFieldGroup.getChildren().add(genresText);
		textFieldGroup.getChildren().add(genresTextField);

		return textFieldGroup;
	}
}
