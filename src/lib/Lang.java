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
		this.messageList.put("MAIN_WINDOW_ADD_NEW_BOOKSHELF", "Создать");
		this.messageList.put("MAIN_WINDOW_SAVE_BOOKSHELF", "Сохранить");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_ID", "ID");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_TITLE", "Название");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DETAILS", "Подробнее");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE", "Удалить");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_TITLE", "Удаление книжной полки ");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_DESCRIPTION", "Вы уверены, что хотите удалить эту книжную полку? Все книги на полке будут удалены в том числе");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_CONFIRM", "Удалить");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DELETE_POPUP_CANCEL", "Закрыть");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DETAIL_TITLE", "Детальная страница книжной полки");
		this.messageList.put("MAIN_WINDOW_BOOKSHELF_DETAIL_SUBTITLE", "Список книг");
	}

	public String getMessage(String messageCode)
	{
		if (this.messageList.isEmpty() || !this.messageList.containsKey(messageCode))
		{
			return "";
		}

		return this.messageList.get(messageCode);
	}

	public static void print(String message)
	{
		System.out.println(message);
	}

	public static void print(String message, boolean isOnSameLine)
	{
		if (isOnSameLine)
		{
			System.out.print(message);
			return;
		}

		System.out.println(message);
	}
}