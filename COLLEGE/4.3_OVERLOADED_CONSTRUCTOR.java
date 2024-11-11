class OVERLOADED_CONSTRUCTOR
{
    int value1;
    int value2;
    OVERLOADED_CONSTRUCTOR()
    {
        value1 = 10;
        value2 = 20;
        System.out.println("Inside 1st Constructor");
    }
    OVERLOADED_CONSTRUCTOR(int a)
    {
        value1 = a;
        System.out.println("Inside 2nd Constructor");
    }
    OVERLOADED_CONSTRUCTOR(int a, int b)
    {
        value1 = a;
        value2 = b;
        System.out.println("Inside 3rd Constructor");
    }
    public void display()
    {
        System.out.println("Value1 = "+value1);
        System.out.println("Value2 = "+value2);
    }
    public static void main(String[]args)
    {
    OVERLOADED_CONSTRUCTOR d1 = new OVERLOADED_CONSTRUCTOR();
    OVERLOADED_CONSTRUCTOR d2 = new OVERLOADED_CONSTRUCTOR(30);
    OVERLOADED_CONSTRUCTOR d3 = new OVERLOADED_CONSTRUCTOR(30, 40);
    d1.display();
    d2.display();
    d3.display();
}
}