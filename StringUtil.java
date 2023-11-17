package songs;

public class StringUtil
{
    // Pads a string to length l
    public static String pad(String s, int l)
    {
        if (s.length() < l)
        {
            // append spaces until the string is the specified length
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < l)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
        else
        {
            // truncate the string to the specified length
            return s.substring(0, l);
        }
    }

}
