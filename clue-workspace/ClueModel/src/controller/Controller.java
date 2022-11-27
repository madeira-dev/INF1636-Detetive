package controller;
import models.*;
import java.util.Random;


public class Controller {
	private static int turn;
	private static int num_players;
	private static boolean[] acoes;
	private static int[] valores_dado;
	public static void init() {
		valores_dado = new int[2];
		acoes = new boolean[] { false, false };
	}
	public static void set_turn(int turno) {
		turn = turno;
	}
	public static int get_num_players() {
		return num_players;
	}
	public static void set_num_players(int num) {
		num_players = num;
	}
	public static void pass_turn() {
		turn = (turn + 1) % num_players;
		acoes = new boolean[] { false, false };
	}
	public static void atualiza_acoes(int id) {
		acoes[id] = true;
	}
	public static boolean[] get_acoes() {
		return acoes;
	}
	public static void set_valores_dado(int v1, int v2) {
		valores_dado[0] = v1;
		valores_dado[1] = v2;
	}
	public static int[][] casas_disponiveis(int x, int y) {
		return API.get_casas(x, y, valores_dado[0] + valores_dado[1]);
	}
	public static String prepara_palpite() {
		if (acoes[1]) {
			return null;
		}
		return API.prepara_palpite(API.get_current_player());
	}
	public static int get_turn(){
		return turn;
	}
	public static void alter_num_players(int n){
		num_players += n;
	}
	public static void joga_dados() {
		Random result1 = new Random();
		Random result2 = new Random();

		int val1 = 1;
		int val2 = 1;

		val1 += result1.nextInt(6);
		val2 += result2.nextInt(6);

		valores_dado[0] = val1;
		valores_dado[1] = val2;
	}
	public static int[] pega_dados() {
		return valores_dado;
	}

}
