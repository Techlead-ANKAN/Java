import java.io.File;

class FILE_INFO
{
    public static void main(String[]args)
    {
        File f0 = new File("D:ANKAN.txt");
        if(f0.exists())
        {
            System.out.println("The name of this file: "+f0.getName());

            System.out.println("The absolute path of the file: "+f0.getAbsolutePath());

            System.out.println("Is file  writable: "+f0.canWrite());

            System.out.println("Is file readable: "+f0.canWrite());

            System.out.println("The size of file in bytes is: "+f0.length());
        }
        else{
            System.out.println("The file does'nt exists");
        }
    }
}
