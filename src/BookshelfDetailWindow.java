import config.Config;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lib.Lang;
import model.Bookshelf;

public class BookshelfDetailWindow
{
	public static Stage getStage(Bookshelf bookshelf)
	{
		Label secondLabel = new Label(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAIL_SUBTITLE"));

		StackPane secondaryLayout = new StackPane();
		secondaryLayout.getChildren().add(secondLabel);

		Scene secondScene = new Scene(secondaryLayout, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

		Stage newWindow = new Stage();
		newWindow.setTitle(Lang.getInstance().getMessage("MAIN_WINDOW_BOOKSHELF_DETAIL_TITLE") + ' ' + bookshelf.getTitle());
		newWindow.setScene(secondScene);

		newWindow.setX(Main.mainStage.getX() + 50);
		newWindow.setY(Main.mainStage.getY() + 50);

		return newWindow;
	}
}
