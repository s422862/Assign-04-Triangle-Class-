import java.io.*;
import java.util.*;

public class tri {
 
/**.
* main
* Create a program that asks the user for the 3 side lengths of a triangle. 
* The program will then display the area perimeter, area and type of triangle on the output file
* @author  John Omage
* @version 1.0
* @since   2020-11-2 
*/
  public static void main(String [] args) throws IOException {
   
    //create an empty triangle
    Triangle triangleA = new Triangle();
     
    //create the inputFile File, getting input from "input.txt"
    File inputFile = new File("./input.txt");
   
    //a scanner that reads the input file 
    Scanner scan = new Scanner(inputFile);
   
    //local variables
    String[] sidesArray = null;
    String sides = "";
   
    // initialize side variables to 0
    double sideA = 0;
    double sideB = 0;
    double sideC = 0;
   
    double userSide1 = 0;
    double userSide2 = 0;
    double userSide3 = 0;
   
    //create the triangle with the user sides
    Triangle triangleB = new Triangle(userSide1, userSide2, userSide3);
   
    // create empty output string
    String outputString = "";
   
    //scan the first line of the file and initialize it to sidesArray 
    while (scan.hasNextLine()) {
      sides = scan.nextLine();
      sidesArray = sides.split(" ");
     
      //double parse the sidesArray, and assign each value to a side
      sideA = Double.parseDouble(sidesArray[0]);
      sideB = Double.parseDouble(sidesArray[1]);
      sideC = Double.parseDouble(sidesArray[2]);
       
      //display the perimeter of the triangle in the output file
      outputString = outputString + "Perimeter of the triangle: "
        + triangleB.getPerimeter(sideA, sideB, sideC) + " units\n";
     
      //display the semiperimeter of the triangle in the output file put
      outputString = outputString + "Semiperimeter of the triangle: "
        + triangleB.getSemiperimeter(sideA, sideB, sideC) + " units\n";
     
      //display the height of the triangle in the output file
      outputString = outputString + "Height of the triangle: "
        + triangleB.getHeight(sideA, sideB, sideC) + " units\n";
     
      //display the area of the triangle in the output file 
      outputString = outputString + "Area of the triangle: "
        + triangleB.getArea(sideA, sideB, sideC) + " units\n";
     
      //display what type of triangle the input is, in the output file 
      outputString =  outputString + triangleB.getType(sideA, sideB, sideC) + "\n";
       
      //if the triangle is valid 
      if (triangleB.isTriangleValid(sideA, sideB, sideC) == true) {

        //display that the triangle is valid in the output file 
        outputString =  outputString + "Is triangle valid: yes\r\n";
        outputString = outputString + "\r\n";
       
        // if the triangle is not valid 
      } else if (triangleB.isTriangleValid(sideA, sideB, sideC) == false) {
       
        //display that the triangle is not valid in the output file
        outputString =  outputString + "Is triangle valid: no\r\n";
        outputString = outputString + "\r\n";
      }
    }
   
    // error checking try catch  
    try {
      //create the File so that the program can output to it
      File outputFile = new File("./output.txt");
     
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
      writer.write(outputString);
     
      writer.close();
     
    } catch (Exception e) {
      System.out.print("Error with file");
    }  
  }
}

