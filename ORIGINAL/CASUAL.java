class A
{
    public void method1()                // Method 1 of class A
    {
        System.out.println("I am Method 1 of Class A");     
    }
}

class B extends A            // Class B is Inheriting Class A
{
    public void method1()               // Hewre I am Overriding(modifying/changing/updating) the same method - Method1
    {
        System.out.println("I am New Method 1 of Class A");
    }

    public void method2()               //Method 2 of Class B
    {
        System.out.println("I am Method 2 of Class B");
    }

    public static void main(String[]args)
    {
        B ob = new B();
        System.out.println("Result of calling ob.method1() --->");
        ob.method1();              // Calling method1
        System.out.println("Result of calling ob.method2() --->");
        ob.method2();              // Calling method2
    }
}


