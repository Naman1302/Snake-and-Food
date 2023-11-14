import Board.Box;
import Board.Grid;
import GameControl.Game;
import GameElement.Snake;

import java.util.Scanner;
//import javax.swing.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!! Welcome to the snake game");
        Box startPos = new Box(0, 0);
        Snake player = new Snake(startPos);
        Grid grid = new Grid(5, 5);
        Game newGame = new Game(player, grid);
        newGame.setGameOver(false);
        newGame.setMoveDirection(1);
        newGame.grid.generateFood();

        while (!newGame.isGameOver()) {
            System.out.println("Please press :");
            System.out.println("1: Right");
            System.out.println("2: Left");
            System.out.println("3: Up");
            System.out.println("4: Down");
//            JFrame jFrame = new JFrame();
//
//            jFrame.addKeyListener(new KeyAdapter() {
//                @Override
//                public void keyTyped(KeyEvent e) {
//                    int keyCode = e.getKeyCode();
//
//                    if (keyCode == KeyEvent.VK_UP) {
//                        newGame.setMoveDirection(3);
//                    } else if (keyCode == KeyEvent.VK_DOWN) {
//                        newGame.setMoveDirection(4);
//                    } else if (keyCode == KeyEvent.VK_LEFT) {
//                        newGame.setMoveDirection(2);
//                    } else if (keyCode == KeyEvent.VK_RIGHT) {
//                        newGame.setMoveDirection(1);
//                    } else {
//                        System.out.println("Please press a arrow key");
//                        newGame.setMoveDirection(0);
//                    }
//                }
//            });
//            jFrame.setVisible(true);
            Scanner scanner = new Scanner(System.in);
            int direction = scanner.nextInt();
            if (direction == 1) {
                newGame.setMoveDirection(1);
            } else if (direction == 2) {
                newGame.setMoveDirection(2);
            } else if (direction == 3) {
                newGame.setMoveDirection(3);
            } else if (direction == 4) {
                newGame.setMoveDirection(4);
            } else {
                System.out.println("Please press a arrow key");
                newGame.setGameOver(true);
            }

            if (newGame.getMoveDirection() == 0) {
                newGame.setGameOver(true);
                break;
            }

            newGame.refresh();
            if(newGame.isGameOver()){
                System.out.println("Game Over!!");
                break;
            }
        }
        System.out.println("Game Closed");
    }
}
