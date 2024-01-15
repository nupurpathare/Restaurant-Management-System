package Model;
import java.util.Calendar;
import java.util.Date;
public class Serves{
    private String timing;
    Restaurant ObjRes;
    Dish ObjDish;

    public void serve_res_dish_cust(Restaurant tempRes, Dish tempDish, double temp_time)
    {
        ObjRes = tempRes;
        ObjDish = tempDish;
        timing = String.valueOf(temp_time);
    }

    public void display_serves_restaurant_dish_customer(Restaurant restaurant, Dish dish, Serves serves)
    {
        System.out.println("Restaurant : "+this.ObjRes.getName()+" serves Dish : "+this.ObjDish.getDishName()+" during : "+this.timing);
    }
}



