
package tools;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;

import drawingpanel.DrawingPanel;
/**
 * 
 * @author Timur
 * @version 11/20
 *Sets up the Rectangle button.
 */
public class Rectangle extends AbstractTool
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * 
   */
  private final Action my_rect = new RectAction();
  /**
   * 
   */
  private final JToggleButton my_rect_bar;
  /**
   * 
   */
  private final JRadioButtonMenuItem my_rect_menu;

  /**
   * 
   */
  public Rectangle()
  {
    super();
    my_rect_bar = new JToggleButton(my_rect);
    my_rect_menu = new JRadioButtonMenuItem(my_rect);
  }

  /**
   * @return rectBar
   */
  public AbstractButton rectBarButton()
  {
    return my_rect_bar;
  }

  /**
   * @return rectMenu
   */
  public AbstractButton rectMenuButton()
  {
    return my_rect_menu;
  }

  /**
   * Sets mnemonics for rectangle buttons.
   */
  private class RectAction extends AbstractAction
  {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs the mnemonics.
     */
    public RectAction()
    {
      super("Rectangle", new ImageIcon("rectangle_bw.gif"));
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
      putValue(Action.SELECTED_KEY, false);
    }

    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      DrawingPanel.my_tool = new RectangleTool();
    }
  }
}
