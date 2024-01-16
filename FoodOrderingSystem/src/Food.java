public class Food {
    private int foodID;
    private double price;
    private String name;
    
    public Food(){}
    
    public Food(int id, double p, String na){
        foodID = id;
        price = p;
        name = na;
    }
    
    public void setFoodID(int id){
        foodID = id;
    }
    
    public void setPrice(double p){
        price = p;
    }
    
    public void setName(String na){
        name = na;
    }
    
    public int getFoodID(){
        return foodID;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }
    
    public void display(){
        System.out.println(foodID + ") " + "RM" + price + "          " + name);
    }
}
