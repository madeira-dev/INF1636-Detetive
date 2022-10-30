package models;

import java.util.Arrays;

public class MoveGenerator {
    Board board;
    int first;
    int last;
    boolean first_iteration;
    MoveNode current_cell;
    MoveNode[] nodes;
    MoveGenerator(Board board){
        this.board = board;
        this.nodes = new MoveNode[1000];
    }
    {
        reset_variables();
    }
    private void reset_variables(){
        this.last = 0;
        this.first_iteration = true;
    }
    public void reset_generator(Cell start){
        reset_variables();
        set_generator(start);
    }
    public void set_generator(Cell start){
        this.current_cell = new MoveNode(start);
        nodes[0] = current_cell;
        last++;
    }

    public Cell[] get_moves(int depth){
        int [][] temp;
        boolean[] neighbors;
        int old_last = last;
        int [][] mov = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        if(first_iteration){
            if(current_cell.is_room()){
                if(current_cell.has_shortcut()){
                    add_node(current_cell.get_shortcut());
                    nodes[last-1].setIs_final();
                    old_last++;
                }
                temp = get_coord_room(nodes[0].get_room());
                for (int[] coord: temp) {
                    add_node(board.get_cell(coord[0], coord[1]));
                    old_last++;
                }
            }
        }
        for(int i=first; i < old_last; i++){
            current_cell = nodes[i];
            if(current_cell.is_room() && !first_iteration){
                continue;
            }
            if(current_cell.has_shortcut() && nodes[0] != current_cell){
                continue;
            }
            neighbors = neighbor_availability();
            for(int j=0; j<4; j++) {
                Cell c = board.get_cell(current_cell.get_x() + mov[j][0], current_cell.get_y() + mov[j][1]);
                if (neighbors[j]) {
                    add_node(c);
                    nodes[last-1].pass_node(current_cell);
                    if(depth==1 || c.is_room()){
                        nodes[last-1].setIs_final();
                    }
                }
            }

        }

    first_iteration = false;
    first = old_last;
        if(depth == 1){
            return get_cells(nodes);
        }
    return get_moves(depth-1);
    }

    private Cell[] get_cells(MoveNode[] nodes){
        Cell[] cells = new Cell[1000];
        Cell c;
        boolean add;

        int added = 0;

        for(int i=0; i < last; i++){
            if(!nodes[i].is_final()){
                continue;
            }
            c = nodes[i].getCell();
            add = true;
            for(Cell c2: cells){
                if(c2 == c){
                    add = false;
                    break;
                }
            }
            if(add){
                cells[added] = c;
                added++;
            }
        }
        return Arrays.copyOf(cells, added);
    }

    private void add_node(Cell to_add){
        nodes[last] = new MoveNode(to_add);
        last++;
    }
    // Consulta onde estão as portas de cada cômodo (usada na movimentação)

    private int[][] get_coord_room(String nome){
        int [][] coords = new int[2][0];
        switch (nome) {
            case ("Study"):
                coords = Arrays.copyOf(coords, 1);
                coords[0] = new int[]{7, 4};
                break;

            case ("Lounge"):
                coords = Arrays.copyOf(coords, 1);
                coords[0] = new int[]{18, 6};
                break;

            case ("Library"):
                coords = Arrays.copyOf(coords, 2);
                coords[0] = new int[]{7, 9};
                coords[1] = new int[]{4, 11};
                break;
            case ("Dining Room"):
                coords = Arrays.copyOf(coords, 2);
                coords[0] = new int[]{18, 10};
                coords[1] = new int[]{17, 13};
                break;

            case ("Kitchen"):
                coords = Arrays.copyOf(coords, 1);
                coords[0] = new int[]{20, 19};
                break;

            case ("Conservatory"):
                coords = Arrays.copyOf(coords, 1);
                coords[0] = new int[]{5, 20};
                break;

            case ("Billard Room"):
                coords = Arrays.copyOf(coords, 2);
                coords[0] = new int[]{2, 13};
                coords[1] = new int[]{6, 16};
                break;

            case ("Ball Room"):
                coords = Arrays.copyOf(coords, 4);
                coords[0] = new int[]{15, 18};
                coords[1] = new int[]{10, 18};
                coords[2] = new int[]{9, 20};
                coords[3] = new int[]{16, 20};
                break;

            case ("Hall"):
                coords = Arrays.copyOf(coords, 3);
                coords[0] = new int[]{10, 4};
                coords[1] = new int[]{13, 6};
                coords[2] = new int[]{12, 6};
                break;
        }
        return coords;
    }

    private boolean[] neighbor_availability(){
        boolean[] availability = {false, false, false, false};
        Cell c;
        // right, left, up, down
        int [][] mov = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<4; i++){
            c = board.get_cell(current_cell.get_x() + mov[i][0], current_cell.get_y() + mov[i][1]);
            if(c.is_free() && !current_cell.has_passed(c)){
                availability[i] = true;
            }
        }
        if(current_cell.get_x() == 17 && current_cell.get_y() == 6){
            availability[0] = false;
        }
        if(current_cell.get_x() == 8 && current_cell.get_y() == 4){
            availability[1] = false;
        }
        if(current_cell.get_x() == 5 && current_cell.get_y() == 19){
            availability[3] = false;
        }

        return availability;
    }

}
