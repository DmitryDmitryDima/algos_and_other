package language.enumeration;

public class Enumeration {


    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.SINGLE;



    }


}



enum SingleTon{
    SINGLE("Forever alone");

    private String name;

    SingleTon(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
