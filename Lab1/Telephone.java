class Telephone {
    private int areaCode;
    private int number;
    int numberOfTelephoneObject;

    public Telephone(int areaCode, int number){
        this.areaCode = areaCode;
        this.number = number;
    }

    static String makeFullNumber(){
        return (String) areaCode + (String) number;
    }
}


