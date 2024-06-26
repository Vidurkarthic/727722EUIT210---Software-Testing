// You are using Java
import java.util.*;
class Item
{
    String name;
    double price;
    Item(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
    
}
class Cart
{
    private List<Item> items;
    public Cart()
    {
        items = new ArrayList<>();
    }
    public void addItem(Item i)
    {
        items.add(i);
    }
    public void removeItem(String s)
    {
        for(int i=0 ; i<items.size() ; i++)
        {
            if(items.get(i).name.equals(s))
            {
                items.remove(i);
            }
        }
    }
    public double calculateTotalPrice()
    {
        double tot = 0.0;
        for(int i=0 ; i<items.size() ; i++)
        {
            tot += items.get(i).price;
        }
        return tot;
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Cart c = new Cart();
        for(int i=0 ; i<n ; i++)
        {
            String name = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            Item it = new Item(name, price);
            c.addItem(it);
        }
        int k = sc.nextInt();
        sc.nextLine();
        for(int i=0 ; i<k ; i++)
        {
            String name = sc.nextLine();
            c.removeItem(name);
        }
        double tot = c.calculateTotalPrice();
        System.out.println("Total Price after removing items: $"+tot);
    }
}