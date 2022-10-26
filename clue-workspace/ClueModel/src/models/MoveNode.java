package models;

import java.util.Arrays;

public class MoveNode {
    Cell cell;
    Cell[] passed_by;
    int num_passed;

    MoveNode(Cell cell){
        this.cell = cell;
        this.passed_by = new Cell[12];
        this.num_passed = 0;
    }

    public int getNum_passed() {
        return num_passed;
    }

    public Cell getCell(){
        return cell;
    }
    public int get_x(){
        return cell.get_x();
    }
    public int get_y(){
        return cell.get_y();
    }
    public Cell get_shortcut(){
        return cell.get_passagem();
    }
    public String get_room(){
        return cell.getRoom();
    }

    public boolean has_passed(Cell cell){
        for(Cell c: passed_by){
            if(c == cell){
                return false;
            }
        }
        return true;
    }

    public boolean has_shortcut(){
        return cell.has_shortcut();
    }
    public boolean is_room(){
        return cell.is_room();
    }
}
