public class Stock {
    private int size;

    public Stock(){
        this.size = 0;
    }

    public void setStock(int voorraad){
        size = voorraad;
    }

    public int getStock(){
        return size;
    }

    public int changeStock(int change){
        size = size + change;
        return size;
    }
}
