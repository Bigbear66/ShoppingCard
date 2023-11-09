import java.util.Scanner;

public class ShoppingCartPrinter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ItemToPurchase item1 = new ItemToPurchase();

        ItemToPurchase item2 = new ItemToPurchase();

        System.out.println("Item 1");

        System.out.println("Enter the item name:");

        String name1 = scan.nextLine();

        System.out.println("Enter the item price:");

        int price1 = scan.nextInt();

        System.out.println("Enter the item quantity:");
        System.out.print("\n");

        int quantity1 = scan.nextInt();

        item1.setName(name1);

        item1.setPrice(price1);

        item1.setQuantity(quantity1);

        scan.nextLine();

        System.out.println("Item 2");

        System.out.println("Enter the item name:");

        String name2 = scan.nextLine();

        System.out.println("Enter the item price:");

        int price2 = scan.nextInt();

        System.out.println("Enter the item quantity:");
        System.out.print("\n");

        int quantity2 = scan.nextInt();

        item2.setName(name2);

        item2.setPrice(price2);

        item2.setQuantity(quantity2);

        System.out.println("TOTAL COST");

        int item1Total = item1.getPrice() * item1.getQuantity();

        int item2Total = item2.getPrice() * item2.getQuantity();

        System.out.println(item1.getName()+" "+item1.getQuantity()+" @ $"+item1.getPrice()+" = $"+item1Total);

        System.out.println(item2.getName()+" "+item2.getQuantity()+" @ $"+item2.getPrice()+" = $"+item2Total);

        System.out.println();

        System.out.println("Total: $"+(item1Total + item2Total));

    }

}
