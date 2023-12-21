package App;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class Components {
  class BingoNumber extends JButton {
    private Color color = Color.GRAY;
    // private Dimension defaultSize = new Dimension(50, 50);
    private boolean toggleFlag = false;

    public BingoNumber(String label) {
      super(label);

      this.setBorderPainted(false);
      this.setContentAreaFilled(false);
    }

    public BingoNumber(String label, Color color) {
      super(label);
      this.color = color;

      this.setBorderPainted(false);
      this.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
      Dimension originalSize = super.getPreferredSize();
      int diameter = Math.min(originalSize.width, originalSize.height);

      g.setColor(color);
      g.fillOval(0, 0, diameter, diameter);
      super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
      Dimension size = super.getPreferredSize();
      size.width = size.height = Math.min(size.width, size.height);
      return size;
    }
  }
}
