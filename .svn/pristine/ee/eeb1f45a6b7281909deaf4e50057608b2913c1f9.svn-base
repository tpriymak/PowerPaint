
package drawingpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Stack;

import javax.swing.JPanel;

import tools.AbstractToolAction;
import tools.PencilTool;

/**
 * @author Timur Priymak
 * @version 11/04
 */
public class DrawingPanel extends JPanel
{
  /**
   * @field serialVersionUID
   */
  private static final long serialVersionUID = 1L;
  /**
   * @field PREF_DIMENSION_X The preferred x-size for the drawing panel.
   */
  private static final int PREF_DIMENSION_X = 400;
  /**
   * @field PREF_DIMENSION_Y The preferred y-size for the drawing panel.
   */
  private static final int PREF_DIMENSION_Y = 300;
  /**
   * Grid spacing.
   */
  private static final int GRID_SIZE = 10;
  /**
   * Current tool.
   */
  public static AbstractToolAction my_tool;
  /**
   * @field my_paths The stack of individual lines.
   */
  public static Stack<Shape> my_paths = new Stack<Shape>();
  /**
   * Stack of undone shapes.
   */
  public static Stack<Shape> my_redo = new Stack<Shape>();
  /**
   * Current color.
   */
  public static Color my_color = Color.BLACK;
  /**
   * Current stroke.
   */
  private int my_stroke = 1;
  /**
   * Sets if the grid is on.
   */
  public static boolean my_grid_boolean;
 

  /**
   * Initializes the preferred size of the panel, the background color and
   * attaches motion and mouse listeners.
   */
  public DrawingPanel()
  {
    super();
    setPreferredSize(new Dimension(PREF_DIMENSION_X, PREF_DIMENSION_Y));
    setBackground(Color.WHITE);
    addMouseListener(new MousePress());
    addMouseListener(new MouseRelease());
    addMouseMotionListener(new MouseDrag());
  }

  /**
   * @param the_graphics The graphics component Paints on the drawing panel.
   *          Draws the various shapes onto the board.
   */

  @Override
  public void paintComponent(final Graphics the_graphics)
  {
    if (my_tool == null)
    {
      my_tool = new PencilTool();
    }
    super.paintComponent(the_graphics);
    Graphics2D g2d = (Graphics2D) the_graphics;
    g2d = (Graphics2D) the_graphics;
    g2d.setColor(my_color);
    g2d.setStroke(new BasicStroke(my_stroke));
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    for (Shape s : my_paths)
    {
      g2d.draw(s);
    }
    if (my_grid_boolean)
    {
      final Graphics2D g2d2 = g2d;
      g2d2.setColor(Color.BLACK);
      g2d2.setStroke(new BasicStroke(1));
      for (int i = 0; i < getWidth(); i += GRID_SIZE)
      {
        g2d2.drawLine(i, 0, i, getHeight());
      }
      for (int j = 0; j < getHeight(); j += GRID_SIZE)
      {
        g2d2.drawLine(0, j, getWidth(), j);
      }
    }
  }

  /**
   * Undos the last action.
   */
  public void undo()
  {
    my_redo.push(my_paths.pop());
    repaint();
  }

  /**
   * Redos the last action.
   */
  public void redo()
  {
    my_paths.push(my_redo.pop());
    repaint();
  }

  /**
   * @param the_s Sets the current stroke.
   */
  public void setStroke(final int the_s)
  {
    my_stroke = the_s;
  }

  /**
   * Clears the panel.
   */
  public void clearPanel()
  {
    my_paths.clear();
    repaint();
  }

  /**
   * Notifys the tools of a mousePress.
   */
  private class MousePress extends MouseAdapter
  {
    @Override
    public void mousePressed(final MouseEvent the_event)
    {
      my_tool.mousePressed(the_event);
    }
  }

  /**
   * Notifys the tools of a MouseRelease.
   */
  private class MouseRelease extends MouseAdapter
  {
    @Override
    public void mouseReleased(final MouseEvent the_event)
    {
      my_tool.mouseReleased(the_event);
      repaint();
    }
  }

  /**
   * Notifies the tools of a mouseDrag.
   */
  private class MouseDrag extends MouseMotionAdapter
  {
    @Override
    public void mouseDragged(final MouseEvent the_event)
    {
      my_tool.mouseDragged(the_event);
      repaint();
    }
  }
}
