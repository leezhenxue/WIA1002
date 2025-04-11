package Lab2.Q1;

public class testProgram {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();

        strObj.setObj("String object");
        intObj.setObj(12);

        System.out.println(strObj.getObj());
        System.out.println(intObj.getObj());
    }
}
