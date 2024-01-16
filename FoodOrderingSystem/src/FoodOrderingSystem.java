import java.util.InputMismatchException;
import java.util.Scanner; 

public class FoodOrderingSystem {
    
    public static void main(String[] args) {
        //Declare variables
        int choice = 0, choice2 = 0, count = 0, SIZE = 7;
        String name;
        double total;
        boolean success;
        
        try (//Declare new Scanner
        Scanner input = new Scanner(System.in)) {
            //Create new 2 arrays
            Food f[] = new Food[SIZE];
            Food order[] = new Food[SIZE];
            
            //Assign new objects into arrays
            f[0] = new Food(1, 15.00, "Pizza");
            f[1] = new Food(2, 10.10, "Burger");
            f[2] = new Food(3, 11.50, "Spaghetti");
            f[3] = new Food(4, 9.55, "Ravioli");
            f[4] = new Food(5, 5.15, "Baguette");
            f[5] = new Food(6, 10.20, "Mac & Cheese");
            f[6] = new Food(7, 12.30, "Lasagna");
            
            //Display title and ask the user to enter the name
            System.out.println("---Welcome to COV Italian Food---");
            
            System.out.println("Enter your name: ");
            name = input.nextLine();
            System.out.println("\nHello " + name + ".");

            System.out.println("\nWhat would you like to order?");
            
            
            do{
                //Display menu and list of foods
                success = false;
                System.out.println("\n--------------Menu--------------");
                for (int i=0; i<SIZE; i++){
                  f[i].display();
                }
                //Ask the user to enter the choice of food
                while(!success){
                    try{
                        System.out.println("\nEnter your Choice (1-7): ");
                        choice = input.nextInt();
                        
                        //Display error message and ask the user to enter again
                        if (choice>SIZE || choice<0){
                            System.out.println("Invalid number. Try again.");
                            success=false;
                        }
                        else success = true;
                    }
                    //Display error message
                    catch(InputMismatchException e){
                        input.next();
                        System.out.println("Invalid input. Try again.");
                    }
                }
                
                //Display the user's food has been added
                System.out.println("\n" + f[choice-1].getName() + " has been added to your order");
                order[count] = f[choice-1];
                count++;
                
                
                do{
                    success = false;
                    total = 0;
                    
                    //Display the user's orders and the total of the order
                    System.out.println("\n-----------Your Order-----------");
                    for (int i=0; i<count; i++){
                        System.out.println("RM" + order[i].getPrice() + "             " + order[i].getName());
                        total += order[i].getPrice();
                    }
                    System.out.println("RM" + total +  "             TOTAL");
                    System.out.println("\n--------------------------------\n");
    
                    //Ask the user to enter the choice
                    System.out.println("1) Add order");
                    System.out.println("2) Remove previous order");
                    System.out.println("3) Proceed to payment");
                    
                    while(!success){
                        try{
                            System.out.println("\nEnter your Choice (1-3): ");
                            choice2 = input.nextInt();
                            
                            //Display error message and ask the user to enter again
                            if(choice2>3 || choice2<1){
                                System.out.println("Invalid number. Try again.");
                                success=false;
                            }
                            else success=true;
                        }
                        //Display error message
                        catch(InputMismatchException e){
                            input.next();
                            System.out.println("Invalid input. Try again.");
                        }
                    }
                    
                    //If the user enter 2, the system will remove the previous order
                    if (choice2 == 2){
                        System.out.println("Your previous order has been removed.");
                        if (count>0)
                        count--;
                    }
                
                    //If the user enter 3, the system will display the ending and end the process
                    else if (choice2 == 3){
                        System.out.println("\nYour total bill is RM" + total);
                        System.out.println("Your order will be delivered soon.");
                        System.out.println("Thank you for ordering from COV Italian Food.");
                    }
                
                //If the user enter 2, it will reset to the user's order part
                }while (choice2 == 2);
                
            //If the user enter 1, it will reset to the menu part
            }while (choice2 == 1);
        }
    }
}
