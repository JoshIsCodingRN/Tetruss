import javax.swing.*;
import java.awt.*;

public class GameRenderer extends JPanel {

    private static final int CELL_SIZE = 30;  // Size of each grid cell

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set up the graphics context
        Graphics2D g2d = (Graphics2D) g;

        // Draw the central black grid
        drawCentralGrid(g2d);
    }

    private void drawCentralGrid(Graphics2D g2d) {
        // Set the color to gray for the entire grid
        g2d.setColor(Color.GRAY);

        // Fill the entire grid with gray
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Set the color to black
        g2d.setColor(Color.BLACK);

        // Retrieve the board dimensions from the Board class
        int boardWidth = Board.getBoardWidth();
        int boardHeight = Board.getBoardHeight();

        // Calculate the starting position to center the grid
        int startX = (getWidth() - boardWidth * CELL_SIZE) / 2;
        int startY = (getHeight() - boardHeight * CELL_SIZE) / 2;

        // Fill the central grid with black squares
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                int x = startX + col * CELL_SIZE;
                int y = startY + row * CELL_SIZE;

                g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tetris Board");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the board dimensions in the Board class
            Board.setBoardWidth(10);
            Board.setBoardHeight(20);

            frame.setContentPane(new GameRenderer());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
