// PRACTIEC SHEET - 06


// Q1) Create an array of 5 floats and print their sum.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         float [] a = {1,2,3,4,5};
//         float sum = 0;
//         for(float element : a)
//         {
//             sum = sum + element;
//         }
//         System.out.println("Sum = "+sum);
//     }
// }


// Q2) Write a program to find out whether a given integer is present in an array or not.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int [] a = {1,2,3,4,5,6};
//         for (int element:a)
//         {
//             if (element == 2)
//             {
//                 System.out.println("Present");
//                 break;
//             }
//         }
//     }
// }


// Q3) Calculate the average marks of an array containing marks of all students in Physics using for-each loop.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int [] marks = {95,98,97,99};
//         int sum = 0;
//         int size = marks.length;

//         for(int element:marks)
//         {
//             sum = sum + element;
//         }
//         System.out.println("Average: "+(sum/size));
//     }
// }


// Q4) Create a java code to add 2 matrices of size 2x3.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int [][] a = {{1,2,3},{4,5,6}};
//         int [][] b = {{1,2,3},{4,5,6}};
//         int sum[][] = new int[2][3];
//         int i,j;
        
//         for(i=0;i<2;i++)
//         {
//             for(j=0;j<3;j++)
//             {
//                 sum[i][j] = a[i][j] + b[i][j];
//                 System.out.print(sum[i][j]+ " ");
//             }
//             System.out.println();
//         }
//     }
// }


// Q5) Write a java program to reverse an array

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int [] a = new int[4];
//         a[0] = 1;
//         a[1] = 2;
//         a[2] = 3;
//         a[3] = 4;

//         for (int i = a.length-1;i>=0;i--)
//         {
//             System.out.println(a[i]);
//         }
//     }
// }


// Q6) Write a java program to find the maximum elemnt in java.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int [] a = {1,4,2,7,91,5,3,1,4,7,85,2,5};
//         int max = a[0];

//         for(int element : a)
//         {
//             if (element > max)
//                 max = element;
//         }
//         System.out.println("Max: "+max);
//     }
// }


// Q7) Write a java program to find the minimum elemnt in java.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int [] a = {1,4,2,7,91,5,3,1,4,7,85,2,5};
//         int min = a[0];

//         for(int element : a)
//         {
//             if (element < min)
//                 min = element;
//         }
//         System.out.println("Min: "+min);
//     }
// } 


// Q8) Write a java program to find whether the array is sorted or not.

// class Practice_Sheet
// {
//     public static void main (String[]args)
//     {
//         int [] a = {1,2,3,4,5,3};
//         int flag = 0;
//         for(int i = 0;i<a.length-1;i++)
//         {
//             if (a[i]<a[i+1])
//                 flag = 1;
//         }
//         if (flag == 1)
//             System.out.println("Sorted Array");
//         else
//             System.out.println("Un-Sorted Array");

//     }
// }