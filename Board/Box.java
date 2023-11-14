package Board;

public class Box {
    private BoxType type;
    private final int row,column;
    /**
      Constructor for Box
     */
    public Box(int row,int column){
        this.row=row;
        this.column=column;
        this.type=BoxType.EMPTY_BOX;
    }
    //Getters and Setters for BoxType
    public BoxType getBoxType(){
        return type;
    }
    public void setBoxType(BoxType boxType){
        this.type=boxType;
    }
    /**
        Getters and setters are required here as they are private variables and access
        across classes will only be feasible through them
    */
    // Getters and setters for row & column
    public int getColumn() {
        return column;
    }
    public int getRow(){
        return row;
    }

}
