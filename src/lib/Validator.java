package lib;

import config.Config;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import static config.Config.DATE_PATTERN;

public class Validator
{
	public static boolean isNumeric(String string)
	{
		try
		{
			Integer.parseInt(string);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

	public static boolean isStringValid(String string, int maxLen)
	{
		return !string.isEmpty() && string.length() < maxLen;
	}

	public static boolean isFileExists(String filePath) {
		File file = new File(filePath);

		return file.exists() && !file.isDirectory();
	}

	public static void createFile() throws IOException
	{
		File file = new File(Config.PATH_TO_SAVE);

		file.createNewFile();
	}
}