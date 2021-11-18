import java.io.*;

public class Serialization {

    public static String serialize(Hotel data, String fileName){
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public static Hotel deSerialize(String fileName) {
        Hotel f1 = null;
        try{
            FileInputStream filein = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(filein);
            f1 = (Hotel) in.readObject();
            in.close();
            filein.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }
        return f1;
    }


}
