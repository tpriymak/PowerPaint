package tools;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import drawingpanel.DrawingPanel;
/**
 * 
 * @author Timur
 * @version 11/20
 */
public abstract class AbstractTool extends AbstractAction
{
  /**
   * Serial ID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * X position of mouse press.
   */
  protected int my_x;
  /**
   * Y position of mouse press.
   */
  protected int my_y;
  /**
   * DrawingPanel object.
   */
  protected DrawingPanel my_panel = new DrawingPanel();
/**
 * Sets the x and y of the initial mouse press.
 * @param the_x X coordinate
 * @param the_y Y coordinate
 */
  public void notifyTool(final int the_x, final int the_y)
  {
    my_x = the_x;
    my_y = the_y;
  }
/**
 * Overrides actionPermormed.
 * @param the_e Action
 */
  @Override
  public void actionPerformed(final ActionEvent the_e)
  {
    // TODO Auto-generated method stub
  }

}
