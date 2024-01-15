package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageDish extends fileHandlingDish implements Displayable{
    ArrayList<Dish> dishes = new ArrayList<Dish>();
    /*public ArrayList<Student> loadJsonFile(String file_path) {
            return readJsonFile(file_path);
        }*/
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageDish(){
        readJsonFile("C:\\Users\\LENOVO\\Desktop\\2nd sem\\restaurants\\java final project\\src\\Model\\dishes.json");
    }
    public ArrayList<Dish> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String dish_name = node.get("dish_name").asText();
                    String price = node.get("price").asText();
                    String dish_taste = node.get("dish_taste").asText();

                    String cooking_method = node.get("cooking_method").asText();
                    String ingredients = node.get("ingredients").asText();

                    Dish dish = new Dish(id,dish_name,price,dish_taste, cooking_method,ingredients);
                    dishes.add(dish);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dishes;
    }
    @Override
    public void writeJsonFile(ArrayList<Dish> dishes) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < dishes.size(); i++)
            {
                // Converting the Java object into a JSON string
                String dish_str = Obj.writeValueAsString(dishes.get(i));
                // Displaying Java object into a JSON string
                System.out.println(dish_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getDishHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("DishName");
        headers.add("Price");
        headers.add("DishTaste");
        headers.add("CookingMethod");
        headers.add("Ingredients");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> dish_details = new ArrayList<String>();

        dish_details.add(String.valueOf(dishes.get(line).getId()));
        dish_details.add(dishes.get(line).getDishName());
        dish_details.add(dishes.get(line).getPrice());
        dish_details.add(dishes.get(line).getDishTaste());
        dish_details.add(dishes.get(line).getCookingMethod());
        dish_details.add(dishes.get(line).getIngredients());

        return dish_details;
    }
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> dishes_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            dishes_subset.add(getLine(i));
        }
        return dishes_subset;
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
        return dishes;
    }
}
