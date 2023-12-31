package utilities;

public class Attempts
{
    public static final int TOTAL_ATTEMPTS = 4;
    public static boolean attempts(int attempts)
    {
        if (attempts <= 0)
        {
            System.out.println("Todas as tentativas foram inválidas!\n");
            return true;
        }
        return false;
    }
}