package GameElement;

import Board.Box;
import Board.BoxType;
import Board.Grid;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Box> SnakeBody = new LinkedList<Box>();
    private Box head, tail;

    public Snake(Box startPos) {
        head = startPos;
        SnakeBody.add(head);
        head.setBoxType(BoxType.SNAKE_BOX);
        System.out.println("Snake generated");
    }
    /* Getters and setters of SnakeBody */

    public LinkedList<Box> getSnakeBody() {
        return SnakeBody;
    }

    public void setSnakeBody(LinkedList<Box> SnakeBody) {
        this.SnakeBody = SnakeBody;
    }

    /* Methods for snake */

   public void grow(Box newBox) {
        /* When snake eats food it's length will grow */
        SnakeBody.add(newBox);
       /* The head will now point to this new box*/
        this.setHead(newBox);
        System.out.println("Yummy!!");
    }

    public void move(Box newBox) {
        //Added newBox to head as snake will move to next cell
        head = newBox;
        head.setBoxType(BoxType.SNAKE_BOX);
        SnakeBody.add(head);
        //Removed tail as this cell is now not used
        tail = SnakeBody.removeLast();
        tail.setBoxType(BoxType.EMPTY_BOX);

        System.out.println("Snake moved to " + newBox.getRow() + ", " + newBox.getColumn());
    }

    public boolean checkGameOver(Box newBox ) {
        //int row = newBox.getRow(), column = newBox.getColumn();
        //int row_limit = grid.getROW_SIZE(), column_limit = grid.getCOLUMN_SIZE();
        if (newBox.getBoxType() == BoxType.SNAKE_BOX) {
            return true;
        }else {
            return false;
        }
    }

    /* Getters and Setters for head & tail */
    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public Box getTail() {
        return tail;
    }

    public void setTail(Box tail) {
        this.tail = tail;
    }
}
