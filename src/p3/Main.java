package p3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        String fileName = "1.txt";

        try(ZipOutputStream stream = new ZipOutputStream(new FileOutputStream("1.zip"));
            FileInputStream fileInputStream = new FileInputStream(fileName);
        ){
            ZipEntry entry = new ZipEntry(fileName);
            stream.putNextEntry(entry);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            stream.write(bytes);
            stream.closeEntry();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("1.zip"))){
            ZipEntry entry;
            String name;
            while ((entry = zipInputStream.getNextEntry())!=null){
                name = entry.getName();
                System.out.printf("File name: %s \n", name);

                FileOutputStream fileOutputStream = new FileOutputStream("new"+name);
                for (int c = zipInputStream.read(); c!=-1; c = zipInputStream.read()){
                    fileOutputStream.write(c);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
