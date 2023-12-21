package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
    var appPanel = new JPanel(new GridBagLayout());
    var appPanelConstraints = new GridBagConstraints();
    var titlePanel = new JPanel(new GridLayout(1, 5));
    var bingoBoard = new JPanel(new GridLayout(1, 5));

    String[] bButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(1, 15, 5));
    String[] iButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(16, 30, 5));
    String[] nButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(31, 45, 5));
    nButtons[2] = "FREE";
    String[] gButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(46, 60, 5));
    String[] oButtons = intArrToStringArr(NumberGen.getRandomNumberInRange(61, 75, 5));

    JLabel[] bingoLabels = { new JLabel("B", SwingConstants.CENTER), new JLabel("I", SwingConstants.CENTER),
        new JLabel("N", SwingConstants.CENTER), new JLabel("G", SwingConstants.CENTER),
        new JLabel("O", SwingConstants.CENTER), };

    appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    for (var bingoLabel : bingoLabels) {
      bingoLabel.setFont(new Font("Impact", Font.BOLD, 55));
      titlePanel.add(bingoLabel);
    }

    appPanelConstraints.gridx = 0;
    appPanelConstraints.gridy = 0;
    appPanelConstraints.weightx = 1;
    appPanelConstraints.weighty = 1;
    appPanelConstraints.fill = GridBagConstraints.BOTH;
    appPanelConstraints.gridwidth = 5;
    appPanelConstraints.ipadx = 75;
    appPanelConstraints.ipady = 75;

    appPanel.add(titlePanel, appPanelConstraints);

    bingoBoard.add(buildBingoLane(bButtons, Color.decode("#5CFFFF")));
    bingoBoard.add(buildBingoLane(iButtons, Color.decode("#9999FF")));
    bingoBoard.add(buildBingoLane(nButtons, Color.decode("#FF7070")));
    bingoBoard.add(buildBingoLane(gButtons, Color.decode("#FFFF5C")));
    bingoBoard.add(buildBingoLane(oButtons, Color.decode("#00FA9A")));

    appPanelConstraints.gridx = 0;
    appPanelConstraints.gridy = 1;
    appPanelConstraints.gridwidth = 5;
    appPanelConstraints.gridheight = 5;

    appPanel.add(bingoBoard, appPanelConstraints);

    appWindow.add(appPanel);

    appWindow.pack();
    appWindow.setVisible(true);
  }

  static JPanel buildBingoLane(String[] buttonLabels, Color buttonColor) {
    var bingoLane = new JPanel(new GridLayout(5, 1));
    var components = new Components();

    for (String label : buttonLabels) {
      var bingoButton = components.new BingoNumber(label, buttonColor);
      bingoButton.setFont(new Font("Arial", Font.PLAIN, 20));
      bingoButton.setPreferredSize(new Dimension(85, 85));
      bingoButton.addActionListener(e -> {
        Components.BingoNumber eventButton = (Components.BingoNumber) e.getSource();
        boolean toggled = eventButton.isSelected();
        if (toggled) {
          bingoButton.recolor(Color.LIGHT_GRAY);
        } else {
          bingoButton.recolor(buttonColor);
        }
      });
      bingoLane.add(bingoButton);
    }

    return bingoLane;
  }

  static String[] intArrToStringArr(int[] intArr) {
    return Arrays.stream(intArr).mapToObj(String::valueOf).toArray(String[]::new);
  }
}
