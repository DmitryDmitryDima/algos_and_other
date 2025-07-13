package language.words;


import java.io.*;

public class Transient {

    public static void main(String[] args) {

        final String path = "C:/Users/User/Desktop/filebase/file.bat";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            TestObject testObject = new TestObject("Dima", "student 27 years old");
            out.writeObject(testObject);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            TestObject testObject = (TestObject) in.readObject();
            System.out.println(testObject.getName()); // передано Dima
            System.out.println(testObject.getAdditionalInfo()); // null потому что поле transient

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}



class TestObject implements Serializable{



    @Serial
    private static  final long serialVersionUID = 1L;

    private String name;
    private transient String additionalInfo;



    public TestObject(){}

    public TestObject(String name, String additionalInfo){
        this.name = name;
        this.additionalInfo = additionalInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }


}
