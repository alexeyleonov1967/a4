package ru.stqa.a4.sandbox;

/**
 *
 */
public class MyFirstProgram {

    public static void main(String[] args) {


        Point pp1 = new Point(10, 20);
        Point pp2 = new Point(13, 24);

        System.out.println("Расстояние между точками :"+"("+pp1.x + ","+pp1.y + ")"+"и"+"("+pp2.x+","+pp2.y+")" + " = " + distance(pp1, pp2));


        Point pp3 = new Point(-10, -20);
        Point pp4 = new Point(-13, -24);

        System.out.println("Расстояние между точками :"+"("+pp3.x + ","+pp3.y + ")"+"и"+"("+pp4.x+","+pp4.y+")" + " = " + distance(pp3, pp4));


        Point pp5 = new Point(10, 20);
        Point pp6 = new Point(13, 24);

        System.out.println("Расстояние между точками :"+"("+pp5.x + ","+pp5.y + ")"+"и"+"("+pp6.x+","+pp6.y+")" + " = " + pp5.distance2(pp5, pp6));


        Point pp7 = new Point(-10, -20);
        Point pp8 = new Point(-13, -24);

        System.out.println("Расстояние между точками :"+"("+pp7.x + ","+pp7.y + ")"+"и"+"("+pp8.x+","+pp8.y+")" + " = " + pp7.distance2(pp7, pp8));


      Point pp9 = new Point(-10, -20);
      Point pp10 = new Point(-13, -24);

      System.out.println("Расстояние между точками :"+"("+pp9.x + ","+pp9.y + ")"+"и"+"("+pp10.x+","+pp10.y+")" + " = " + pp9.distance1(pp10));



    }


     public static double distance (Point p1, Point p2){

        double s1;
        double s2;

             s2 = (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
             s1 = Math.sqrt(s2);

        return s1;
    }

    }

