import java.util.Scanner;
class FindLeapLogic {
 int year;
 boolean leap=false;
 void logic(int x)
 {
 year=x;
 if(year%4==0)
 {
 if(year%100==0)
 {
 if(year%400==0)
 {
 leap=true; 
 }
 else
 {
 leap=false;
 }
 }
 else
 {
 leap=true;
 }
 }
 else
 {
 leap=false;
 }
 } }
class DisplayYear extends FindLeapLogic
{
 void display()
 {
 if(leap) 
 {
 System.out.println(year + " is a leap year (@_@)");
 }
 else 
 {
 System.out.println(year+" is not a leap year [@_@]");
 }
 } }
class LeapYearInheritance {
 public static void main(String arg[])
 {
 
 DisplayYear d1=new DisplayYear();
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter Year: ");
 int y=sc.nextInt();
 d1.logic(y);
 d1.display();
 } }