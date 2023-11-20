import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\test");
        if (file.isDirectory()){
            for(File item : file.listFiles()){
                if (item.isDirectory()){
                    System.out.println(item.getName() + " is folder");
                }else{
                    System.out.println(item.getName() + " is file");
                }
            }
        }

        File newDir = new File("D:\\test\\temp");
        boolean c = newDir.mkdir();
        if (c){
            System.out.println("Folder is created");
        }

        File newNameDir = new File("D:\\test\\newDir");
        newDir.renameTo(newNameDir);
        boolean del = newNameDir.delete();
        if (del){
            System.out.println("Folder is deleted");
        }


    }
}