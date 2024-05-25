
package com.mycompany.myproject;
import java.awt.event.*;
import javax.swing.*;
/************MAin****************************************/
public class MyProject
{
    public static void main(String[] args)
    {
        Framee a = new Framee();
    }
}
/*********shapes**************************************/
abstract class GeometricObject
{
    abstract double calculateArea();
    abstract double calculatePerimeter();
}
class Circle extends GeometricObject
{
    double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    double calculateArea()
    {
        return Math.PI * radius * radius;
    }

    double calculatePerimeter()
    {
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends GeometricObject
{
    double width;
    double height;
    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    double calculateArea()
    {
        return width * height;
    }

    double calculatePerimeter()
    {
        return 2 * (width + height);
    }
}

class Square extends Rectangle
{
    double side;

    public Square(double side)
    {
        super(side, side);
        this.side = side;
    }
}
/******************************************************************************/
class Framee extends JFrame
{
    /*************Layout Elements**************************************************/
    String[] shapes = {"Circle", "Rectangle", "Square"};
    JComboBox<String> shape= new JComboBox<>(shapes);;
    JTextField t1, t2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b1;
    /***********action function hide things when the selected shape is a thing******/
    void showLike(String selectedShape)
    {
        if ("Rectangle".equals(selectedShape))
        {
            l2.setText("Width:");
            l3.setText("Height:");
            l4.setText("");
        }
        else if ("Circle".equals(selectedShape))
        {
            l2.setText("Radius:");
            l3.setText("");
            l4.setText("");
            t2.setVisible(false);
        }
        else if ("Square".equals(selectedShape))
        {
            l2.setText("Side:");
            l3.setText("");
            l4.setText("");
            t2.setVisible(false);

        }
    }
    /****************************************************************************/
    void calculateAndDisplay()
    {
        String selectedShape = (String) shape.getSelectedItem();
        double resultArea = 0.0;
        double resultPerimeter = 0.0;

        try
        {
            double value1 = Double.parseDouble(t1.getText());

            if (value1 <= 0)
            {
                throw new IllegalArgumentException("Please enter a positive value.");
            }

            if (selectedShape.equals("Circle"))
            {
                Circle circle = new Circle(value1);
                resultArea = circle.calculateArea();
                resultPerimeter = circle.calculatePerimeter();
            }
            else if (selectedShape.equals("Square"))
            {
                Square square = new Square(value1);
                resultArea = square.calculateArea();
                resultPerimeter = square.calculatePerimeter();
            }
            else
            {
                double value2 = Double.parseDouble(t2.getText());

                if (value2 <= 0)
                {
                    throw new IllegalArgumentException("Please enter a positive value.");
                }

                Rectangle rectangle = new Rectangle(value1, value2);
                resultArea = rectangle.calculateArea();
                resultPerimeter = rectangle.calculatePerimeter();
            }

            l7.setText(" " + resultArea);
            l8.setText(" " + resultPerimeter);

        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);

        }
        catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /****************** restore the hided fields in the previous operation ********/
    void RestoreFields()
    {
        t1.setVisible(true);
        t2.setVisible(true);
    }
    /***************************************/
    void RestoreFieldsEmpty()
    {
        t1.setText("");
        t2.setText("");
    }
    /*********************************************/
    void RestoreResultsEmpty()
    {
        l7.setText("");
        l8.setText("");
    }
    /*************Layout setup*****************************************************/
    public Framee()
    {
        setSize(400, 500);
        setLocation(550, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setTitle("Area and Perimeter Calculator");
        l1 = new JLabel("Select Shape:");
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel("Area: ");
        l6 = new JLabel("Perimeter:");
        l7 = new JLabel();
        l8 = new JLabel();
        l1.setBounds(20, 10, 100, 20);
        shape.setBounds(120, 10, 90, 20);
        add(l1);
        add(shape);
        t1 = new JTextField();
        t2 = new JTextField();
        l2.setBounds(10, 50, 100, 25);
        t1.setBounds(60, 50, 120, 25);
        l3.setBounds(10, 90, 100, 25);
        t2.setBounds(60, 90, 120, 25);
        l4.setBounds(40, 130, 100, 25);
        b1 = new JButton("Calculate and Display");
        b1.setBounds(20, 170, 160, 30);
        l5.setBounds(20, 210, 100, 25);
        l6.setBounds(10, 250, 100, 25);
        l7.setBounds(50, 210, 200, 25);
        l8.setBounds(70, 250, 200, 25);
        add(b1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        setVisible(true);
        /*default ,, call the function for first time**************************************************/
        showLike("Circle");
        /*Action when select shape , put the shape name in the compbox**/
        shape.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedShape = (String) shape.getSelectedItem();
                RestoreFields();
                RestoreFieldsEmpty();
                RestoreResultsEmpty();
                showLike(selectedShape);
            }
        });
        /*****************************************The Button Action*******************/
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                calculateAndDisplay();
            }
        });
    }


}
