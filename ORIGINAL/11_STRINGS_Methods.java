// STRING METHODS
class xi_STRINGS_Methods
{
    public static void main(String[]args)
    {
        // 1) charAt(index) -> Return the character at the specified index.
        String s1 = "ANKAN MAITY";
        char res1 = s1.charAt(2);
        System.out.println("Character at index 2: "+res1);

        // 2) codePointAt(index) -> Returns the unicdoe value of the character at the specified string
        String s2 =  "HELLO";
        int res2 = s2.codePointAt(2);
        System.out.println("Unicode value of char at index 2: "+ res2);

        // 3) codePointBefore(index) -> Returns the unicode value of the character at before the specified index.
        String s3 = "HELLO";
        int res3 = s3.codePointBefore(2);
        System.out.println("Unicode value of char at index-1: "+res3);

        // 4) codePointCount(start, end) -> Returns the no.of unocde values found in the string.
        String s4 = "HELLO";
        int res4 = s4.codePointCount(0,5);
        System.out.println("No.of unicode values: "+res4);

        // 5) String1.compareTo(String2) -> Comapres 2 strings lexicographically
        String s5 = "Ankan", S5 = "Ankan";
        int res5 = s5.compareTo(S5);
        System.out.println(res5);

        // 6) String1.compareToIgnoreCase(String2) -> Compares two strings lexicographically ignoring the case diff.
        String s6 = "ANKAN", S6 = "ankan";
        int res6 =s6.compareToIgnoreCase(S6);
        System.out.println(res6);

        // 7) (String1).concat(String2) -> Appends string2 at the end of string1
        String s7 = "ANKAN ", S7 = "MAITY";
        System.out.println(s7.concat(S7));

        // 8) String.contains(String2 or char) -> Returns true if String contains String2 or char
        String s8 = "ANKAN";
        String S8 = "AN";
        String s_8 = "A";
        System.out.println(s8.contains(S8));
        System.out.println(s8.contains(s_8));

        // 9) String2.copyValueOf(char_array,start,end) -> Returns a string that represents the characters of a charcater array.
        char [] s9 = {'A', 'N','K','A','N'};
        String S9 = "";
        S9 = S9.copyValueOf(s9,0,5);
        System.out.println("String: "+S9);

        // 10) String1.endsWith(String2) -> checks whether string1 ends with string2
        String s10 = "ANKAN", S10 = "AN";
        System.out.println(s10.endsWith(S10));

        // 11) String1.equals(String2) -> Returns true if String1 is same as that of String2
        String s11 = "Hello";
        String S11 = "Hello";
        String S_11 = "ANKAN";
        System.out.println(s11.equals(S11));
        System.out.println(s11.equals(S_11));

        // 12) String1.equalsIgnoreCase(String2) -> Returns true if String1 is same as that of String2 ignoring the case difference.
        String s12 = "HELLO";
        String S12 = "hello";
        String S_12 = "ANKAN";
        System.out.println(s12.equalsIgnoreCase(S12));
        System.out.println(s12.equalsIgnoreCase(S_12));

        // 13) char1.getChars(String)
        
        // 14) String.hashCode() -> returns the hash code for the string.
        String s14 = "ANKAN MAITY";
        System.out.println("Hash Code: "+s14.hashCode());

        // 15) String1.indexOf(substring/char) -> Returns the index of the first ocuurence of the specified sub-string.
        String s15 = "ANKAN MAITY IS A GOOD BOY";
        char c15 = 'M';
        String S15 = "BOY";
        System.out.println(s15.indexOf(S15));
        System.out.println(s15.indexOf(c15));

        // 16) String.isEMPTY() -> Returns true if String is empty.
        String s16 = "ANKAN";
        System.out.println(s16.isEmpty());

        // 17) String1.lastIndexOf(String2) -> Returns the last occurrence of any specified string in the string..
        String s17 = "Ankan is a good boy. Ankan is coding.";
        String S17 = "Ankan";
        System.out.println(s17.lastIndexOf(S17));

        // 18) String.length() -> Returns the length of the string.
        String s18 = "ANKAN";
        System.out.println("Length = "+(s18.length()));

        // 19) String.replace(old, new) -> Replaces the specified string with the new string.
        String s19 = "ANKAN";
        System.out.println(s19.replace('A', '#'));

        // 20) String.replaceFirst(old,new) -> Replaces the first occurence of the specified string with the new string.
        String s20 = "ANKAN IS A GOOD BOY. ANKAN IS CODING";
        System.out.println(s20.replaceFirst("ANKAN", "CODER"));

        // 21) String.replaceAll(old,new) -> Replaces the all occurences of the specified string with the new string.
        String s21 = "ANKAN IS A GOOD BOY. ANKAN IS CODING";
        System.out.println(s21.replaceAll("ANKAN", "CODER"));

        // 22) String.split(" ") -> Splits the string into array of substrings.
        
        // 23) String.substring(start,end) -> Returns a substring from the string.
        String s23 = "ANKAN MAITY.";
        System.out.println(s23.substring(0,5));

        // 24) String.toUpperCase() -> Converts the string to Upper Case
        String s24 = "ankan maity";
        System.out.println("In upper Case: "+(s24.toUpperCase()));

        // 25) String.toLowerCase() -> Converts the string to Lower case
        String s25 = "ANKAN MAITY";
        System.out.println("In Lower Case: "+(s25.toLowerCase()));

        // 26) String.trim() -> Removes white spaces from both ends of the string
        String s26 = "  Ankan Maity   ";
        System.out.println("Trimmed: "+(s26.trim()));        
    }
}


// LIST OF METHODS:-

// Method	                                            Description
                                
// charAt()	                     Returns the character at the specified index (position)	                                                                                
// codePointAt()	             Returns the Unicode of the character at the specified index	                                                                             
// codePointBefore()	         Returns the Unicode of the character before the specified index	
// codePointCount()	             Returns the number of Unicode values found in a string.	
// compareTo()	                 Compares two strings lexicographically	
// compareToIgnoreCase()	     Compares two strings lexicographically, ignoring case differences	
// concat()	                     Appends a string to the end of another string	
// contains()	                 Checks whether a string contains a sequence of characters	
// contentEquals()	             Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer	
// copyValueOf()	             Returns a String that represents the characters of the character array	
// endsWith()	                 Checks whether a string ends with the specified character(s)	
// equals()	                     Compares two strings. Returns true if the strings are equal, and false if not	
// equalsIgnoreCase()	         Compares two strings, ignoring case considerations	
// format()	                     Returns a formatted string using the specified locale, format string, and arguments	
// getBytes()	                 Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array	
// getChars()	                 Copies characters from a string to an array of chars	
// hashCode()	                 Returns the hash code of a string	
// indexOf()	                 Returns the position of the first found occurrence of specified characters in a string	
// intern()	                     Returns the canonical representation for the string object	
// isEmpty()	                 Checks whether a string is empty or not
// lastIndexOf()	             Returns the position of the last found occurrence of specified characters in a string	
// length()	                     Returns the length of a specified string	
// matches()	                 Searches a string for a match against a regular expression, and returns the matches	
// offsetByCodePoints()	         Returns the index within this String that is offset from the given index by codePointOffset code points	
// regionMatches()	             Tests if two string regions are equal	
// replace()	                 Searches a string for a specified value, and returns a new string where the specified values are replaced	
// replaceFirst()	             Replaces the first occurrence of a substring that matches the given regular expression with the given replacement
// replaceAll()	                 Replaces each substring of this string that matches the given regular expression with the given replacement	
// split()	                     Splits a string into an array of substrings	
// startsWith()	                 Checks whether a string starts with specified characters
// subSequence()	             Returns a new character sequence that is a subsequence of this sequence	
// substring()	                 Returns a new string which is the substring of a specified string	String
// toCharArray()	             Converts this string to a new character array	
// toLowerCase()	             Converts a string to lower case letters	
// toString()	                 Returns the value of a String object	
// toUpperCase()	             Converts a string to upper case letters	
// trim()	                     Removes whitespace from both ends of a string	
// valueOf()	                 Returns the string representation of the specified value
     