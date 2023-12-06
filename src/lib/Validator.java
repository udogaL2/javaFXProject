package lib;

import java.io.File;
import java.util.regex.Pattern;

import static config.Config.DATE_PATTERN;

public class Validator
{
	public static int isNumeric(String string)
	{
		try
		{
			return Integer.parseInt(string);
		}
		catch (NumberFormatException e)
		{
			return -1;
		}
	}

	public static boolean isStringValid(String string, int maxLen)
	{
		return !string.isEmpty() && string.length() < maxLen;
	}

	public static boolean isRowDateStringValid(String rowDateString)
	{
		return Pattern.matches(DATE_PATTERN, rowDateString);
	}

	public static boolean isFileExists(String filePath) {
		File file = new File(filePath);

		return file.exists() && !file.isDirectory();
	}
}