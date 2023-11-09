
import java.sql.SQLOutput;
import java.util.Scanner;

public class ShoppingCartManager {
    //get customer's name and today's date and create an object of ShoppingCart for that user.
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String customerName;
        String todaysDate;

        System.out.println("Enter Customer's Name:");
        customerName = scnr.nextLine();

        System.out.println("Enter Today's Date:");
        todaysDate = scnr.nextLine();
        System.out.println();

        ShoppingCart userCart = new ShoppingCart(customerName,todaysDate);
        System.out.println("Customer Name: " + userCart.getCustomerName());
        System.out.println("Today's Date: " + userCart.getDate());
        System.out.println();

        printMenu(userCart, scnr);

        System.exit(0);

    }
    //creates a method to print a menu and receives user input. It then applies that input to the choice and performs the related action.
    public static void printMenu(ShoppingCart shoppingCart, Scanner scnr){

        char userChoice = ' ';
        boolean done = false;
        String clrScnr;

        String menu = ("MENU"
                + "\na - Add item to cart"
                + "\nd - Remove item from cart"
                + "\nc - Change item quantity"
                + "\ni - Output items' descriptions"
                + "\no - Output shopping cart"
                + "\nq - Quit\n");
        System.out.println(menu);

        do{
            System.out.print("Choose an option:");
            userChoice = scnr.next().charAt(0);



            switch (userChoice) {
                //changes boolean done to true to end the loop
                case ('q'): System.out.println();
                    done = true;
                    break;

                //prints out the current shopping cart with help from shoppingCart methods
                case ('o'): System.out.println("OUTPUT SHOPPING CART");
                    System.out.println(shoppingCart.getCustomerName() + "'s Shopping Cart - " + shoppingCart.getDate());
                    if(shoppingCart.getNumItemsInCart() == 0){
                        System.out.println("Number of Items: " + shoppingCart.getNumItemsInCart()+"\n");
                        System.out.println("SHOPPING CART IS EMPTY" );
                    }
                    else{
                        System.out.println("Number of Items: " + shoppingCart.getNumItemsInCart());

                    }
                    shoppingCart.printTotal();
                    System.out.println("Total: $" + shoppingCart.getCostOfCart()+"\n");
                    System.out.println(menu);
                    break;
                //prints out item descriptions from cart using shoppingCart methods
                case ('i'): System.out.println(" OUTPUT ITEMS' DESCRIPTIONS");
                    System.out.println(shoppingCart.getCustomerName() + "'s Shopping Cart - " + shoppingCart.getDate()+ " ");
                    shoppingCart.printDescriptions();
                    System.out.print(menu);
                    break;
                //creates an object of itemToPurchase and adds that to shoppingCart from user input.
                case ('a'): clrScnr = scnr.nextLine();
                    ItemToPurchase newItem = new ItemToPurchase();
                    System.out.println("ADD ITEM TO CART");
                    System.out.println("Enter the item name:");
                    newItem.setName(scnr.nextLine());
                    System.out.println("Enter the item description:");
                    newItem.setDescription(scnr.nextLine());
                    System.out.println("Enter the item price:");
                    newItem.setPrice(scnr.nextInt());
                    System.out.println("Enter the item quantity:\n");
                    newItem.setQuantity(scnr.nextInt());
                    shoppingCart.addItem(newItem);
                    System.out.println(menu);
                    break;
                //removes an item from the shopping cart using shoppingCart method
                case ('d'): clrScnr = scnr.nextLine();
                    System.out.println(" REMOVE ITEM FROM CART");
                    System.out.println("Enter name of item to remove:");
                    shoppingCart.removeItem(scnr.nextLine());
                    System.out.print(" " + menu);
                    break;
                //allows user to modify the amount of a certain item in shoppingcart
                case ('c'): clrScnr = scnr.nextLine();
                    System.out.println(" CHANGE ITEM QUANTITY");
                    ItemToPurchase changeItem = new ItemToPurchase();
                    System.out.println("Enter the item name: ");
                    changeItem.setName(scnr.nextLine());
                    System.out.println("Enter the new quantity: ");
                    changeItem.setQuantity(scnr.nextInt());
                    shoppingCart.modifyItem(changeItem);
                    System.out.print(menu);
                    break;

                default:
                    break;


            }
        }while(!done);

    }

}