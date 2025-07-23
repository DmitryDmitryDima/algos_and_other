package language.generics;

public class SimpleWildCard<T extends Number>{

    public static void main(String[] args) {

        Double[] data1 = {1.0,2.0};
        Integer[] data2 = {1,2};

        SimpleWildCard<Double> simpleWildCard = new SimpleWildCard<>(data1);
        SimpleWildCard<Integer> simpleWildCard1 = new SimpleWildCard<>(data2);

        System.out.println(simpleWildCard1.compareAve(simpleWildCard));


    }

    private T[] data;

    public SimpleWildCard(T[] data){
        this.data = data;
    }

    public double getAve(){

        double sum = 0;

        for (Number x:data){
            sum+=x.doubleValue();
        }
        return sum/data.length;
    }

    // мы используем вайлдкард, чтобы посылать тип,
    // отличный от T в экземпляре, в котором вызывается данный метод
    public boolean compareAve(SimpleWildCard<?> part){
        return part.getAve()==getAve();
    }

}
