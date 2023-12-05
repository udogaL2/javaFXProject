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
		this.messageList.put("MAIN_WINDOW_SUBTITLE", "Список книжных библиотек");
		this.messageList.put("MAIN_WINDOW_ADD_NEW_BOOKSHELF", "Создать");
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