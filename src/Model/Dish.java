package Model;

public class Dish extends Fooditem{

    public Dish(int id, String dish_name, String price, String dish_taste, String cooking_method, String ingredients) {
        super(id,dish_name,price);
        setDishTaste(dish_taste);
        setDishRating(dish_rating);
        setIngredients(ingredients);
        setCookingMethod(cooking_method);
    }
    /* Dish attributes */

    private String dish_taste;
    private double dish_rating;
    private String cooking_method;
    private String ingredients;


    public void setDishTaste(String dish_taste)
    {
        this.dish_taste = dish_taste;
    }
    public void setDishRating(double dish_rating)
    {
        this.dish_rating = Dish.this.dish_rating;
    }
    public void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }
    public void setCookingMethod(String cooking_method)
    {
        this.cooking_method = cooking_method;
    }


    public String getDishTaste()
    {
        return this.dish_taste;
    }
    public double getDishRating()
    {
        return this.dish_rating;
    }
    public String getIngredients()
    {
        return this.ingredients;
    }
    public String getCookingMethod()
    {
        return this.cooking_method;
    }

    public static void review(double price, double dish_rating){


        if(dish_rating>3){
            System.out.println("Dish of rating" + dish_rating + " priced at Rs." + price + " has received great customer reviews!");
        }
        else{
            System.out.println("Dish of rating" + dish_rating + " priced at Rs." + price + " has received mixed customer reviews.");
        }

    }


    public static void review(double price){
        System.out.println("For the dish priced at Rs." + price + ", it's a good value for money!");

    }


    public String recommendDish() {
        if (dish_rating >= 4.5 && dish_taste.equals("Delicious")) {
            System.out.println("We highly recommend trying this amazing dish!");
        } else {
            System.out.println("Give this dish a try, it might surprise you!");
        }
        return null;
    }

    public String displayDish()
    {
        return display() +" ,Dish Taste :"+this.getDishTaste()+" ,Dish Rating :"+this.getDishRating()+" ,Ingredients :"+this.getIngredients()+" ,Cooking Method :"+this.getCookingMethod();
    }


}


