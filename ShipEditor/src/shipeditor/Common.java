package shipeditor;

import java.util.Random;

public class Common
{
	static Random rand;
	public static void sleep(int amt)
	{
	    long a = System.currentTimeMillis();
	    long b = System.currentTimeMillis();
	    while ((b - a) <= amt)
	    {
	        b = System.currentTimeMillis();
	    }
	}
	public static int randInt(int min, int max)
    {
            int toreturn = -1;
            while (toreturn < 0)
            {
                    rand = new Random();
                    int n = max - min + 1;
                    int i = rand.nextInt() % n;
                    toreturn = min + i;
            }
            return toreturn;
    }
}
