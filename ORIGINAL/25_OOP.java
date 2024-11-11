// Object Oriented Programming [ OOP ]

// 1) Why we should use Object Oriented Programming?
// --> Object Oriented Programming provides a clear structure for the programs. OOP helps to keep the JAVA code DRY [ Do not Repeat Yourself ], and makes the code easier to maintain, modify and debug.

// 2) What is Object Oriented Programming?
// --> Object Oriented Programming is a programming paradigm that relies on the concept of classes and objects. It is used to structure a software program into simple, reusable pieces of code blueprints, which are used to create inddiviual instances of objects.

                                                        // OR

// Solving a problem by creating objects is one of the most popular approaches in programming. This is called Object Oriented Programming.


// # It follows the principle "DRY" - Do Not Repeat Yourself (Focuses on the code readability)

// 3) Class --> A class is a blueprint from which indiviual objects can be created.

        // class  =>  Object Instantiation  => Object


// 4) Object --> An object is an instance of a class.

// Note:- Each object has an Identity, a Behaviour and a State
            // State - Represents the data(value) of the object.
            // Behaviour - represents the functionality of the object. 
            // Identity - It is used internally by the JVM to identify each object uniquely. 

// 5) How to model a problem in OOP?
// --> Example:- 
// Noun      -> Class      -> Employee
// Adjective -> Attributes -> Name, Age, Salary
// Verb      -> Methods    -> getsalary(), getdetails()


/* OOP Concepts */

// 1) Abstraction - Abstracion refers to the process of showing the essential information to the outside world and hiding the unnecessary background details. 

// 2) Encapsulation - Encapuslation refers to the binding of data(variables) and code(methods) into a single unit.
//                    Ex:- A Laptop -> it is a single thing(Entity) that consists of speaker, camera, keyboard, screen, etc.

// 3) Inheritance - It is the mechanism in java by which one class is allowed to inherit the features(fields and methods) of another class.
                //     Example:- Rickshaw   ->    E-Rickshaw
                //               Phone      ->    Smartphone

// 4) Polymorphism - Polymorphism can be defind as the ability of an object to take many forms.
//                 Example:-       Smartphone 
//                           Forms:- 
//                            i) Audio player
//                            ii) Video player
//                            iii) camera
//                            iv) calculator
                           
// Example Code:-

// Topic = Employee
class OOP
{
        String name;
        int job_id;
        int salary;
        int increment;

        public String get_name()
        {
                return (name);
        }

        public void get_details()
        {
                System.out.println("Employee Details: \nJob Id - "+job_id+"\nSalary - "+salary+"\nIncrement - "+increment);
        }

        public double final_salary()
        {
                return (salary+increment);
        }

        public static void main(String[]args)
        {
                OOP EMP1 = new OOP();   // Creating(Taking, Instantiating) an Employee
                OOP EMP2 = new OOP();   // Creating(Taking, INstantiating) a new Employee


                // Setting attributes for the 1st Employee
                EMP1.name = "Ankan Maity";
                EMP1.job_id = 2915;
                EMP1.salary = 250000;
                EMP1.increment = 50000;

                // Setting attributes for the 2nd Employee
                EMP2.name = "Piu Maity";
                EMP2.job_id = 3115;
                EMP2.salary = 250000;
                EMP2.increment = 50000;
                
                // Printing the attributes of Ankan Maity
                System.out.println("Employee Name: "+EMP1.get_name());
                EMP1.get_details();
                System.out.println("Final Salary - "+EMP1.final_salary());

                // Printing the attributes of Piu Maity
                System.out.println("Employee Name: "+EMP2.get_name());
                EMP2.get_details();
                System.out.println("Final Salary - "+EMP2.final_salary());
        }
}
