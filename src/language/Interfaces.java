package language;

public class Interfaces {

    public static void main(String[] args) {
        HelloAble h = new HelloAble() {
        };

        h.hello();

        HelloAble h2 = new HelloAble() {
            @Override
            public void hello() {
                System.out.println("anon class specific implementation");
            }
        };

        h2.hello();
    }
}


interface HelloAble {


    static void stEx(){

    }

    private  void exPr(){

    }


    default void hello(){
        System.out.println("default implementation");

        exPr();
    }


}








