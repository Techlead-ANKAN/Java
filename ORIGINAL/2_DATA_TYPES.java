// DATA TYPES - These are the type of values that we store inside a variable.
   
// 2 Types: 1) Primitive [int, long, double, short, char, byte, float, boolean]
//          2) Non-Primitive [String, Arrays, User Defined classes]

class DATA_TYPES
{
    public static void main(String[]args)
    {
        int a = 10;    // Size: 32bits, value ranges from -> (-2^32)/2 to [{(2^32)/2}-1]
        float b = 158.9f;    // Size: 32bits, value ranges from -> 
        long c = 10000000;   // Size: 64bits, value ranges from -> (-2^64)/2 to [{(2^64)/2}-1]
        double d = 182.278;  // Size: 64bits 
        char e = 'A';   // Size: 16bits, value ranges from 0 to 65535(2^16-1)
        byte f = 12;    // Size: 8bits, value ranges from -128 to 127
        short g = 2;    // Size: 16bits, value ranges from -> (-2^16)/2 to [{(2^16)/2}-1]
        boolean h = false; // Size: typically 1bit, but JVM dependant

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
