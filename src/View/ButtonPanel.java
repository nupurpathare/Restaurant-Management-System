package View;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel  extends JPanel {
    JButton btn_restaurant = new JButton();
    JButton btn_dish = new JButton();

    JButton btn_createap = new JButton();

    JButton btn_createal = new JButton();
    JButton btn_editap = new JButton();
    JButton btn_edital = new JButton();
    JButton btn_delap = new JButton();
    JButton btn_delal = new JButton();

    public ButtonPanel(){
        btn_restaurant.setBackground(Color.cyan);
        btn_restaurant.setPreferredSize(new Dimension(80,25));
        btn_restaurant.setText("Restaurants");
        this.add(btn_restaurant);
        validate();
        repaint();
        btn_dish.setBackground(Color.cyan);
        btn_dish.setPreferredSize(new Dimension(80,25));
        btn_dish.setText("Dishes");
        this.add(btn_dish);
        validate();
        repaint();

        btn_createap.setBackground(Color.cyan);
        btn_createap.setPreferredSize(new Dimension(120,25));
        btn_createap.setText("Create Restaurant");
        this.add(btn_createap);
        validate();
        repaint();
        btn_createal.setBackground(Color.cyan);
        btn_createal.setPreferredSize(new Dimension(120,25));
        btn_createal.setText("Create Dish");
        this.add(btn_createal);
        validate();
        repaint();
        btn_editap.setBackground(Color.cyan);
        btn_editap.setPreferredSize(new Dimension(120,25));
        btn_editap.setText("Update Restaurant");
        this.add(btn_editap);
        validate();
        repaint();
        btn_edital.setBackground(Color.cyan);
        btn_edital.setPreferredSize(new Dimension(120,25));
        btn_edital.setText("Update Dish");
        this.add(btn_edital);
        validate();
        repaint();
        btn_delap.setBackground(Color.cyan);
        btn_delap.setPreferredSize(new Dimension(120,25));
        btn_delap.setText("Delete Restaurant");
        this.add(btn_delap);
        validate();
        repaint();
        btn_delal.setBackground(Color.cyan);
        btn_delal.setPreferredSize(new Dimension(120,25));
        btn_delal.setText("Delete Dish");
        this.add(btn_delal);
        validate();
        repaint();

    }

    public JButton getBtn_restaurant() {
        return btn_restaurant;
    }

    public JButton getBtn_dish() {
        return btn_dish;
    }
    public JButton getBtn_createap() {
        return btn_createap;
    }
    public JButton getBtn_createal(){
        return  btn_createal;
    }

    public JButton getBtn_editap() {
        return btn_editap;
    }
    public JButton getBtn_edital() {
        return btn_edital;
    }
    public JButton getBtn_delap() {
        return btn_delap;
    }
    public JButton getBtn_delal() {
        return btn_delal;
    }
}
