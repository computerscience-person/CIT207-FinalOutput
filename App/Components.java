package App;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class Components {
  class BingoNumber extends JToggleButton {
    private Color color = Color.GRAY;
    // private Dimension defaultSize = new Dimension(50, 50);
    // private boolean toggleFlag = false;

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
      Dimension originalSize = super.getSize();
      int diameter = Math.min(originalSize.width, originalSize.height);
      int gap = (int) (diameter * 0.15);

      g.setColor(color);
      g.fillOval(gap / 2, gap / 2, diameter - gap, diameter - gap);
      super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
      Dimension size = super.getPreferredSize();
      size.width = size.height = Math.min(size.width, size.height);
      return size;
    }

    public void recolor(Color color) {
      this.color = color;
      this.repaint();
    }
  }
}
