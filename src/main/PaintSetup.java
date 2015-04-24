
package main;

import gui.ToolBar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import drawingpanel.DrawingPanel;

/**
 * @author Timur Priymak
 * @version 11/04 Sets up the main GUI.
 */
public class PaintSetup
{
  /**
   * @field my_frame The main JFrame
   */
  private final JFrame my_frame = new JFrame("PowerPaint");
  /**
   * Sets up the JFrame and adds the components to it.
   */
  private final DrawingPanel my_panel = new DrawingPanel();

  /**
   * Sets up the GUI.
   */
  public void frameSetUp()
  {
    final JMenuBar bar = new JMenuBar();
    final ToolBar toolbar = new ToolBar();
    my_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    bar.add(fileSetup());
    bar.add(optionSetup());
    bar.add(toolbar.toolSetup());
    bar.add(helpSetup());
    my_frame.add(my_panel);
    my_frame.add(toolbar.toolBarSetup(), BorderLayout.SOUTH);
    my_frame.setJMenuBar(bar);
    my_frame.pack();
    my_frame.setVisible(true);
  }

  /**
   * Sets up the file JMenu.
   * 
   * @return file The file JMenu
   */
  private JMenu fileSetup()
  {
    final JMenu file = new JMenu("File");
    final JMenuItem clear = new JMenuItem("Clear", KeyEvent.VK_C);
    final JMenuItem quit = new JMenuItem("Quit", KeyEvent.VK_Q);
    final JMenuItem redo = new JMenuItem("Redo", KeyEvent.VK_R);
    final JMenuItem undo = new JMenuItem("Undo", KeyEvent.VK_U);
    redo.addActionListener(new Redo());
    undo.addActionListener(new Undo());
    quit.addActionListener(new Quit());
    clear.addActionListener(new Clear());
    file.setMnemonic(KeyEvent.VK_F);
    file.add(clear);
    file.add(redo);
    file.add(undo);
    file.addSeparator();
    file.add(quit);
    return file;
  }

  /**
   * Sets up the Option JMenu.
   * 
   * @return option The option JMenu
   */
  private JMenu optionSetup()
  {

    final JMenu option = new JMenu("Options");
    final JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Grid");
    grid.addActionListener(new GridAction());
    final JMenu thick = new JMenu("Thickness");
    final ButtonGroup group1 = new ButtonGroup();
    final JRadioButtonMenuItem thick_1 = new JRadioButtonMenuItem("1");
    thick_1.setMnemonic(KeyEvent.VK_1);
    thick_1.addActionListener(new StrokeSelect(1));
    final JRadioButtonMenuItem thick_2 = new JRadioButtonMenuItem("2");
    thick_2.setMnemonic(KeyEvent.VK_2);
    thick_2.addActionListener(new StrokeSelect(2));
    final JRadioButtonMenuItem thick_4 = new JRadioButtonMenuItem("4");
    thick_4.setMnemonic(KeyEvent.VK_4);
    thick_4.addActionListener(new StrokeSelect(4));
    option.setMnemonic(KeyEvent.VK_O);
    thick.setMnemonic(KeyEvent.VK_T);
    grid.setMnemonic(KeyEvent.VK_G);
    thick.add(thick_1);
    group1.add(thick_1);
    group1.add(thick_2);
    group1.add(thick_4);
    thick.add(thick_2);
    thick.add(thick_4);
    option.add(grid);
    option.add(thick);
    return option;
  }


  /**
   * Sets up the help JMenu.
   * 
   * @return help The help JMenu
   */
  private JMenu helpSetup()
  {
    final JMenu help = new JMenu("Help");
    help.setMnemonic(KeyEvent.VK_H);

    final JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
    about.addActionListener(new Help());
    help.add(about);
    return help;
  }

  /**
   * Returns the drawing panel.
   * 
   * @return my_panel The drawing panel.
   */
  public DrawingPanel getPanel()
  {

    return my_panel;
  }
/**
 * 
 * @author Timur
 *
 */
  private class Clear implements ActionListener
  {
    /**
     * Calls the drawing panel to clear.
     * @param the_e The button press.
     */
    public void actionPerformed(final ActionEvent the_e)
    {
      my_panel.clearPanel();
    }
  }

  /**
   * Gives the About button a message dialog.
   */
  private class Help implements ActionListener
  {

    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      JOptionPane.showMessageDialog(null, "Author: Timur Priymak \n Version: 1.0");
    }
  }
/**
 * 
 * @author Timur
 *Redos the last action.
 */
  private class Redo implements ActionListener
  {
    /**
     * Calls the panel to redo the last action.
     * @param the_e The button press
     */
    public void actionPerformed(final ActionEvent the_e)
    {
      my_panel.redo();
    }
  }
/**
 * 
 * @author Timur
 *Undos the last action.
 */
  private class Undo implements ActionListener
  {
    /**
     * Calls the panel to undo the last action.
     * @param the_e Button press
     */
    public void actionPerformed(final ActionEvent the_e)
    {
      my_panel.undo();
    }
  }

  /**
   * Sets the stroke in DrawingPanel.
   */
  private class StrokeSelect implements ActionListener
  {
    /**
     * The current stroke.
     */
    private final int my_stroke;

    /**
     * Sets the value for the stroke.
     * 
     * @param the_s Stroke value
     */
    public StrokeSelect(final int the_s)
    {
      super();
      my_stroke = the_s;
    }

    /**
     * Sets the stroke.
     * 
     * @param the_e Button click
     */
    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      my_panel.setStroke(my_stroke);
    }

  }

  /**
   * Quits the program.
   */
  private class Quit implements ActionListener
  {

    @Override
    public void actionPerformed(final ActionEvent the_e)
    {
      System.exit(0);
    }

  }

  /**
   * Gives the grid button an action.
   */
  private class GridAction implements ActionListener
  {
    /**
     * If the grid is selected or not.
     */
    private boolean my_selected;
    /**
     * Calls the panel to draw a grid.
     * 
     * @param the_e Button press
     */
    public void actionPerformed(final ActionEvent the_e)
    {
      if (my_selected)
      {
        my_selected = false;
        DrawingPanel.my_grid_boolean = false;
        my_panel.repaint();
      }
      else
      {
        my_selected = true;
        DrawingPanel.my_grid_boolean = true;
        my_panel.repaint();
      }
    }
  }
}
