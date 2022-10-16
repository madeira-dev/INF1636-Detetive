package models;

import static org.junit.Assert.*;
import models.Cell;

import org.junit.Test;

public class Cell_tests {

	@Test
	public void test_is_free() {
		Cell test_cell = new Cell(10, 10);
		assertTrue(test_cell.is_free());
	}
}
