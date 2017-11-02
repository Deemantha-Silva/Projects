/**
Deemantha Silva
991455124
Assignment 2: The Shape
September 24, 2016
 */
package theshape;
import java.util.Scanner;       //scanner is imported from the Java library

public class TheShape {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);     //I let k be the designation for the scanner
        System.out.print("Please type in 1 for Triangle or any other integer for Rectangle: ");  //prompt to let user choose between triangle and rectangle
        int input = k.nextInt();  //user imput is stored here
                        
        if (input == 1){            //triangle is selected if input is only 1
        System.out.println("You have selected Triangle");
        System.out.print("Please enter the height of the triangle: "); //prompts user for height of triangle
        float tHeight = k.nextFloat(); //stores height of triangle (t for triangle; tHeight = triangle height) I used floats because double hold too many decimals without rounding
            if (tHeight < 0 || tHeight == 0) //we don't want negative values, but 0 is helpful either, so the statement is conditional based on negative or zero
                System.out.println("Incorrect, the height of a triangle cannot be negative!"); //if user imputs a negative, user is prompted of mistake and program stops
            else{
                System.out.print("Please enter the base of the triangle: "); //user is prompted with base question if they inputed a correct height earlier
                float tBase = k.nextFloat(); //base value is stored here (t again for triangle)
                        System.out.println((tBase <= 0) ? "Incorrect, the base of a triangle cannot be negative!" : "The area of the triangle is: " + (0.5 * tHeight * tBase));
                        // placed a conditioner operator here to allow either the result for incorrect user imput, or the actual answer
                        //I place the calculation for area within the println     
            }
        }
        else{ //user is given rectangle if they select any value other than 1
        System.out.println("You have selected rectangle");
        System.out.print("Please enter the length of the rectangle: "); //user is prompted for length of the rectangle
        float rLength = k.nextFloat(); //length of the rectangle is stored here (r for rectangle; rLength = rectangle Length)
            if (rLength < 0 || rLength == 0) //just like earlier, negative and zero values aren't useful here
                System.out.println("Incorrect, the length of a rectangle cannot be negative!");
            else{
                System.out.print("Please enter the width of the rectangle: ");
                float rWidth = k.nextFloat(); //width of the rectangle is stored here (r again for rectangle)
                    if (rWidth < 0 || rWidth == 0)
                        System.out.println("Incorrect, the width of a rectangle cannot be negative!");
                    else {
                        System.out.println("The area of the rectangle is " + (rLength * rWidth)); //calculation for area within println, using stored values for length and width
                        System.out.println("The perimeter of the rectangle is " + (2 * (rLength + rWidth))); //calculation for perimeter
                    }
            }        
        }                                
    }
    
}
