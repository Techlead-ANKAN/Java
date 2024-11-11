// ESCAPE SEQUENCES

class xii_ESCAPE_SEQUENCE
{
    public static void main(String[]args)
    {
        /*ESCAPE SEQUENCES*/

        
        String test = "Ankan is a good boy.He is good in coding.";

        // 1) \t -> Inserts tab
        String tab = "Ankan is a good boy.\tHe is good in coding.";
        
        // 2) \b -> Inserts backspace
        String backspace = "Ankan is a good boy. \bHe is good in coding.";

        // 3) \n -> Inserts newline
        String newline = "Ankan is a good boy. \nHe is good in coding.";

        // 4) \r -> Returns the carriage
        String carriage = "Ankan is a good boy.\r He is good in coding.";

        // 5) \' -> Inserts Single Quote
        String single_quote = "Ankan is \'a\' good boy. He is good in coding.";

        // 6) \" -> Inserts Double Quote
        String double_quote = "\"Ankan\" is a good boy. He is good in coding.";

        // 7) \\ -> Inserts Backslash
        String backslash = "Ankan is a good boy.\\He is good in coding.";

        System.out.println("Orginal-> "+test);
        System.out.println(tab);
        System.out.println(backspace);
        System.out.println(newline);
        System.out.println(carriage);
        System.out.println(single_quote);
        System.out.println(double_quote);
        System.out.println(backslash);



    }
}