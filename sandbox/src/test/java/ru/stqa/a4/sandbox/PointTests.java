package ru.stqa.a4.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by leonov_ai on 31.10.16.
 */

public class PointTests {

  @Test

  public void testDistance()
  {
    /* 2 точки */
    Point p1 = new Point(10, 20);
    Point p2 = new Point(13, 24);

    /* используем assert */
    assert p1.distance2(p1 , p2) == 5;
    assert p2.distance2(p1 , p2) == 5.0;

    /* используем класс Assert, функция assertEquals */
    /* используем для теста метод distance2 */
    Assert.assertEquals(p1.distance2(p1, p2), 5.0);
    Assert.assertEquals(p2.distance2(p1, p2), 5.0);

    /* используем для теста метод distance1 */
    Assert.assertEquals(p1.distance1(p2), 5.0);
    Assert.assertEquals(p2.distance1(p1), 5.0);


    /* 2 точки отрицательные */
    Point pn1 = new Point(-10, -20);
    Point pn2 = new Point(-13, -24);

   /* используем класс Assert, функция assertEquals */
    /* используем для теста метод distance2 */
    Assert.assertEquals(pn1.distance2(pn1, pn2), 5.0);
    Assert.assertEquals(pn2.distance2(pn1, pn2), 5.0);


    /* используем для теста метод distance1 */
    Assert.assertEquals(pn1.distance1(pn2), 5.0);
    Assert.assertEquals(pn2.distance1(pn1), 5.0);


}
}
