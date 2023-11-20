package p2;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File file = new File("D:\\test\\1qw.txt");
        System.out.println("File name " + file.getName());
        System.out.println("File's path " + file.getParent());
        File file1 = new File("1.txt");
        System.out.println("File name " + file1.getName());
        System.out.println("File's path " + file1.getParent());
        if (file.exists()){
            System.out.println("YES");
        }else{
            System.out.println("No");
            try {
                boolean create = file.createNewFile();
                if (create) {
                    System.out.println("File is created");
                    System.out.println("File size = " + file.length());
                    if (file.canWrite()){
                        System.out.println("We can write in file");
                    }else{
                        System.out.println("We can't");
                    }
                    if (file.canRead()){
                        System.out.println("We can read in file");
                    }else{
                        System.out.println("We can't");
                    }



                }
            }catch (IOException exception){
                System.out.println("ERROR");
                exception.printStackTrace();
            }
        }




    }
}
