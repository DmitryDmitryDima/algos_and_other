package language.comparing;

import java.util.ArrayList;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<ComparableEntity> collection = new ArrayList<>();
        collection.add(new ComparableEntity("a")); collection.add(new ComparableEntity("b"));

        collection = collection.stream().sorted().toList();
        System.out.println(collection);

    }
}

// логика должна быть натуральной
record ComparableEntity(String name) implements Comparable<ComparableEntity>{

    @Override
    public int compareTo(ComparableEntity o) {
        if (this.name == null && o.name == null) return 0;
        if (this.name == null) return -1; // null меньше
        if (o.name == null) return 1;
        return this.name.compareTo(o.name());
    }
}
