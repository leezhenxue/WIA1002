package Lab2.Q4;

public class Value<T extends Comparable<T>> implements Comparable<Value<T>>{
    private T value;

    @Override
    public int compareTo(Value<T> o){
        return this.value.compareTo(o.value);
    }

    public String minmax(Value<T>[] arr){
        Value<T> min = arr[0];
        Value<T> max = arr[0];

        for (Value<T> element : arr){
            if (element.compareTo(min) < 0) {
                min = element;
            }
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return "Min = " + min.value + "  Max = " + max.value;
    }

}
