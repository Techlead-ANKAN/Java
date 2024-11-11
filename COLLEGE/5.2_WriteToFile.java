import java.io.FileWriter;
import java.io.IOException;
class WriteToFile
{
   
    public static void main(String[]args)
    {
        try
        {
            FileWriter fwrite = new FileWriter("D:Sample.txt");
            fwrite.write("A named location used to store related information is refrred to as a FILE.");
        
        fwrite.close();
        System.out.println("Content is successfully wrote to the file.");
        }
    catch(IOException e)
    {
        System.out.println("Unexpected error occurred");
        e.printStackTrace();
    }
} 
}
