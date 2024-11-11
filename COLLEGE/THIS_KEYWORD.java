// 4.2
public class THIS_KEYWORD
{
    int x;
    public THIS_KEYWORD (int x)
    {
        this.x = x;
    }
    public static void main(String[]args)
    {
        THIS_KEYWORD myObj = new THIS_KEYWORD(5);
        System.out.println("Value of X = "+myObj.x);
    }
}