
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
public class Line extends AbstractTool
{
  /**
   * Serial ID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * Makes a new LineAction.
   */
  private final Action my_line = new LineAction();
  /**
   * Line toggle button.
   */
  private final JToggleButton my_line_bar;
  /**
   * Line radio button.
   */
  private final JRadioButtonMenuItem my_line_menu;

  /**
   * Attaches action listeners to the Line buttons.
   */
  public Line()
  {
    super();
    my_line_bar = new JToggleButton(my_line);
    my_line_menu = new JRadioButtonMenuItem(my_line);
  }

  /**
   * Returns the line toolbar button.
   * 
   * @return lineBar
   */
  public AbstractButton lineBarSetup()
  {
    return my_line_bar;
  }

  /**
   * Returns the line menu button.
   * 
   * @return lineMenu
   */
  public AbstractButton lineMenuSetup()
  {
    return my_line_menu;
  }

  /**
   * 
   * @author Timur Attaches the Mnemonics to the Line button.
   */
  private class LineAction extends AbstractAction
  {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Syncs the Line buttons.
     */
    public LineAction()
    {
      super("Line", new ImageIcon("line_bw.gif"));
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
      putValue(Action.SELECTED_KEY, false);
    }

    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      DrawingPanel.my_tool = new LineTool();
    }
  }

}
