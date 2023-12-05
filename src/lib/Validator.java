package lib;

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
}