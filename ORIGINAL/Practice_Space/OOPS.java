
// Class 
class vehicle{

    // Attributes of Class
    String company;
    String name;
    String color;
    int price;


    // Non-Parameterized Constructor
    vehicle(){
        System.out.println("Non-Parameterized Constructor called during object creation");
    }

    // Parameterized Constructor
    vehicle(String company, String name, String color, int price){
        System.out.println("\nParameterized Constructor called during object creation");
        this.company = company;
        this.name = name;
        this.color = color;
        this.price = price;
    }

    // Copy-Constructor
    vehicle (vehicle v){
        System.out.println("\nCopy-Constructor called during object creation");
        this.company = v.company;
        this.name = v.name;
        this.color = v.color;
        this.price = v.price;
    }

    public void show_info(String company){
        System.out.println("Vehicle Company: "+company);
    }

    public void show_info(String company, String name){
        System.out.println("Vehicle Company: "+company+"\nVehicle Name: "+name);
    }

    public void show_info(String company, String name, String color, int price){
        System.out.println("Vehicle Company: "+company+"\nVehicle Name: "+name+"\nVehicle Color: "+color+"\nVehicle Price: "+price+"/-");
    }
}

public class OOPS{

    public static void main(String args[]){

        vehicle v1 = new vehicle();
        v1.company = "BMW";
        v1.name = "i5";
        v1.color = "Black";
        v1.price = 10000000;
        
        v1.show_info(v1.company);


        vehicle v2 = new vehicle("BMW", "i5", "Black", 10000000);  // Object

        v2.show_info(v2.company, v2.name);


        vehicle v3 = new vehicle(v2);

        v3.show_info(v3.company, v3.name, v3.color, v3.price);

    }

}