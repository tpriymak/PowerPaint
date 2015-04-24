
package main;

/**
 * @author Timur Priymak
 * @version 11/04 The main program for PowerPaint.
 */
public abstract class PowerPaintMain
{
  /**
   * Initializes PowerPaint.
   * 
   * @param the_args Main parameter
   */
  public static void main(final String[] the_args)
  {
    final PaintSetup paint_setter = new PaintSetup();
    paint_setter.frameSetUp();
  }
}
