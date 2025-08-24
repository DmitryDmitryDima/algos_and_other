package language.records;

public record Person(String name, Integer id) {

    static int standartId = -1;

    // каноничный конструктор
    public Person{
        name = name.toUpperCase();
    }

    // неканоничный конструктор с одним аргументом - он должен вызвать каноничный
    public Person(String name){
        this(name, standartId);
    }

    public String getName(){
        return name;
    }
}
