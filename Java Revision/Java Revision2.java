// You are using Java
import java.util.*;
class InsufficientBalanceException extends Exception
{
    InsufficientBalanceException(String s)
    {
        super(s);
    }
}
class Sample
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double balance = sc.nextDouble();
        double withdrawal = sc.nextDouble();
        try
        {
            if(balance>=withdrawal)
            {
                System.out.println("Transaction successful.");
            }
            else
            {
                throw new InsufficientBalanceException("Insufficient balance: Insufficient balance to perform the withdrawal.");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
   }
}