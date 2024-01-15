package Model;

public class ModelDish
{
    protected manageDish manageDishData = new manageDish();

    public ModelDish()
    {
        manageDishData.setLinesBeingDisplayed(100);
        manageDishData.setFirstLineToDisplay(0);
    }

    public manageDish getManageDishData()
    {
        return manageDishData;
    }
}

