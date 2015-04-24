package tools;

import java.awt.event.MouseAdapter;

import drawingpanel.DrawingPanel;
/**
 * 
 * @author Timur
 * @version 11/20
 */
public abstract class AbstractToolAction extends MouseAdapter
{
  /**
   * The x coordinate.
   */
  protected int my_x;
  /**
   * The y coordinate.
   */
  protected int my_y;
  /**
   * A drawing panel object.
   */
  protected DrawingPanel my_panel = new DrawingPanel();
  /**
   * Sets the x and y coordinates.
   * @param the_x X coordinate
   * @param the_y Y coordinate
   */
  public void setXY(final int the_x, final int the_y)
  {
    my_x = the_x;
    my_y = the_y;
  }
}
