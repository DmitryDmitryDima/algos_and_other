package language.records;

public class Records {
    public static void main(String[] args) {
        // неканоничный
        Person p = new Person("Dima");

        // каноничный
        Person p2 = new Person("Marcus", 25);

        System.out.println(p.id()); // -1 as standart value



    }
}
