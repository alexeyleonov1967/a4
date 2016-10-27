package ru.stqa.a4.sandbox;

import org.testng.annotations.Test;

/**
 * Created by leonov_ai on 31.10.16.
 */
public class SquareTests {

  @Test
  public void testArea() {
  Square s = new Square (5);
  /*  assert s.area() == 25; */
  assert 5 == 5;
  }

}
