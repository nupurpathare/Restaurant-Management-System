package Controller;

import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Restaurant;
import Model.ModelDish;
import Model.ModelRestaurant;

import Model.manageRestaurant;
import View.View;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ModelRestaurant modelRestaurant;
    ModelDish modelDish;
    View view;
//    ArrayList<Restaurant> restaurant = new ArrayList<Restaurant>();
//    manageRestaurant mrp1 = new manageRestaurant();
//    ObjectMapper mapper = new ObjectMapper();
//    mrp1.readJsonFile("src/Model/restaurants.json");

    public Controller(ModelRestaurant mr, ModelDish md, View v) throws IOException {
        modelRestaurant = mr;
        modelDish = md;
        view = v;


        addButtonClickRes(mr);
        addButtonClickDish(md);
        addButtonClickCreateRes(mr);
        addButtonClickCreateDish(md);
        addButtonClickEditRes(mr);
        addButtonClickEditDish(md);
        addButtonClickDeleteRes(mr);
        addButtonClickDeleteDish(md);





    }

    private void addButtonClickRes(ModelRestaurant mr) {
        view.getMf().getIp().getBp().getBtn_restaurant().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                addScrollingRestaurant(mr);
                mr.getManageRestaurantData().setLinesBeingDisplayed(25);
                mr.getManageRestaurantData().setFirstLineToDisplay(0);
                System.out.println("Restaurant Pressed");
                view.centerInitialSetup(mr.getManageRestaurantData().getLinesBeingDisplayed(), mr.getManageRestaurantData().getRestaurantHeaders().size());
                view.centerUpdate(mr.getManageRestaurantData().getLines(mr.getManageRestaurantData().getFirstLineToDisplay(), mr.getManageRestaurantData().getLastLineToDisplay()), mr.getManageRestaurantData().getRestaurantHeaders());

            }

        });
    }


    private void addButtonClickDish(ModelDish md) {

        view.getMf().getIp().getBp().getBtn_dish().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                addScrollingDish(md);
                md.getManageDishData().setLinesBeingDisplayed(25);
                md.getManageDishData().setFirstLineToDisplay(0);
                System.out.println("Dish Pressed");
                view.centerInitialSetup(md.getManageDishData().getLinesBeingDisplayed(), md.getManageDishData().getDishHeaders().size());

                view.centerUpdate(md.getManageDishData().getLines(md.getManageDishData().getFirstLineToDisplay(), md.getManageDishData().getLastLineToDisplay()), md.getManageDishData().getDishHeaders());

            }
        });
    }

    private void addButtonClickCreateRes(ModelRestaurant mr) {
        view.getMf().getIp().getBp().getBtn_createap().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                System.out.println("Create Restaurant Pressed");

                //   Scanner scanner = new Scanner(System.in);

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Restaurant> restaurants;
                restaurants = mr.getManageRestaurantData().getTable();

                int restaurant_id = restaurants.size() + 1;
                Frame frame = new Frame("Restaurant Form");
                frame.setSize(400, 300);

                Label nameLabel = new Label("Restaurant Name:");
                TextField nameInput = new TextField(20);

                Label addressLabel = new Label("Address:");
                TextField addressInput = new TextField(20);

                Label contact_numberLabel = new Label("Contact Number:");
                TextField contact_numberInput = new TextField(20);

                Label emailLabel = new Label("Email:");
                TextField emailInput = new TextField(20);

                Label cuisine_typeLabel = new Label("Cuisine Type:");
                TextField cuisine_typeInput = new TextField(20);


                Button confirmButton = new Button("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String name = nameInput.getText();
                        String address = addressInput.getText();
                        long contact_number = Long.parseLong(contact_numberInput.getText());
                        String email = emailInput.getText();
                        String cuisine_type = cuisine_typeInput.getText();



                        // Create an Restaurant object with the input data
                        Restaurant res = new Restaurant(restaurant_id,name,address,contact_number,email,cuisine_type);
                        restaurants.add(res);
                        try {
                            mapper.writeValue(Paths.get("src\\Model\\restaurants.json").toFile(), restaurants);
                        } catch (IOException ea) {
                            System.out.println("Error is " + ea);
                        }



                        JOptionPane.showMessageDialog(null, "Restaurant created and added to the array with id " + restaurants.size());


                        frame.dispose();
                    }
                });

                frame.setLayout(new GridLayout(8, 2));
                frame.add(nameLabel);
                frame.add(nameInput);
                frame.add(addressLabel);
                frame.add(addressInput);
                frame.add(contact_numberLabel);
                frame.add(contact_numberInput);
                frame.add(emailLabel);
                frame.add(emailInput);
                frame.add(cuisine_typeLabel);
                frame.add(cuisine_typeInput);

                frame.add(confirmButton);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }
        });
    }

    private void addButtonClickCreateDish(ModelDish md) throws IOException {
        view.getMf().getIp().getBp().getBtn_createal().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                System.out.println("Create Dish Pressed");

                //   Scanner scanner = new Scanner(System.in);

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Dish> dishes;
                dishes = md.getManageDishData().getTable();



                int dish_id = dishes.size() + 1;
                Frame frame = new Frame("Dish Form");
                frame.setSize(400, 300);

                Label dish_name = new Label("Dish Name:");
                TextField dish_nameInput = new TextField(20);

                Label price = new Label("Price:");
                TextField priceInput = new TextField(20);

                Label dish_taste = new Label("Dish Taste");
                TextField dish_tasteInput = new TextField(20);


                Label cooking_method = new Label("Cooking Method");
                TextField cooking_methodInput = new TextField(20);

                Label ingredients = new Label("Ingredients");
                TextField ingredientsInput = new TextField(20);

                Button confirmButton = new Button("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String dish_name = dish_nameInput.getText();
                        String price = priceInput.getText();
                        String dish_taste = dish_tasteInput.getText();
                        String cooking_method = cooking_methodInput.getText();
                        String ingredients = ingredientsInput.getText();


                        // Create an Restaurant object with the input data
                        Dish dish = new Dish(dish_id,dish_name,price,dish_taste,cooking_method,ingredients);
                        dishes.add(dish);
                        try {
                            mapper.writeValue(Paths.get("src\\Model\\dishes.json").toFile(), dishes);
                        } catch (IOException ea) {
                            System.out.println("Error is " + ea);
                        }


                        JOptionPane.showMessageDialog(null, "Dish created and added to the array with id " + dishes.size());

                        frame.dispose();
                    }
                });

                frame.setLayout(new GridLayout(6, 2));
                frame.add(dish_name);
                frame.add(dish_nameInput);
                frame.add(price);
                frame.add(priceInput);
                frame.add(dish_taste);
                frame.add(dish_tasteInput);
                frame.add(cooking_method);
                frame.add(cooking_methodInput);
                frame.add(ingredients);
                frame.add(ingredientsInput);

                frame.add(confirmButton);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }
        });
    }

    private void addButtonClickEditRes(ModelRestaurant mr) throws IOException {
        view.getMf().getIp().getBp().getBtn_editap().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Restaurant Editor");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new FlowLayout());

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Restaurant> restaurant;
                restaurant = mr.getManageRestaurantData().getTable();

                JTextField idField = new JTextField(10);
                JButton editButton = new JButton("Edit Attribute");

                frame.add(new JLabel("Enter Restaurant Id to Update: "));
                frame.add(idField);
                frame.add(editButton);

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int ap_id = Integer.parseInt(idField.getText());
                        String a = JOptionPane.showInputDialog("What do you wish to edit\n1.Restaurant Name\n2.Address\n3.Contact Number\n4.Email\n5.Cuisine Type\n6.Website");
                        int choice = Integer.parseInt(a);
                        switch (choice) {
                            case 1:
                                String name = JOptionPane.showInputDialog("Enter new restaurant name:");
                                restaurant.get(ap_id - 1).setName(name);
                                break;
                            case 2:
                                String address = JOptionPane.showInputDialog("Enter new address:");
                                restaurant.get(ap_id - 1).setAddress(address);
                                break;
                            case 3:
                                String contact_number = JOptionPane.showInputDialog("Enter new contact number:");
                                restaurant.get(ap_id - 1).setContactNumber(Long.parseLong(contact_number));
                                break;
                            case 4:
                                String email = JOptionPane.showInputDialog("Enter new email:");
                                restaurant.get(ap_id - 1).setEmail(email);
                                break;
                            case 5:
                                String cuisine_type = JOptionPane.showInputDialog("Enter new cuisine type:");
                                restaurant.get(ap_id - 1).setCuisineType(cuisine_type);
                                break;
                            case 6:
                                String website = JOptionPane.showInputDialog("Enter new website:");
                                restaurant.get(ap_id - 1).setCuisineType(website);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Sorry Invalid Choice");


                        }

                        try {
                            mapper.writeValue(Paths.get("src\\Model\\restaurants.json").toFile(), restaurant);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Restaurant data updated successfully.");
                        frame.dispose();
                    }
                });

                frame.setVisible(true);

            }
        });
    }

    private void addButtonClickEditDish(ModelDish md) throws IOException {
        view.getMf().getIp().getBp().getBtn_edital().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Dish Editor");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new FlowLayout());

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Dish> dishes;
                dishes = md.getManageDishData().getTable();

                JTextField idField = new JTextField(10);
                JButton editButton = new JButton("Edit Attribute");

                frame.add(new JLabel("Enter Dish Id to Update: "));
                frame.add(idField);
                frame.add(editButton);

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int al_id = Integer.parseInt(idField.getText());
                        String a = JOptionPane.showInputDialog("What do you wish to edit\n1.Dish Name\n2.Price\n3.Dish Taste\n4.Dish Rating\n5.Cooking Method\n6.Ingredients");
                        int choice = Integer.parseInt(a);
                        switch (choice) {
                            case 1:
                                String dish_name = JOptionPane.showInputDialog("Enter new dish name:");
                                dishes.get(al_id - 1).setDishName(dish_name);
                                break;
                            case 2:
                                String price = JOptionPane.showInputDialog("Enter new total price:");
                                dishes.get(al_id - 1).setPrice(price);
                                break;
                            case 3:
                                String dish_taste = JOptionPane.showInputDialog("Enter new dish taste:");
                                dishes.get(al_id - 1).setDishTaste(dish_taste);
                                break;
                            case 4:
                                String dish_rating = JOptionPane.showInputDialog("Enter new dish rating:");
                                dishes.get(al_id - 1).setDishRating(Double.parseDouble(dish_rating));
                                break;
                            case 5:
                                String cooking_method = JOptionPane.showInputDialog("Enter new cooking method:");
                                dishes.get(al_id - 1).setCookingMethod(cooking_method);
                                break;
                            case 6:
                                String ingredients = JOptionPane.showInputDialog("Enter new ingredients:");
                                dishes.get(al_id - 1).setIngredients(ingredients);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Sorry Invalid Choice");


                        }

                        try {
                            mapper.writeValue(Paths.get("src\\Model\\dishes.json").toFile(), dishes);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Dish data updated successfully.");
                        frame.dispose();
                    }
                });

                frame.setVisible(true);

            }

        });
    }

    private void addButtonClickDeleteRes(ModelRestaurant mr) throws IOException {
        view.getMf().getIp().getBp().getBtn_delap().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Delete Restaurant");
                frame.setSize(300, 150);
                frame.setLayout(new FlowLayout());

                JLabel idLabel = new JLabel("Enter Restaurant ID to Delete:");
                JTextField idInput = new JTextField(10);

                JButton deleteButton = new JButton("Delete");

                frame.add(idLabel);
                frame.add(idInput);
                frame.add(deleteButton);

                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int restaurantIdToDelete = Integer.parseInt(idInput.getText());

                            ArrayList<Restaurant> restaurants = mr.getManageRestaurantData().getTable();

                            if (restaurantIdToDelete >= 1 && restaurantIdToDelete <= restaurants.size()) {
                                String restaurantName = restaurants.get(restaurantIdToDelete - 1).getName();
                                restaurants.remove(restaurantIdToDelete - 1);

                                ObjectMapper mapper = new ObjectMapper();
                                try {
                                    mapper.writeValue(Paths.get("src\\Model\\restaurants.json").toFile(), restaurants);
                                    JOptionPane.showMessageDialog(frame, "Restaurant Deleted: " + restaurantName);
                                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid Restaurant ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                        }
                        frame.dispose();
                    }

                });

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }

        });
    }


    private void addButtonClickDeleteDish(ModelDish md) throws IOException {
        view.getMf().getIp().getBp().getBtn_delal().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Delete Dish");
                frame.setSize(300, 150);
                frame.setLayout(new FlowLayout());

                JLabel idLabel = new JLabel("Enter Dish ID to Delete:");
                JTextField idInput = new JTextField(10);

                JButton deleteButton = new JButton("Delete");

                frame.add(idLabel);
                frame.add(idInput);
                frame.add(deleteButton);

                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int dishIdToDelete = Integer.parseInt(idInput.getText());

                            ArrayList<Dish> dishes = md.getManageDishData().getTable();

                            if (dishIdToDelete >= 1 && dishIdToDelete <= dishes.size()) {
                                String dishName = dishes.get(dishIdToDelete - 1).getDishName();
                                dishes.remove(dishIdToDelete - 1);

                                ObjectMapper mapper = new ObjectMapper();
                                try {
                                    mapper.writeValue(Paths.get("src\\Model\\dishes.json").toFile(), dishes);
                                    JOptionPane.showMessageDialog(frame, "Dish Deleted: " + dishName);
                                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid Dish ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                        }
                        frame.dispose();
                    }
                });

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }

        });
    }

    private void addScrollingRestaurant(ModelRestaurant mr) {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = mr.getManageRestaurantData().getFirstLineToDisplay();
                int current_last_line = mr.getManageRestaurantData().getLastLineToDisplay();
                int no_of_players = mr.getManageRestaurantData().getTable().size();
                int no_of_display_lines = mr.getManageRestaurantData().getLinesBeingDisplayed();
                if (units <= 0 && current_first_line == 0) {
                    mr.getManageRestaurantData().setFirstLineToDisplay(0);
                } else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line <= 0) {
                        mr.getManageRestaurantData().setFirstLineToDisplay(0);
                    } else {
                        mr.getManageRestaurantData().setFirstLineToDisplay(new_first_line);
                    }
                } else if (units > 0 && current_last_line == no_of_players - 1) {
                    mr.getManageRestaurantData().setFirstLineToDisplay(current_first_line);
                } else if (units > 0 && current_last_line < no_of_players - 1) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line > no_of_players - no_of_display_lines) {
                        new_first_line = no_of_players - no_of_display_lines;
                        mr.getManageRestaurantData().setFirstLineToDisplay(new_first_line);
                    } else {
                        mr.getManageRestaurantData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(mr.getManageRestaurantData().getLines(mr.getManageRestaurantData().getFirstLineToDisplay(), mr.getManageRestaurantData().getLastLineToDisplay()), mr.getManageRestaurantData().getRestaurantHeaders());
            }
        });
    }

    private void addScrollingDish(ModelDish md) {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = md.getManageDishData().getFirstLineToDisplay();
                int current_last_line = md.getManageDishData().getLastLineToDisplay();
                int no_of_players = md.getManageDishData().getTable().size();
                int no_of_display_lines = md.getManageDishData().getLinesBeingDisplayed();
                if (units <= 0 && current_first_line == 0) {
                    md.getManageDishData().setFirstLineToDisplay(0);
                } else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line <= 0) {
                        md.getManageDishData().setFirstLineToDisplay(0);
                    } else {
                        md.getManageDishData().setFirstLineToDisplay(new_first_line);
                    }
                } else if (units > 0 && current_last_line == no_of_players - 1) {
                    md.getManageDishData().setFirstLineToDisplay(current_first_line);
                } else if (units > 0 && current_last_line < no_of_players - 1) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line > no_of_players - no_of_display_lines) {
                        new_first_line = no_of_players - no_of_display_lines;
                        md.getManageDishData().setFirstLineToDisplay(new_first_line);
                    } else {
                        md.getManageDishData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(md.getManageDishData().getLines(md.getManageDishData().getFirstLineToDisplay(), md.getManageDishData().getLastLineToDisplay()), md.getManageDishData().getDishHeaders());
            }
        });
    }


}