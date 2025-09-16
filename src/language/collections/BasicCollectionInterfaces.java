package language.collections;

import java.util.*;

public class BasicCollectionInterfaces {


    public static void main(String[] args) {





    }

    private static void DequeDemo(){

        Deque<Integer> deque = new ArrayDeque<>();

        boolean result = deque.offerFirst(1); // true - предлагаем добавление в начало очереди

        deque.offerLast(2); // предлагаем добавление в конец очереди

        deque.push(3); // добавляем в начало очереди, Exception в случае ограничения размера очереди

        // [3,1,2]


        // обходим дек в обратном порядке
        Iterator<Integer> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()){
            System.out.println(descendingIterator.next());
        }


        Integer peekFirst = deque.peekFirst(); // 3 - получаем (не удаляем) элемент, стоящий во главе очереди, null - если пусто

        Integer peekLast = deque.peekLast(); // 2 - получаем (не удаляем) элемент, стоящий в конце очереди, null - если пусто


        Integer pollFirst = deque.pollFirst(); // 3 - получаем и удаляем элемент, стоящий во главе очереди, null - если пусто

        Integer pollLast = deque.pollLast(); // 2 - получаем и удаляем элемент, стоящий в конце очереди, null - если пусто

        Integer pop = deque.pop(); // 1 - получаем и удаляем элемент, выбрасывает Exception если очередь пуста


        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(1);
        deque.offerLast(4);

        boolean resultFirstOccurence = deque.removeFirstOccurrence(1); // true - удаляет первое появление элемента, идя с головы очереди

        deque.offerLast(1);

        deque.removeLastOccurrence(1); // удаляет последнее появления элемента в очереди (то есть самый крайний элемент идя с конца очереди)



        // [2,1,4]

    }


    private static void QueueDemo(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // 1 - возвращаем (не удаляя) верх очереди (элемент, что был добавлен раньше всех).
        Integer head = queue.element(); // ! - если очередь пуста, вылетит Exception

        // 1 - возвращаем, не удаляя, верх очереди (элемент, что был добавлен раньше всех)
        Integer peek = queue.peek(); // ! - если очередь пуста, вернется null

        // 1 - возвращаем, удаляя, верх очереди (элемент, чтобы был добавлен раньше всех)
        Integer polled = queue.poll(); // ! - если очередь пуста, вернется null

        // 2 - возвращаем, удаляя, верх очереди (элемент, чтобы был добавлен раньше всех)
        Integer removed = queue.remove(); // ! - если очередь пуста, вылетит Exception

        boolean offering = queue.offer(4); // попытка добавить элемент (предлагаем элемент)

    }


    private static void NavigableSetDemo(){

        NavigableSet<Integer> navigableSet = new TreeSet<>(List.of(5, 4, 3, 2, 1, 0)); // [0,1,2,3,4,5]

        // * - ceil - "потолок"
        Integer ceil = navigableSet.ceiling(-1); // 0 - возвращает первый элемент сета, равный или больший, чем аргумент

        // * - floor - "пол"
        Integer floor = navigableSet.floor(6); // 5 - возвращает первый элемент сета, равный или меньший, чем аргумент

        Integer higher = navigableSet.higher(0); // 1 - первый больший элемент
        Integer lower = navigableSet.lower(1); // 0 - первый меньший элемент

        Integer pollFirst = navigableSet.pollFirst(); // 0 - удаляем и возвращаем меньший элемент
        Integer pollLast = navigableSet.pollLast(); // 5 - удаляем и возвращаем больший элемент

        // пример прохода по сету в обратном порядке
        for (Integer i:navigableSet.descendingSet()){
            System.out.println(i);
        }

    }

    private static void SortedSetDemo(){
        SortedSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(1);
        set.add(7);
        System.out.println(set);// [1,5,7] - automatically sorted

        SortedSet<Integer> tailSet = set.tailSet(5); // set with elements >=5
        System.out.println(tailSet); // [5,7]

        SortedSet<Integer> headSet = set.headSet(7); // set with elements <7
        System.out.println(headSet); // [1,5]

        set.add(0);
        set.add(8);

        SortedSet<Integer> subSet = set.subSet(1,8);
        System.out.println(subSet); // [1,5,7]

        subSet.addFirst(5); // ERROR - UBSUPPORTED

    }

    private static void SetInterfaceDemo(){


        Set<Integer> set  = new HashSet<>();
        // методом add можно фиксировать успешность операции добавления в set
        boolean result = set.add(5); // true
        result = set.add(5); //false -> элемент уже присутствует




    }

    private static void SequencedSetInterfaceDemo(){
        SequencedSet<Integer> set = new LinkedHashSet<>();
        set.addFirst(5);
        set.addFirst(6);
        set.addFirst(5); // дубликат удаляется и вставляется новый элемент. тем самым сохраняя порядок
        System.out.println(set); // [5,6]

        SequencedSet<Integer> reversedSet = set.reversed();
        System.out.println(reversedSet); // [6,5]

    }


    private static void ListInterfaceDemo(){

        // демонстрация интерфейса List

        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(0,2,3,4,5,6));
        // вставка элемента в конкретную позицию
        list.add(1,1); // вставляем элемент Integer (1), при этом происходит смещение значений справа

        // вставка элементов в конкретную позицию. В данном примере мы вставляем в самый конец
        list.addAll(list.size(), List.of(7,8,9));

        // статический метод для копирования
        List<Integer> copied = List.copyOf(list);

        // поиск по индексу
        list.get(0); // 0

        // поиск индекса
        list.indexOf(2); // если объектов несколько, возвращает индекс первого появления
        list.lastIndexOf(3); // возвращает последний индекс

        // удобное создание иммутабельного списка
        List<Integer> immutable = List.of(1,2,3);

        // удаление по индексу с возвращением удаленного элемента
        Integer deleted = list.remove(list.size()-1);


        // заменяем все элементы на некоторое значение (-1)
        list.replaceAll(el->-1);

        // вставка элемента с заменой старого значения
        Integer oldValue = list.set(0, 1); // старое значение возвращается

        // сортировка списка с использованием Comparator
        list.sort(Integer::compare); // (v1,v2)->Integer.compare(v1,v2)

        // подлист - from start to end
        List<Integer> chunk = immutable.subList(0,2);



    }

    private static void SequencedCollectionDemo(){
        // Sequenced collection - since jdk 21
        SequencedCollection<Integer> sequencedCollection = new ArrayList<>();
        sequencedCollection.addAll(List.of(1,2,3,4,5));

        sequencedCollection.addFirst(0);
        sequencedCollection.addLast(6);

        sequencedCollection.getFirst(); // 0
        sequencedCollection.getLast(); // 6

        sequencedCollection.removeFirst();
        sequencedCollection.removeLast();

        System.out.println(sequencedCollection);
    }

    private static void CollectionInterfaceDemonstration(){
        // демонстрация самых базовых методов интерфейса Collection
        Collection<Entity> collection = new ArrayList<>();

        // простое добавление, true - если коллекция была изменена
        collection.add(new Entity(0));
        // удаляем все элементы
        collection.clear();
        // добавление элементов из другой коллекции, true - если коллекция была изменена
        collection.addAll(List.of(new Entity(1), new Entity(2)));

        // проверяем наличие элемента или элементов в коллекции
        Entity e = new Entity(5); Entity e1 = new Entity(6); collection.add(e); collection.add(e1);
        boolean containCheck = collection.contains(e); // true
        boolean containGroupCheck = collection.containsAll(List.of(e, new Entity(666))); // false

        // удаляем конкретный элемент, true - если успех
        boolean removingResult = collection.remove(e); // true
        boolean groupRemovingResult = collection.removeAll(List.of(e)); // false

        // удаляем только те элементы, что соответствуют условию
        collection.removeIf(element->element.id()<2);

        // оставляем только те элементы, что перечислены в аргументе
        collection.retainAll(List.of(e1));

        // переводим в array
        Entity[] result = collection.toArray(new Entity[0]);
        System.out.println(Arrays.toString(result));
    }
}


record Entity(Integer id){}
