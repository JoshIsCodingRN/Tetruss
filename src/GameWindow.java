import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final String GAME_TITLE = "Tetruss";
    private static final String SCORE_TEXT = "Score: ";
    private static final String LEVEL_TEXT = "Level: ";

    private JLabel scoreLabel;
    private JLabel levelLabel;

    public GameWindow(){
        setTitle("GAME_TITLE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);


        GameRenderer gameRenderer = new GameRenderer();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        getContentPane().add(gameRenderer);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        scoreLabel = new JLabel(SCORE_TEXT + "0");
        levelLabel = new JLabel(LEVEL_TEXT + "1");

        infoPanel.add(Box.createVerticalGlue());
        infoPanel.add(scoreLabel);
        infoPanel.add(levelLabel);
        infoPanel.add(Box.createVerticalGlue());

        mainPanel.add(infoPanel, BorderLayout.EAST);

        JLabel titleLabel = new JLabel(GAME_TITLE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        getContentPane().add(infoPanel, BorderLayout.SOUTH);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // Method to update the score label
    public void updateScoreLabel(int score) {
        scoreLabel.setText(SCORE_TEXT + score);
    }

    // Method to update the level label
    public void updateLevelLabel(int level) {
        levelLabel.setText(LEVEL_TEXT + level);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(GameWindow::new);
    }
}
