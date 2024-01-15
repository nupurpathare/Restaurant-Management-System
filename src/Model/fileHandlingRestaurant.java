package Model;

import java.util.ArrayList;

abstract class fileHandlingRestaurant {
    String restaurant_sponsor_email;
    abstract public ArrayList<Restaurant> readJsonFile(String file_path);

    abstract public void writeJsonFile(ArrayList<Restaurant> restaurants);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
