package models;

public class API {
    Board board;
    MoveGenerator move_generator;
    static API instance;
    private API() {
        board = Board.getInstance();
        move_generator = new MoveGenerator(board);
    }

    public static API getInstance() {
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }
    public int[][] get_casas(int x, int y, int depth){
        move_generator.reset_generator(board.get_cell(x, y));
        return move_generator.cell_to_coord(move_generator.get_moves(depth));
    }
    public Card prepara_palpite(Player p) {
        return board.get_room(p);
    }
    public void move_player(Player p, int[] coord){
        board.move_player(p, coord);
    }
    public void set_character(String player, int x, int y){
        board.set_character(player, x, y);
    }
}
