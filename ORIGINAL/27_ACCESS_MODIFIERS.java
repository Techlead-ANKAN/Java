// Acces Modifiers 

// Access Modifiers - The access modifiers in java specifies the accessebility of methods, variables, constructor, class etc

// There are 4 types of access modifiers:-
// 1) private - The access level of a private modifier is only within the class. It cannot be accessed from     outside the class.

// 2) public - The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.

// 3) default -  The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.

// 4) protected - The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package. 

// Access Modifier	    within class	within package	  outside package by subclass only	   outside package
// Private	                Y	                N	                    N	                            N
// Default	                Y	                Y	                    N	                            N
// Protected	            Y	                Y	                    Y	                            N
// Public	                Y	                Y	                    Y	                            Y

// No need for Access Modifier
// class A
// {
//     String var1;
//     int var2;
// }

// class B
// {
//     public static void main(String[]args)
//     {
//         A obj = new A();
//         obj.var1 = "A text";
//         obj.var2 = 123;

//         System.out.println("var1 = "+obj.var1);
//         System.out.println("var2 = "+obj.var2);

//     }
// }

// Getters and Setters 
// Getter --> Returns the value
// Setter --> Sets/updates the value

// class A
// {
//     private String var1;     
//     private int var2;

//     public void setvar1(String a)   // SETTERS
//     {
//         var1 =  a;
//     }

//     public String getvar1()         // GETTERS
//     {
//         return var1;
//     }

//     public void setvar2(int b)      // SETTERS
//     {
//         var2 = b;
//     }

//     public int getvar2()            // GETTERS
//     {
//         return var2;    
//     }
// }

// class B
// {
//     public static void main(String[]args)
//     {
//         A obj = new A();

//         obj.setvar1("Piu Maity");
//         System.out.println("var1 = "+obj.getvar1());

//         obj.setvar2(0304);
//         System.out.println("var2 = "+obj.getvar2());

//     }
// }