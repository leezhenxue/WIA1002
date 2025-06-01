package Lab2_Generic.Q1;

public class MyGeneric<T> {
    private T e;

    public MyGeneric() {}
    
    public MyGeneric(T e) {
        this.e = e;
    }

    public void setObj(T e) {
        this.e = e;
    }

    public T getObj() {
        return this.e;
    }
}
