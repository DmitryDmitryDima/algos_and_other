package language.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {


        // сделать так, чтобы компаратор считал null самым меньшим значением
        // (Entity e1, Entity e2)->e1.name().compareTo(e2.name()) то же самое что Comparator.comparing(Entity::name)
        Comparator<Entity> comparatorNullFirst = Comparator.nullsFirst(Comparator.comparing(Entity::name));

        // сделать так, чобы компаратор считал null самым большим значением
        Comparator<Entity> comparatorNullLast = Comparator.nullsLast(Comparator.comparing(Entity::name));

        // компаратор, проводящий второе сравнение в случае, если первое дало "равно"
        Comparator<Entity> comparatorChained = Comparator.comparing(Entity::name).thenComparing(Entity::id);



        List<Entity> collection = new ArrayList<>();
        collection.add(new Entity("a", 10));
        collection.add(new Entity("b",11));

        // reverse order - use comparator
        collection.sort((entity1, entity2)-> entity2.name().compareTo(entity1.name()));

        System.out.println(collection); // b, a


    }

}


record Entity(String name, Integer id){}
