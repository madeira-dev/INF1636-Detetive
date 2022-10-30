package models;

import java.util.Arrays;

public class MoveNode {
    Cell cell;
    // Lista de células que foram atravessadas para chegar até a célula atual
    // garante que uma casa não seja pisada duas vezes no mesmo turno.
    Cell[] passed_by;
    int num_passed;
    // O nó atual é final? (Destino válido para se mover para)
    boolean is_final;

    MoveNode(Cell cell){
        this.cell = cell;
        this.passed_by = new Cell[12];
        this.num_passed = 0;
        this.is_final = false;
    }
    // Adiciona um nó à lista de nós atravessados para chegar a determinada casa
    public void pass_node(MoveNode node){
        passed_by[num_passed] = node.getCell();
        num_passed++;
    }
    // Getters / setters
    public Cell getCell(){
        return cell;
    }
    public void setIs_final(){
        is_final = true;
    }
    public boolean is_final(){
        return this.is_final;
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
        for(int i=0; i <num_passed; i++){
            Cell c = passed_by[i];
            if(c == cell){
                return true;
            }
        }
        return false;
    }

    public boolean has_shortcut(){
        return cell.has_shortcut();
    }
    public boolean is_room(){
        return cell.is_room();
    }
}
