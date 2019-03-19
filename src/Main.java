import java.util.Scanner;

public class Main {
    private static final int ORDERSL = 2400;
    private static final int LOWSUPPLY = 8000;
    private static final int HIGHSUPPLY = 12000;

    public static void main(String[] args) {

        Stock mainStock = new Stock();

        System.out.println("Enter amount of SL-products");
        Scanner in = new Scanner(System.in);
        int inputStock = in.nextInt();
        mainStock.changeStock(inputStock);

        System.out.println("Outgoing amount of SL-products");
//        Scanner in = new Scanner(System.in);
        int inputOutgoingStock = in.nextInt();
        if (inputOutgoingStock > inputStock){
            int dif = (inputOutgoingStock - inputStock);
            System.out.println("Not enough stock!\nMax amount of orders of SL can be: " + inputStock + "\nRemaining amount of orders of SL pending: " + dif);
            mainStock.changeStock(-inputStock);
        } else {
            mainStock.changeStock(-inputOutgoingStock);
        }

        System.out.println("Incoming amount of products");
        int inputIncomingStock = in.nextInt();

        System.out.println("How many of the incoming products are SL?");
        int inputIncomingSLStock = in.nextInt();

        mainStock.changeStock(inputIncomingSLStock);

        if (mainStock.getStock() < LOWSUPPLY){
            System.out.println("Supply is to low: " + mainStock.getStock() + "\nOrder new supply from Berlin.");
            mainStock.changeStock(ORDERSL);
        } if (mainStock.getStock() > HIGHSUPPLY){
            int dif = (mainStock.getStock() - HIGHSUPPLY);
            System.out.println("Too much SL-stock!\nExcessive SL-products returned to Berlin: " + dif);
            mainStock.changeStock(-(mainStock.getStock() - HIGHSUPPLY));
        }
        System.out.println("Resume SL-stock after all alterations: " + mainStock.getStock());

        int inputIncomingRegularStock = (inputIncomingStock - inputIncomingSLStock);
        System.out.println("Amount of regular products incoming and being shipped to Berlin: " + inputIncomingRegularStock);
    }
}
