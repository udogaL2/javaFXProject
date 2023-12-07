package lib;

import java.util.HashMap;
import java.util.Map;

public class Lang
{
	private static Lang instance = null;
	Map<String, String> messageList;

	private Lang()
	{
		this.messageList = new HashMap<String, String>();

		this.init();
	}

	public static Lang getInstance()
	{
		if (instance == null)
		{
			instance = new Lang();
		}

		return instance;
	}

	private void init()
	{
		this.messageList.put("MAIN_WINDOW_TITLE", "LitLab - личная библиотека");
		this.messageList.put("MAIN_WINDOW_SUBTITLE", "Список книжных полок");
		this.messageList.put("MAIN_WINDOW_ADD_NEW", "Создать");
		this.messageList.put("MAIN_WINDOW_SAVE_BOOKSHELF", "Сохранить");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_ID", "ID");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_TITLE", "Название");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DETAILS", "Подробнее");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE", "Удалить");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_TITLE", "Удаление книжной полки");
		this.messageList.put("MAIN_WINDOW_BOOK_DELETE_POPUP_TITLE", "Удаление книги");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_DESCRIPTION", "Вы уверены, что хотите удалить эту книжную полку? Все книги на полке будут удалены в том числе");
		this.messageList.put("MAIN_WINDOW_BOOK_DELETE_POPUP_DESCRIPTION", "Вы уверены, что хотите удалить эту книгу?");
		this.messageList.put("MAIN_WINDOW_DELETE_POPUP_CONFIRM", "Удалить");
		this.messageList.put("MAIN_WINDOW_DELETE_POPUP_CANCEL", "Закрыть");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DETAIL_TITLE", "Детальная страница книжной полки");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DETAIL_SUBTITLE", "Список книг");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_SAVE", "Сохранение книжных полок");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_SAVE_SUCCESSFULLY", "Книжные полки успешно сохранены");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_SAVE_UNSUCCESSFULLY", "Произошла ошибка при сохранении книжных полок");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_EMPTY_STATE", "Информации о книжных полках нет");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_CREATE", "Создать новую книжную полку");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_CREATION", "Создание книжной полки");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_CREATE_SUCCESSFULLY", "Новая книжная полка успешно создана");
		this.messageList.put("MAIN_WINDOW_CREATE_UNSUCCESSFULLY", "Ошибка, введены некорректные данные");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_CREATE_TITLE", "Название книжной полки");

		this.messageList.put("MAIN_WINDOW_BOOK_ID", "ID");
		this.messageList.put("MAIN_WINDOW_BOOK_TITLE", "Название");
		this.messageList.put("MAIN_WINDOW_BOOK_DESCRIPTION", "Описание");
		this.messageList.put("MAIN_WINDOW_BOOK_YEAR", "Год");
		this.messageList.put("MAIN_WINDOW_BOOK_ISBN", "ISBN");
		this.messageList.put("MAIN_WINDOW_BOOK_AUTHORS", "Автор");
		this.messageList.put("MAIN_WINDOW_BOOK_GENRES", "Жанр");
		this.messageList.put("MAIN_WINDOW_BOOK_EMPTY_STATE", "Информации о книгах нет");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE", "Создать новую книгу");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATION", "Создание книги");

		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_TITLE", "Название книги");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_DESCRIPTION", "Описание книги");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_PUBLICATION_YEAR", "Год публикации книги");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_ISBN", "ISBN книги");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_AUTHORS", "Авторы книги");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_GENRES", "Жанры книги");

		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_SUCCESSFULLY", "Новая книга успешно создана");
		this.messageList.put("MAIN_WINDOW_BOOK_CREATE_UNSUCCESSFULLY", "Ошибка, введены некорректные данные");
	}

	public String getMessage(String messageCode)
	{
		if (this.messageList.isEmpty() || !this.messageList.containsKey(messageCode))
		{
			return "";
		}

		return this.messageList.get(messageCode);
	}
}