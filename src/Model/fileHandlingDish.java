package Model;

import java.util.ArrayList;

abstract class fileHandlingDish
{


    abstract public ArrayList<Dish> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Dish> dishes);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}