package ru.stqa.a4.sandbox;

/**
 * Created by leonov_ai on 27.10.16.
 */
public class Point {
  public int x;
  public int y;

  public Point (int x, int y){
    this.x = x;
    this.y = y;
  }

  public double distance2 (Point p1, Point p2){

    double s1;
    double s2;

    s2 = (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    s1 = Math.sqrt(s2);

    return s1;
  }

  public double distance1 (Point p2){
    double s = (p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y);
    return Math.sqrt(s);
  }

}
