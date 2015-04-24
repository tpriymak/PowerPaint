
package tools;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import drawingpanel.DrawingPanel;
import main.PaintSetup;

/**
 * 
 * @author Timur
 * @version 11/20
 */
public class ColorButton
{
  /**
   * String for the color button.
   */
  private static final String COLOR = "Color...";
  /**
   * Action interface for color buttons.
   */
  private final Action my_color_action = new ColorAction();
  /**
   * Color toolbar button.
   */
  private JButton my_color_bar = new JButton(COLOR);
  /**
   * Color menu button.
   */
  private JMenuItem my_color_menu = new JMenuItem(COLOR);
/**
 * Attaches actions to the buttons.
 */
  public ColorButton()
  {
    my_color_bar = new JButton(my_color_action);
    my_color_menu = new JMenuItem(my_color_action);
  }

  /**
   * Returns the toolbar button.
   * 
   * @return colorBar
   */
  public AbstractButton colorBarButton()
  {
    my_color_bar.setMnemonic(KeyEvent.VK_C);
    return my_color_bar;
  }

  /**
   * Returns and sets Mnemonic for the color button.
   * 
   * @return colorMenu
   */
  public AbstractButton colorMenuButton()
  {
    my_color_menu.setMnemonic(KeyEvent.VK_C);
    return my_color_menu;
  }

  /**
   * 
   * @author Timur
   * 
   */
  private class ColorAction extends AbstractAction
  {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Selected color.
     */
    private Color my_current_color;

    /**
 * 
 */
    public ColorAction()
    {
      super(COLOR);
    }

    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      my_current_color = JColorChooser.showDialog(null, "Color Selector", null);
      my_color_bar.setBackground(my_current_color);
      DrawingPanel.my_color = my_current_color;
    }

  }
}
