package view;

import controller.Controller;
import models.*;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Controller.init();
		API api = API.getInstance();
		Componentes.arquivo_confidencial();
		MenuClue m = new MenuClue();
	}
}
