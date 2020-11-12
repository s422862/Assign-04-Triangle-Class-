

import java.io.*;
import java.util.*;

public class Triangle {
 
  //private properties
  private double sideA;
  private double sideB;
  private double sideC;
 
  /**.
  * constructor (initializes properties)
  */
  public Triangle() {
   
    sideA = 0;
    sideB = 0;
    sideC = 0;
  }
 
  /**.
  * constructor (initializes sides to be specific sides)
  */
  public Triangle(double side1, double side2, double side3) {
   
    sideA = side1;
    sideB = side2;
    sideC = side3;
  }
 
  //methods
 
  /**.
  * getPerimeter
  */
  public double getPerimeter(double sideA, double sideB, double sideC) {
 
    double perimeter;
   
    //return the calculated perimeter
    return perimeter = (sideA + sideB + sideC);
  }
 
  /**.
  * getSemiPerimeter
  */
  public double getSemiperimeter(double sideA, double sideB, double sideC) {
   
    //initialize perimeter to the return value of getPerimeter
    double perimeter = getPerimeter(sideA, sideB, sideC);
   
    //return the calculated semi perimeter
    double semiPerimeter;
    return semiPerimeter = (perimeter / 2);
  }

  /**.
  * getArea
  */
  public double getArea(double sideA, double sideB, double sideC) {
   
    //initialize the varible semi to the return value of getSemiperimeter showing both side 
    double semi = getSemiperimeter(sideA, sideB, sideC);
   
    //return the calculated area
    double area;
    return area = (Math.sqrt(semi * (semi - sideA) * (semi - sideB) * (semi - sideC)));
  }
 
  /**.
  * getHeight
  */
  public double getHeight(double sideA, double sideB, double sideC) {
   
    //initialize the variable area to the return value of getArea
    double area = getArea(sideA, sideB, sideC);
   
    //return the calculated height
    double height;
    return height = ((2 * area) / sideB);
  }
 
  /**.
  * getType
  */
  public String getType(double sideA, double sideB, double sideC) {
   
    //create empty typeOfTriangle string
    String typeOfTriangle = "";
   
    //declare variables
    double longestSide = 0;
    double secondSide = 0;
    double thirdSide = 0;
   
    //if all the sides are the same, it's an equilateral triangle
    if ((sideA == sideB && sideB == sideC && sideA == sideC)) {
      typeOfTriangle = "Type of triangle: equilateral";
   
    //if not, the triangle is an isoceles triangle
    } else if ((sideA == sideB || sideB == sideC || sideA == sideC)) {
      typeOfTriangle = "Type of triangle: isoceles";
     
    //if it's not an isoceles, or equilateral, it's a scalene triangle
    } else {
      typeOfTriangle = "Type of triangle: scalene";
     
      //calculate the longest side of the triangle
      if (sideA > longestSide) {
        longestSide = sideA;
         
        if (sideB > longestSide) {
          longestSide = sideB;
         
          if (sideC > sideC) {
            longestSide = sideC;
          }
        }
      }
     
      //whatever side is the longest, assign the other sides to specific variables
      if (longestSide == sideA) {
        thirdSide = sideB;
        secondSide = sideC;
     
      } else if (longestSide == sideB) {
        thirdSide = sideA;
        secondSide = sideC;
     
      } else {
        thirdSide = sideA;
        secondSide = sideB;
      }
     
      //get the sides and square each of them
      double longestSquare = Math.pow(longestSide, 2);
      double thirdSquare = Math.pow(thirdSide, 2);
      double secondSquare = Math.pow(secondSide, 2);
   
      //if the triangle is a right angled triangle
      if ((longestSquare) == (thirdSquare) + (secondSquare)) {
        typeOfTriangle = "Type of triangle: right angle";
       
        //if the triangle is an acute triangle
      } else if ((longestSquare) < (thirdSquare) + (secondSquare)) {
        typeOfTriangle = "Type of triangle: acute";
       
        //if the triangle is an obtuse triangle
      } else if ((longestSquare) > (thirdSquare) + (secondSquare)) {
        typeOfTriangle = "Type of triangle: obtuse";
      }
    }
   
    //return what type of triangle it is
    return typeOfTriangle;
  }
 
  /**.
  * isTriangleValid
  */
  protected boolean isTriangleValid(double sideA, double sideB, double sideC) {
   
    //creates false boolean variable to be used to check if triangle is valid or not
    boolean triangleValidity = false;
   
    //conditions to check if the validity is true or not
    if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
      triangleValidity = false;

    } else {
      triangleValidity = true;
    }
    //return the outcome of the check (if triangle is valid or not)
    return triangleValidity;
  }
}