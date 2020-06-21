import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class XMLDE {

    public static ArrayList XMLDecoder(String filePath){
        ArrayList A = null;
        try{
            FileInputStream fis = new FileInputStream(filePath);
            XMLDecoder decoder = new XMLDecoder(fis);
            A = (ArrayList) decoder.readObject();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return A;
    }

    public static void XMLEncoder(String filePath, ArrayList List){
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static FileOutputStream XMLCreate(String filePath) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(filePath);
        return fos;
    }
}
