package Model;

public class ModelRestaurant
{
    protected manageRestaurant manageRestaurantData = new manageRestaurant();

    public ModelRestaurant()
    {
        manageRestaurantData.setLinesBeingDisplayed(100);
        manageRestaurantData.setFirstLineToDisplay(0);
    }

    public manageRestaurant getManageRestaurantData()
    {
        return manageRestaurantData;
    }
}
