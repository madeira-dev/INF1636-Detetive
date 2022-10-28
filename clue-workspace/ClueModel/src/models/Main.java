package models;

public class Main {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		MoveGenerator m = new MoveGenerator(b);

		b.init_all();
		b.print_board();


		Cell start = b.get_cell(10, 25);
		m.set_generator(start);

		Cell[] moves = m.get_moves(7);
		for(Cell move:moves){
			if(move == null){
				break;
			}
			move.print_coord();
		}

	}

}
