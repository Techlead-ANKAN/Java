class Teacher 
{
    void teach()
    {
        System.out.println("Teaching subjects");
    }
}

class child extends Teacher
{
    void listen()
    {
        System.out.println("Listening to teacher");
    }
}

class school
{
    public static void main(String[]args)
    {
        child s = new child();
        s.teach();
        s.listen();
    }
}

