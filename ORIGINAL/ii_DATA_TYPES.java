// DATA TYPES - These are the type of values that we store inside a variable.
   
// 2 Types: 1) Primitive [int, long, double, short, char, byte, float, boolean]
//          2) Non-Primitive [String, Arrays, User Defined classes]

class ii_DATA_TYPES
{
    public static void main(String[]args)
    {
        int a = 10;    // value ranges from -> (-2^32)/2 to [{(2^32)/2}-1]
        float b = 158.9f;    // value ranges from -> 
        long c = 10000000;   // value ranges from -> (-2^64)/2 to [{(2^64)/2}-1]
        double d = 182.278;   
        char e = 'A';   // value ranges from 0 to 65535(2^16-1)
        byte f = 12;    //  value ranges from -128 to 127
        short g = 2;    //  value ranges from -> (-2^16)/2 to [{(2^16)/2}-1]
        boolean h = false ;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);        
    }
}
