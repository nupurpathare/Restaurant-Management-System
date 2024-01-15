package Model;

import java.util.Scanner;

/**
 * Identification comments:
 *   Name: Nupur Pathare, Mrunal Mahajan
 *   Experiment No:4
 *   Experiment Title:Restaurants, Dishes and Customers
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Restaurant.java
 * @author:  Nupur Pathare, Mrunal Mahajan
 * /*  Overview: This class is created to store the attributes of Restaurant. It is a subclass of the class "Business" which inherits
some of the attributes from the Business class. And the class representing the "Business" object implements the interface named
"Table Member".
 *
 * Attribute comments:
 * id : Its Restaurant Id
 * Name :
 * DOB :
 *
 *
 */

public class Restaurant extends Business implements RestaurantDesc {

    /* Restaurant attributes */
    private String cuisine_type;
    private String website;
    private String ambience;

    public Restaurant(int restaurantId, String name, String address, long contact_number, String email, String cuisine_type, String website, String ambience) {
        super(restaurantId, name, address, contact_number, email);
        setCuisineType(cuisine_type);
        setWebsite(website);
        setAmbience(ambience);
        System.out.println("Do you want specific or all order websites?");
        Scanner sc = new Scanner(System.in);
        String isSpecific = sc.nextLine();
        if (isSpecific.equals("specific")) {
            System.out.println("Please enter the website to display.\n1.Own Website\n2.Swiggy\n3.Zomato\n");
            String displaywebsite = sc.nextLine();
            if (displaywebsite.equals("1")) {
                System.out.println("Website link is: " + "https://www." + name + ".com");
            } else if (displaywebsite.equals("2")) {
                System.out.println("Website link is: " + "https://www.swiggy.com/" + name + "/" + address);
            } else if (displaywebsite.equals("3")) {
                System.out.println("Website link is: " + "https://www.zomato.com/" + name);
            }
        } else if (isSpecific.equals("all")) {
            System.out.println("Own Website link is: " + "https://www." + name + ".com");
            System.out.println("Swiggy Website link is: " + "https://www.swiggy.com/" + name + "/" + address);
            System.out.println("Zomato Website link is: " + "https://www.zomato.com/" + name);
        } else {
            System.out.println("invalid");
        }
    }

    public Restaurant(int restaurantId, String name, String address, long contact_number, String email, String cuisine_type) {
        super(restaurantId, name, address, contact_number, email);
        setCuisineType(cuisine_type);
        setAmbience(ambience);
    }

    public void setCuisineType(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setAmbience(String ambience) {
        this.ambience = ambience;
    }


    public String getCuisineType() {
        return this.cuisine_type;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getAmbience() {
        return this.ambience;
    }


    public int PriceRange() {
        System.out.println("Enter the maximum amount of price range");
        Scanner scanner = new Scanner(System.in);
        int enteredPrice = scanner.nextInt();
        if (enteredPrice < 5000) {
            System.out.println("restaurant is within budget");
        } else if (enteredPrice < 10000) {
            System.out.println("restaurant's budget is mid-range ");
        } else {
            System.out.println("restaurant's budget is upscale ");
        }
        return 0;
    }

    // Method to set the Specialty
    public String Specialty() {
        System.out.println("enter the special dish of restaurant");
        Scanner scanner = new Scanner(System.in);
        String specialty = scanner.nextLine();
        System.out.println("Restaurant is known for dish-");
        return specialty;
    }

    // Method to set the Service Style
    public int ServiceStyle() {
        System.out.println("1.fine-dining\n 2.casual-dining\n 3.buffet-style\n 4.cafe-style");
        System.out.println("enter the ambience of the restaurant");
        Scanner scanner = new Scanner(System.in);
        int service_style = scanner.nextInt();
        switch (service_style) {
            case 1:
                System.out.println("fine-dining restaurant");
                break;
            case 2:
                System.out.println("casual-dining restaurant");
                break;
            case 3:
                System.out.println("buffet-style restaurant");
                break;
            case 4:
                System.out.println("cafe-style restaurant");
                break;

            default:
                System.out.println("ambience not chosen");
        }
        return 0;
    }


    // Method to set Accessibility
    public boolean Accessibility() {
        System.out.println("Enter if the restaurant has wheelchair access (true/false)");
        Scanner sc = new Scanner(System.in);
        boolean bn = sc.nextBoolean();
        if (bn == true) {
            System.out.println("restaurant has the facility of wheelchair Accessibility");
        } else if (bn == false) {
            System.out.println("restaurant does not have the facility of wheelchair Accessibility");
        }
        return bn;
    }

    public String displayRestaurant() {
        return display()+ ", Cuisine Type :" + this.getCuisineType() + " ,Website :" + this.getWebsite() + " ,Ambience :" + this.getAmbience();

    }
}

