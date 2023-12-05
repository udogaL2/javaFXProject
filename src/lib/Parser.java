package lib;

import static config.Config.DATE_FORMAT;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser
{
	public static DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static int parseRawStringToInt(String rowString)
    {
        return Integer.parseInt(rowString);
    }

	public static String parseDateToString(Date date)
	{
		return dateFormat.format(date);
	}

	public static Date parseStringToDate(String rowString)
	{
		try
		{
			return dateFormat.parse(rowString);
		}
		catch (ParseException exception)
		{
			return null;
		}
	}
}