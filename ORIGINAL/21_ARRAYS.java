// ARRAYS -> It is a collection of elements of similar data type.

// There are 2 types of array:-
// 1) Single Dimensional
// 2) Multi Dimensional

/* Single Dimensional */

// (A)
// Syntax:     data_type [] array name = new  data_type[size];
            //             |                    |
            //             |                    |   
            //            \ /                  \ /
            //  Array Declaration       Memory Allocation

// class ARRAYS
// {
//     public static void main(String[]args)
//     {
//         // Type of Declaring an array: 
        
//         // 1) Declaration + Memory Allocation(DIRECTLY)
//         int [] a = new int[5];

//         // 2) Declaration & Memory Allocation (SEPARATELY)
//         float [] b;
//         b = new float[5];

//         // 3) Declaration + Initialization  (In this case JAVA identifies the size automatically, no need for size declaration externally.)
//         double [] c = {1,2,3,6,5,4,7,8,9};


//         // Assigning values in an array:
//         a[0] = 60;             b[0] = 60;
//         a[1] = 70;             b[1] = 70;
//         a[2] = 80;             b[2] = 80;
//         a[3] = 90;             b[3] = 90;
//         a[4] = 100;            b[4] = 100;

//         // * Arrays are "Mutable"
//         a[1] = 999; // -> Now the value of the elemnt at 1st index is 999

//         // Size of an Array(length)
//         int len_a = a.length;
//         System.out.println(len_a);
//         int len_b = b.length;
//         System.out.println(len_b);
//         System.out.println(c.length);

//         // Displaying elements of an array:
//         // 1) Manually
//         System.out.println(a[0]);                System.out.println(b[0]);       
//         System.out.println(a[1]);                System.out.println(b[1]);
//         System.out.println(a[2]);                System.out.println(b[2]);
//         System.out.println(a[3]);                System.out.println(b[3]);
//         System.out.println(a[4]);                System.out.println(b[4]);

//         // 2) Naive Way:
//         for (int i = 0;i<len_a;i++)
//         {
//             System.out.println(a[i]);
//         }
        
//         // 3) for-each loop in java:

//         // Synatx:
//         // for(data_type "element" : array_name)
//         // {
//         //     System.out.println("element");
//         // }

//         for(int element : a)
//         {
//             System.out.println(element);
//         }
//     }
// }


/* Multi Dimensional */

    
// (A) Syntax:        data_type   [][]...[]  =  new  data_type[size][size]...[size];
//                           |          |                |
//                           |          |                |
//                          \ /         |               \ /
//                       Declaration    |         Memory Allocation
//                                      |
//                                     \ /
//                 Depends on array Diemnsion([][][] -> 3x3; [][] -> 2x2) 

class ARRAYS
{
    public static void main(String[]args)
    {

        // Types of declaring an array:

        // 1) Declaration + Memory Allocation (DIRECTLY)
        int [][] a = new int [2][2];

        // 2) Declaration & Memory Allocation (SEPARATELY)
        float [][] b;
        b = new float [2][2];

        // 3) Declaration + Initialization  (In this case JAVA identifies the size automatically, no need for size declaration externally.)
        double [][] c = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};


        // Assigning Values in an array:
        a[0][0] = 1;        b[0][0] = 1;
        a[0][1] = 2;        b[0][1] = 2;
        a[1][0] = 3;        b[1][0] = 3;
        a[1][1] = 4;        b[1][1] = 4;

        // * Arrays are "Mutable"
        a[1][0] = 999; // -> Now the value of the elemnt at 1st index is 999

        // Size of an Array(length)
        int len_a = a.length;
        System.out.println(len_a);
        int len_b = b.length;
        System.out.println(len_b);

        // Displaying elements of an array:
        // 1) Manually
        System.out.println(a[0][0]);                System.out.println(b[0][0]);       
        System.out.println(a[0][1]);                System.out.println(b[0][0]);
        System.out.println(a[1][0]);                System.out.println(a[1][0]);
        System.out.println(a[1][1]);                System.out.println(a[1][1]);

        // 2) Naive Way:
        // (Array - c)
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }

    }
}

