
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
 */
public class Ellipse extends AbstractTool
{
  /**
   * Serial ID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * Action for ellipse button.
   */
  private final Action my_ell = new EllAction();
  /**
   * Ellipse Toggle button.
   */
  private final JToggleButton my_ell_bar;
  /**
   * Ellipse Radio Button.
   */
  private final JRadioButtonMenuItem my_ell_menu;
/**
 * Constructs the ellipse buttons.
 */
  public Ellipse()
  {
    super();
    my_ell_bar = new JToggleButton(my_ell);
    my_ell_menu = new JRadioButtonMenuItem(my_ell);
  }
  /**
   * Returns ellipse radio button.
   * @return ellBar
   */
  public AbstractButton ellBarButton()
  {
    return my_ell_bar;
  }
  /**
   * Returns ellipse menu button.
   * @return ellMenu
   */
  public AbstractButton ellMenuButton()
  {
    return my_ell_menu;
  }
  /**
   * Sets the Mnemonics for ellipse.
   */
  private class EllAction extends AbstractAction
  {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Sets the mnemonics for the Ellipse button.
     */
    public EllAction()
    {
      super("Ellipse", new ImageIcon("ellipse_bw.gif"));
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
      putValue(Action.SELECTED_KEY, false);
    }

    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      DrawingPanel.my_tool = new EllipseTool();
    }
  }
}
