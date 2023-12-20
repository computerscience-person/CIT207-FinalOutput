package App;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * App
 */
public class App {

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(App::buildGUI);
  }

  static void buildGUI() {
    var appWindow = new JFrame("BINGO Game!");
    var appPanel = new JPanel(new GridLayout(2, 1));
    var bingoBoard = new JPanel(new GridLayout(1, 5));
    var dims = new Dimension(550, 650);

    String[] sampleButtonLabels = { "1", "3", "7", "9", "15" };

    appWindow.setSize(dims);
    appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    var titlePanel = new JPanel(new GridLayout(1, 5));
    JLabel[] bingoLabels = { new JLabel("B"), new JLabel("I"), new JLabel("N"), new JLabel("G"), new JLabel("O"), };

    for (var bingoLabel : bingoLabels) {
      titlePanel.add(bingoLabel);
    }

    appPanel.add(titlePanel);

    bingoBoard.add(buildBingoLane(sampleButtonLabels));
    bingoBoard.add(buildBingoLane(sampleButtonLabels));
    bingoBoard.add(buildBingoLane(sampleButtonLabels));
    bingoBoard.add(buildBingoLane(sampleButtonLabels));
    bingoBoard.add(buildBingoLane(sampleButtonLabels));

    appPanel.add(bingoBoard);

    appWindow.add(appPanel);

    appWindow.setVisible(true);
  }

  static JPanel buildBingoLane(String[] buttonLabels) {
    var bingoLane = new JPanel(new GridLayout(5, 1));
    var components = new Components();

    for (String label : buttonLabels) {
      var bingoButton = components.new BingoNumber(label);
      bingoLane.add(bingoButton);
    }

    return bingoLane;
  }
}
