import config.Config;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lib.Lang;

public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		prepareStage(stage);
		stage.show();
	}

	private void prepareStage(Stage stage)
	{
		stage.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_TITLE"));

		Text subtitle = new Text(Lang.getInstance().getMessage("MAIN_WINDOW_SUBTITLE"));
		subtitle.setFont(new Font(20));
		subtitle.setLayoutX(50);
		subtitle.setLayoutY(60);

		Button bookshelfButton = new Button(Lang.getInstance().getMessage("MAIN_WINDOW_ADD_NEW_BOOKSHELF"));
		bookshelfButton.setLayoutX(700);
		bookshelfButton.setLayoutY(40);

		Group root = new Group(subtitle, new Group(bookshelfButton));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setWidth(Config.WINDOW_WIDTH);
		stage.setHeight(Config.WINDOW_HEIGHT);
		stage.setResizable(false);
	}
}