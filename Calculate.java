import java.util.Scanner;

public class Calculate {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] sizeSmall = { "5", "5000", "S" };
    public static String[] sizeMedium = { "10", "8000", "M" };
    public static String[] sizeLarge = { "15", "12000", "L" };

    public static void main(String[] args) {

        int target = 0;

        System.out.print("Please input number (seat): ");
        target = scanner.nextInt();
        GetTheCheapest(target);
    }

    private static void GetTheCheapest(int numOfSeat) {
        if (numOfSeat <= 0) {
            System.out.print("Please enter a number above 0.");
            return;
        }

        // Get multiplier
        int small = (int) Math.ceil((double) numOfSeat / Integer.valueOf(sizeSmall[0]));
        int medium = (int) Math.ceil((double) numOfSeat / Integer.valueOf(sizeMedium[0]));
        int large = (int) Math.ceil((double) numOfSeat / Integer.valueOf(sizeLarge[0]));

        // add 1 to multiplier if not react the target numOfSeat
        if (small * Integer.valueOf(sizeSmall[0]) < numOfSeat)
            small++;
        if (medium * Integer.valueOf(sizeMedium[0]) < numOfSeat)
            medium++;
        if (large * Integer.valueOf(sizeLarge[0]) < numOfSeat)
            large++;

        // Get the total cost
        int costSmall = small * Integer.valueOf(sizeSmall[1]);
        int costMedium = medium * Integer.valueOf(sizeMedium[1]);
        int costLarge = large * Integer.valueOf(sizeLarge[1]);

        String cheapestSize = "";
        int multiplierCount = 0;
        int totalPrice = 0;

        // Check The Cheapest Price
        if (costSmall <= costMedium && costSmall <= costLarge) {
            cheapestSize = sizeSmall[2];
            multiplierCount = small;
            totalPrice = costSmall;
        } else if (costMedium <= costSmall && costMedium <= costLarge) {
            cheapestSize = sizeMedium[2];
            multiplierCount = medium;
            totalPrice = costMedium;
        } else {
            cheapestSize = sizeLarge[2];
            multiplierCount = large;
            totalPrice = costLarge;
        }

        // Display Result
        System.out.println(cheapestSize + " x " + multiplierCount);
        System.out.print("Total = Php " + totalPrice);

    }

}
