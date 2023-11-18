package GameControl;

import Board.Box;
import Board.BoxType;
import Board.Grid;
import GameElement.Snake;

public class Game {

    public final int GAME_STOP = 0, MOVE_RIGHT = 1, MOVE_LEFT = 2, MOVE_UP = 3, MOVE_DOWN = 4;
    public Grid grid;
    private Snake player;
    public int moveDirection;
    private boolean gameOver;

    public Game(Snake player, Grid grid) {
        this.player = player;
        this.grid = grid;
        System.out.println("Game created");
    }

    public Snake getPlayer() {
        return player;
    }

    public void setPlayer(Snake player) {
        this.player = player;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getMoveDirection() {
        return moveDirection;
    }

    public void setMoveDirection(int moveDirection) {
        this.moveDirection = moveDirection;
    }

    public void refresh() {
        Box newBox = getNextBox(player.getHead());
        if (moveDirection != GAME_STOP) {
            if (player.checkGameOver(newBox)) {
                setMoveDirection(GAME_STOP);
                this.setGameOver(true);
            } else {
                if (newBox.getBoxType() == BoxType.FOOD_BOX) {
                    player.grow(newBox);
                    grid.generateFood();
                } else {
                    player.move(newBox);
                }
            }
            System.out.println("Refreshed!!");

        }
        else{
            this.setGameOver(true);
        }

    }

    private Box getNextBox(Box currPos) {
        int row = currPos.getRow();
        int column = currPos.getColumn();

        if (moveDirection == MOVE_DOWN && column<grid.getROW_SIZE()-1) {
            row++;
        } else if (moveDirection == MOVE_LEFT && column>1) {
            column--;
        } else if (moveDirection == MOVE_RIGHT && column<grid.getCOLUMN_SIZE()-1) {
            column++;
        } else if (moveDirection == MOVE_UP && row>1) {
            row--;
        } else {
            this.setMoveDirection(GAME_STOP);
        }

        Box updatedBox = grid.getGrid()[row][column];

        return updatedBox;
    }
}
