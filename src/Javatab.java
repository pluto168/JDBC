public class Javatab {
    private int javatabId;
    private String javatabName;
    private int price;

    public Javatab(int javatabId, String javatabName, int price){
        this.javatabId = javatabId;
        this.javatabName = javatabName;
        this.price =  price;
    }

    @Override
    public String toString(){
        return "id: " + javatabId + ", name: " +javatabName + ",price: " + price;

    }
}
