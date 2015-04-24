
package gui;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JToolBar;

import tools.ColorButton;
import tools.Ellipse;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;
/**
 * 
 * @author Timur
 * @version 11/20
 * Sets up the toolbar.
 */
public class ToolBar
{
  /**
   * Makes a new Pencil button set.
   */
  private final Pencil my_pencil = new Pencil();
  /**
   * Makes a new Line.
   */
  private final Line my_line = new Line();
  /**
   * Makes a new Rectangle.
   */
  private final Rectangle my_rect = new Rectangle();
  /**
   * Makes a new Ellipse.
   */
  private final Ellipse my_ell = new Ellipse();
  /**
   * Makes a new Color button.
   */
  private final ColorButton my_color = new ColorButton();
  /**
   * Sets up the toolbar.
   * @return bar The toolbar itself.
   */
  public JToolBar toolBarSetup()
  {
    final JToolBar bar = new JToolBar();

    final ButtonGroup group = new ButtonGroup();
    group.add(((Pencil) my_pencil).setupBarButton());
    group.add(((Line) my_line).lineBarSetup());
    group.add(my_rect.rectBarButton());
    group.add(my_ell.ellBarButton());
    bar.add(my_color.colorBarButton());
    bar.add(((Pencil) my_pencil).setupBarButton());
    bar.add(((Line) my_line).lineBarSetup());
    bar.add(my_rect.rectBarButton());
    bar.add(my_ell.ellBarButton());
    return bar;
  }

  /**
   * Sets up the Tool JMenu.
   * 
   * @return tool The tool JMenu
   */
  public JMenu toolSetup()
  {
    final JMenu tool = new JMenu("Tools");
    tool.setMnemonic(KeyEvent.VK_T);
    final ButtonGroup group = new ButtonGroup();

    tool.add(my_color.colorMenuButton());
    tool.addSeparator();
    group.add(((Pencil) my_pencil).setupMenuButton());
    group.add(((Line) my_line).lineMenuSetup());
    group.add(my_rect.rectMenuButton());
    group.add(my_ell.ellMenuButton());
    tool.add(my_color.colorMenuButton());
    tool.add(((Pencil) my_pencil).setupMenuButton());
    tool.add(((Line) my_line).lineMenuSetup());
    tool.add(my_rect.rectMenuButton());
    tool.add(my_ell.ellMenuButton());
    return tool;
  }
}
