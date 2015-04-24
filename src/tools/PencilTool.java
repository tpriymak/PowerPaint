
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D.Float;

import drawingpanel.DrawingPanel;
/**
 * 
 * @author Timur
 * @version 11/20
 * Gives instructions to draw with a pencil.
 */
public class PencilTool extends AbstractToolAction
{
  /**
   * Responds to the mouse being dragged.
   * @param the_event 
   */
  public void mousePressed(final MouseEvent the_event)
  {
    final GeneralPath g = new GeneralPath();
    g.moveTo(the_event.getX(), the_event.getY());
    DrawingPanel.my_paths.push(g);
  }
  /**
   * Draws the pencil.
   * @param the_event Mouse drag.
   */
  public void mouseDragged(final MouseEvent the_event)
  {
    ((Float) DrawingPanel.my_paths.peek()).lineTo(the_event.getX(), the_event.getY());
  }
}
