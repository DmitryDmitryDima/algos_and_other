package language.records;

public class RecordsPatternMatching {
    public static void main(String[] args) {

        Example e = new Example(1L,"info");
        test(e);

    }

    // стратегии pattern matching, применимые к records
    static void test(Object obj){
        // первый способ чтения данных из record
        if (obj instanceof Example ex){
            System.out.println(ex.id());
            System.out.println(ex.info());
        }

        // уникальный для record способ
        if (obj instanceof Example(Long someId, String someInfo)){
            System.out.println(someId);
            System.out.println(someInfo);
        }
    }



}

record Example(Long id, String info){}
