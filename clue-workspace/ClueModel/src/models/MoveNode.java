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

	MoveNode(Cell cell, MoveNode src) {
		this.cell = cell;
		if (src == null) {
			this.passed_by = new Cell[14];
			this.passed_by[0] = cell;
			this.num_passed = 1;

		} else {
			this.passed_by = Arrays.copyOf(src.passed_by, src.passed_by.length);
			this.num_passed = src.num_passed;
		}
		this.is_final = false;
	}

	// Adiciona um nó à lista de nós atravessados para chegar a determinada casa
	public void pass_node() {
		passed_by[num_passed] = cell;
		num_passed++;
	}

	// Getters / setters
	public Cell getCell() {
		return cell;
	}

	public void setIs_final() {
		is_final = true;
	}

	public boolean is_final() {
		return this.is_final;
	}

	public int get_x() {
		return cell.get_x();
	}

	public int get_y() {
		return cell.get_y();
	}

	public Cell get_shortcut() {
		return cell.get_passagem();
	}

	public String get_room() {
		return cell.getRoom();
	}

	public boolean has_passed(Cell cell) {
		for (int i = 0; i < num_passed; i++) {
			Cell c = passed_by[i];
			if (c.get_x() == cell.get_x() && c.get_y() == cell.get_y()) {
				return true;
			}
		}
		return false;
	}

	public boolean has_shortcut() {
		return cell.has_shortcut();
	}

	public boolean is_room() {
		return cell.is_room();
	}
}
