package PizzaOrder;
        import java.lang.reflect.Array;  //Used to get
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pizza Pizza1 = new Pizza();

        choosePizza(Pizza1);
        chooseSize(Pizza1);
        chooseTopping(Pizza1);
        printReceipt(Pizza1);
    }

    public static void choosePizza(Pizza Pizza1){

        String[] pizzaNames = {"Margheritha","Mozerilla","Hawaii","Peperoni","Napoli"
                                ,"Bolognese","Roma","Palermo","Meatlover","Jacob Special"};
        double[] pizzaPrices = {45,50,50,55,55,60,65,65,75,90};
        final int NUM_OF_PIZZAS_ON_MENU = 10;
        int chosenPizzaNumber = 0;

        System.out.println("Pizza Menu\n");

        for (int i = 0; i < NUM_OF_PIZZAS_ON_MENU ; i++) {                   // Prints out menu with prices
            System.out.printf("%-3d %-25s %.2f DKK \n",i+1,pizzaNames[i],pizzaPrices[i]);
        }

        System.out.println("\nInput number of pizza that you want to order: ");
        chosenPizzaNumber = inputValidator(1,NUM_OF_PIZZAS_ON_MENU); // Get input with inputValidator method

        Pizza1.setName(pizzaNames[chosenPizzaNumber-1]);
        Pizza1.setPrice(pizzaPrices[chosenPizzaNumber-1]);
    }

    public static void chooseSize(Pizza Pizza1){

        String[] sizes = {"Child","Standard","Family","Mega"};
        double[] priceMultipliers = {0.75,1,1.5,2};
        final int NUMBER_OF_SIZES = 4;
        double priceAfterSizeChoice = Pizza1.getPrice();
        int chosenSize = 0;

        System.out.println("Size menu\n");

        for (int i = 0; i < NUMBER_OF_SIZES ; i++) {     // Prints available sizes and corresponding prices
            System.out.printf("%-3d %-25s %5.2f DKK\n",i+1,sizes[i],priceAfterSizeChoice*priceMultipliers[i]);
        }

        System.out.println("\nInput number of size that you want to order: ");

        chosenSize = inputValidator(1,NUMBER_OF_SIZES);  // Get input with inputValidator method

        Pizza1.setSize(sizes[chosenSize-1]);
        Pizza1.setPrice(priceAfterSizeChoice*priceMultipliers[chosenSize-1]);

    }

    public static void chooseTopping(Pizza Pizza1){

        String[] toppingNames = {"Bacon","Onion","Olives","Dressing","Peperoni",
                                "Mozzarella","Mushroom","Sausage","Ham","Pineapple"};
        double[] toppingPrices = {10,5,6,5,6,5,5,8,7,9};
        final int NUMBER_OF_AVAILABLE_TOPPINGS = 10;
        int numOfToppingsWanted = 0;
        int chosenToppingNumber = 0;
        String[] chosenToppingNames = new String[10];
        double[] chosenToppingPrices = new double[10];
        double totalToppingPrice = 0;

        System.out.println("Topping Menu\n");

        for (int i = 0; i < NUMBER_OF_AVAILABLE_TOPPINGS ; i++) {  // Prints available toppings and price
            System.out.printf("%-3d %-25s %.2f DKK\n",i+1,toppingNames[i],toppingPrices[i]);
        }

        System.out.println("\nHow many toppings do you want? (Max 10)");
        numOfToppingsWanted = inputValidator(0,10);

        System.out.println("Enter wanted topping number: ");

        for (int i = 0; i < numOfToppingsWanted ; i++) { //Getting all toppings from user
            System.out.printf("Topping %d: ",i+1);
            chosenToppingNumber = inputValidator(0,NUMBER_OF_AVAILABLE_TOPPINGS);
            chosenToppingNames[i] = toppingNames[chosenToppingNumber-1];
            chosenToppingPrices[i] = toppingPrices[chosenToppingNumber-1];
            totalToppingPrice += toppingPrices[chosenToppingNumber-1];
        }
        Pizza1.setToppingNames(chosenToppingNames);
        Pizza1.setToppingPrices(chosenToppingPrices);
        Pizza1.setToppingTotalPrice(totalToppingPrice);
        Pizza1.setNumberOfToppings(numOfToppingsWanted);

    }

    public static void printReceipt(Pizza Pizza1){

        System.out.println("\nReceipt\n");
        System.out.printf("%-15s size: %-15s %.2f DKK\n",Pizza1.getName(),Pizza1.getSize(),Pizza1.getPrice());
        System.out.println("Toppings:");

        for (int i = 0; i < Pizza1.getNumberOfToppings(); i++) {   //Prints all chosen toppings and prices
            System.out.printf("- %-36s %.2f DKK\n", (String)Array.get(Pizza1.getToppingNames(),i)
                                                  , (double)Array.get(Pizza1.getToppingPrices(),i));
        }

        System.out.printf("\n%-37s %.2f DKK","Total price: ",Pizza1.getToppingTotalPrice()+Pizza1.getPrice());

    }

    public static int inputValidator(int lowerLimit,int upperLimit){

        Scanner in = new Scanner(System.in);
        int input = 0;

        do{
            if(in.hasNextInt()){                                 // Make sure input is of type int
                input = in.nextInt();

                if(input<lowerLimit || input>upperLimit){        //Check that int is within given boundaries
                    System.out.println("Error! Try again: ");
                }
            }
            else{
                System.out.println("Error! Try again: ");
                in.next();                                        // Reset input stream if failed to input int
            }
        }
        while(input < lowerLimit || input > upperLimit);          // Exit loop when acceptable input is received

        return input;                                             // Return input to method caller
    }
}
