package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageRestaurant extends fileHandlingRestaurant implements Displayable{
    ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    /*public ArrayList<Restaurant> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }*/
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageRestaurant(){
        readJsonFile("C:\\Users\\LENOVO\\Desktop\\2nd sem\\restaurants\\java final project\\src\\Model\\restaurants.json");
    }
    public ArrayList<Restaurant> readJsonFile(String file_path) {
        ObjectMapper objectMappers = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMappers.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String name = node.get("name").asText();
                    String address = node.get("address").asText();
                    long contact_number = node.get("contact_number").asLong();
                    String email = node.get("email").asText();
                    String cuisine_type = node.get("cuisine_type").asText();
                    String website = node.get("website").asText();
                    Restaurant res = new Restaurant(id,name,address,contact_number,email,cuisine_type);
                    restaurants.add(res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return restaurants;
    }

    @Override
    public void writeJsonFile(ArrayList<Restaurant> restaurants) {
        ObjectMapper objs = new ObjectMapper();
        try {

            for (int i = 0; i < restaurants.size(); i++)
            {
                // Converting the Java object into a JSON string
                String res_str = objs.writeValueAsString(restaurants.get(i));
                // Displaying Java object into a JSON string
                System.out.println(res_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getRestaurantHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Address");
        headers.add("ContactNumber");
        headers.add("Email");
        headers.add("CuisineType");


        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the restaurants list and then extracts the various attributes of the restaurant such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> restaurant_details = new ArrayList<String>();

        restaurant_details.add(String.valueOf(restaurants.get(line).getId()));
        restaurant_details.add(restaurants.get(line).getName());
        restaurant_details.add(restaurants.get(line).getAddress());
        restaurant_details.add(String.valueOf(restaurants.get(line).getContactNumber()));
        restaurant_details.add(String.valueOf(restaurants.get(line).getEmail()));
        restaurant_details.add(restaurants.get(line).getCuisineType());


        return restaurant_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> restaurants_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            restaurants_subset.add(getLine(i));
        }
        return restaurants_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return restaurants;
    }
}



