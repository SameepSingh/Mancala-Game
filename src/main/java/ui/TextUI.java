package ui;

import mancala.MancalaGame;
import mancala.AyoRules; 
import mancala.InvalidMoveException;
import mancala.KalahRules;
import mancala.MancalaDataStructure;
import mancala.Saver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.IntStream;
import mancala.Player;
import mancala.Saver;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.io.Serializable;
public class TextUI extends JFrame {

    private static final int NUM_PITS = 6;
    private JButton[] playerOnePits = new JButton[NUM_PITS];
    private JButton[] playerTwoPits = new JButton[NUM_PITS];
    private JButton playerOneStore;
    private JButton playerTwoStore;
    private MancalaGame game= new MancalaGame();

    private void render(){
        playerOneStore.setText(String.valueOf(game.getPlayerOne().getStoreCount()));
        playerTwoStore.setText(String.valueOf(game.getPlayerTwo().getStoreCount()));
        int j = 12;
        for(int i = 1; i < NUM_PITS + 1; i++){
            playerOnePits[i-1].setText(String.valueOf(game.getNumStones(i)));
            playerOnePits[i-1].putClientProperty("Index",i);
            playerTwoPits[i-1].setText(String.valueOf(game.getNumStones(j)));
            playerTwoPits[i-1].putClientProperty("Index",j);
            j--;
            playerOnePits[i-1].addActionListener(e -> {
                try{
                    JButton butt =(JButton) e.getSource();
                    int index = (int) butt.getClientProperty("Index");
                    game.move(index);
                }catch(InvalidMoveException f){
                    f.printStackTrace();
                }
                render();
            });
            playerTwoPits[i-1].addActionListener(e -> {
                try{
                    JButton butt =(JButton) e.getSource();
                    int index = (int) butt.getClientProperty("Index");
                    game.move(index);
                }catch(InvalidMoveException f){
                    f.printStackTrace();
                }
                render();
            });

        }
    }
    



    public TextUI() {

        JFrame main = new JFrame();

        JLabel label = new JLabel("Choose the game");

        

        main.setVisible(true);

        main.setPreferredSize(new Dimension(300,300));

        JPanel buttons = new JPanel();

        JButton kalah = new JButton("Kalah");

        JButton ayo = new JButton("Ayo");

        buttons.add(kalah);
        buttons.add(ayo);
        main.setLayout(new BorderLayout());
        main.add(label, BorderLayout.NORTH);
        main.add(buttons, BorderLayout.CENTER);

        main.pack();

        kalah.addActionListener(e -> {
            main.dispose();
            gameBoard();
            game.setBoard(new KalahRules());
        });

        
        ayo.addActionListener(e -> {
            main.dispose();
            gameBoard();
            game.setBoard(new AyoRules());
        });

        
    }


    public void gameBoard(){
        setTitle("Mancala Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the stores
        playerOneStore = createStore();
        
        playerTwoStore = createStore();
        
        // Add stores to the frame
        add(playerOneStore, BorderLayout.WEST);
        add(playerTwoStore, BorderLayout.EAST);

        // Create the pits
        JPanel playerOnePanel = createPitsPanel(playerOnePits, Color.RED);
        JPanel playerTwoPanel = createPitsPanel(playerTwoPits, Color.BLUE);

        // Add the panels to the frame
        add(playerOnePanel, BorderLayout.SOUTH);
        add(playerTwoPanel, BorderLayout.NORTH);

        pack(); // Adjusts the frame to fit the components
        setVisible(true); // Makes the frame visible

        render();

        JMenuBar menu = new JMenuBar();

        JMenu file = new JMenu("File");

        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");

        menu.add(file);
        file.add(save);
        file.add(load);

        save.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int res  = chooser.showSaveDialog(null);

            if(res == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getName();
                Saver.saveObject(game,name);
            }
        });

        load.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int res  = chooser.showOpenDialog(null);

            if(res == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getName();
                Serializable info = Saver.loadObject(name);
                game =(MancalaGame)info;
                render();
            }  
            
        });

        setJMenuBar(menu);

    }

    private JButton createStore() {
        JButton store = new JButton();
        store.setPreferredSize(new Dimension(100, 200)); // Set the store size
        return store;
    }

    private JPanel createPitsPanel(JButton[] pits, Color color) {
        JPanel panel = new JPanel(new GridLayout(1, NUM_PITS)); // 1 row, NUM_PITS columns
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        for (int i = 0; i < NUM_PITS; i++) {
            pits[i] = new JButton();
            pits[i].setPreferredSize(new Dimension(100, 100)); // Set pit size
            pits[i].setBackground(color);
            panel.add(pits[i]);
        }

        return panel;
    }

    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextUI();
            }
        });
    }
}
