package Model;

abstract public class Fooditem {
    /* Dish attributes */
    private int id;
    private String dish_name;
    private String price;

    public Fooditem(int id, String dish_name, String price) {
        setId(id);
        setDishName(dish_name);
                setPrice(price);


    }

    public void setId(int id) {
        this.id = id;
        }
    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return this.id;
        }
    public String getDishName() {
        return this.dish_name;
    }

    public String getPrice() {
        return this.price;
    }

    final public String display()
    {
        return ("id : "+getId()+ " Dish Name : "+getDishName()+ " Price  : "+getPrice());
    }
}
