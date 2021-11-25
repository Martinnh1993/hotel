import java.io.*;

public class Serialization {


    public static void serialize(Hotel data, String fileName) {
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
    }

    public static Hotel deSerialize(String fileName) {
        Hotel f1 = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            f1 = (Hotel) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return f1;
    }

    public static void clearFile(String fileName) {
        try {
            new FileOutputStream(fileName).close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}