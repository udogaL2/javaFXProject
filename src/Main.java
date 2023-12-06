import controller.BookshelfController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainWindow;

public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		MainWindow.getStage().show();
	}
}