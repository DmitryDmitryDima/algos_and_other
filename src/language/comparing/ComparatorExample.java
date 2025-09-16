package language.comparing;

import java.util.ArrayList;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        List<Entity> collection = new ArrayList<>();
        collection.add(new Entity("a"));
        collection.add(new Entity("b"));

        // reverse order - use comparator
        collection.sort((entity1, entity2)-> entity2.name().compareTo(entity1.name()));

        System.out.println(collection); // b, a


    }

}


record Entity(String name){}
