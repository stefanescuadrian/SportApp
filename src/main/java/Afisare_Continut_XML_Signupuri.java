import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Afisare_Continut_XML_Signupuri {
    private static ArrayList List = new ArrayList();
    public static ArrayList decodificareXML(){
    try{
        FileInputStream fis = new FileInputStream("./Signupuri.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        ArrayList A = new ArrayList();
        A = (ArrayList) decoder.readObject();
        List = A;

        for(int i=0; i < List.size(); i++){
            System.out.println(List.get(i).toString());
        }
    } catch (
    FileNotFoundException ex) {
        ex.printStackTrace();
    }
    return List;
}
    public static void main(String[]args){
        decodificareXML();
    }

}
