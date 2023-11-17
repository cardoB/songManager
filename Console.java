package songs;

import java.util.Scanner;

public class Console
{

    private static Scanner sc = new Scanner(System.in);

    // Takes a String from the user
    public static String getString(String prompt)
    {
        System.out.println(prompt);
        String s = sc.nextLine();
        return s;
    }

    // Takes a Double from the user
    public static double getDouble(String prompt)
    {
        while (true)
        {
            System.out.println(prompt);
            try
            {
                double theDouble = Double.parseDouble(sc.nextLine());
                return theDouble;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Error. Input must be a number.");
            }
        }
    }

    // Takes an int from the user
    public static int getInt(String prompt)
    {
        while (true)
        {
            System.out.println(prompt);
            try
            {
                int theInt = Integer.parseInt(sc.nextLine());
                return theInt;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Error. Input must be an integer");
            }
        }
    }
}
