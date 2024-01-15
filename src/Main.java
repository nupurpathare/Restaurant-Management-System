import Controller.Controller;
import Model.*;
import View.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        View view= new View();
        ModelRestaurant modelres = new ModelRestaurant();
        ModelDish modeldish = new ModelDish();
        Controller controllerres = new Controller(modelres,modeldish ,view);

    }
}
