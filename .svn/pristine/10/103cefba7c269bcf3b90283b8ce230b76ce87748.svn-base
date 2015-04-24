
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import drawingpanel.DrawingPanel;
/**
 * 
 * @author Timur
 * @version 11/20
 *Instructions to draw line.
 */
public class LineTool extends AbstractToolAction
{
  /**
   * X-coordinate of mouse press.
   */
  private int my_x;
  /**
   * Y-coordinate of mouse press.
   */
  private int my_y;
  @Override
  public void mousePressed(final MouseEvent the_event)
  {
    my_x = the_event.getX();
    my_y = the_event.getY();
    DrawingPanel.my_paths.push(new Line2D.Double(my_x, my_y, 
                               the_event.getX(), the_event.getY()));
  }
  /**
   * Previews the Line.
   * @param the_event Mouse drag.
   */
  public void mouseDragged(final MouseEvent the_event)
  {
    DrawingPanel.my_paths.pop();
    DrawingPanel.my_paths.push(new Line2D.Double(my_x, my_y, 
                               the_event.getX(), the_event.getY()));
  }
}
