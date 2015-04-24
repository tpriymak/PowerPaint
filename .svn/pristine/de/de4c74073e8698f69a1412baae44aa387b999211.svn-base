
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import drawingpanel.DrawingPanel;

/**
 * 
 * @author Timur Priymak
 * @version 11/20 Instructions to draw Ellipse.
 */
public class EllipseTool extends AbstractToolAction
{
  /**
   * Length of array.
   */
  private static final int LENGTH = 4;
  /**
   * Array of points.
   */
  private int[] my_points = new int[LENGTH];

  /**
   * Constructor of EllipseTool.
   */
  /**
   * Responds to the mouse being pressed.
   * 
   * @param the_event MousePress
   */
  public void mousePressed(final MouseEvent the_event)
  {
    my_x = the_event.getX();
    my_y = the_event.getY();
    my_points[0] = the_event.getX();
    my_points[1] = the_event.getY();
    DrawingPanel.my_paths.push(new Ellipse2D.Double(my_x, my_y, 
                                                    the_event.getX(), the_event.getY()));
  }
/**
 * Previews the ellipse.
 * @param the_event Mouse dragged
 */
  public void mouseDragged(final MouseEvent the_event)
  {
    my_points[2] = the_event.getX() - my_points[0];
    my_points[LENGTH - 1] = the_event.getY() - my_points[1];
    if (the_event.getX() - my_x < 0 && the_event.getY() - my_y < 0)
    {
      DrawingPanel.my_paths.pop();
      DrawingPanel.my_paths.push(new Ellipse2D.Double(the_event.getX(), the_event.getY(),
                                                      my_x - the_event.getX(), my_y -
                                                     the_event.getY()));
    }
    else if (the_event.getX() - my_x < 0)
    {
      DrawingPanel.my_paths.pop();
      DrawingPanel.my_paths.push(new Ellipse2D.Double(the_event.getX(), my_y,
                                 my_x - the_event.getX(), the_event.getY() - my_y));
    }
    else if (the_event.getY() - my_y < 0)
    {
      DrawingPanel.my_paths.pop();
      DrawingPanel.my_paths.push(new Ellipse2D.Double(my_x, the_event.getY(),
                                                      the_event.getX() - my_x, my_y -
                                                     the_event.getY()));
    }
    else
    {
      DrawingPanel.my_paths.pop();
      DrawingPanel.my_paths.push(new Ellipse2D.Double(my_x, my_y, the_event.getX() - my_x,
                                                      the_event.getY() - my_y));
    }
  }
}
