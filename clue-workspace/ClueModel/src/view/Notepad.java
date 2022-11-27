package view;

import javax.swing.*;
import models.API;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notepad extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// arrays pra guardar checkboxes
	JCheckBox[] armas_arr = new JCheckBox[6];
	JCheckBox[] suspeitos_arr = new JCheckBox[6];
	JCheckBox[] comodos_arr = new JCheckBox[9];

	JLabel suspeitos = new JLabel("Suspeitos");
	JLabel armas = new JLabel("Armas");
	JLabel comodos = new JLabel("Comodos");

	public Notepad(Boolean[] bool_armas, Boolean[] bool_suspeitos, Boolean[] bool_comodos) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		this.setTitle("Bloco de Notas");
		this.setBounds(1000, 500, 600, 450);

		armas_arr[0] = new JCheckBox("Cano de Chumbo");
		armas_arr[1] = new JCheckBox("Castiçal");
		armas_arr[2] = new JCheckBox("Corda");
		armas_arr[3] = new JCheckBox("Chave Inglesa");
		armas_arr[4] = new JCheckBox("Faca");
		armas_arr[5] = new JCheckBox("Revolver");

		suspeitos_arr[0] = new JCheckBox("Mrs. White");
		suspeitos_arr[1] = new JCheckBox("Rev. Green");
		suspeitos_arr[2] = new JCheckBox("Mrs. Scarlett");
		suspeitos_arr[3] = new JCheckBox("Prof. Plum");
		suspeitos_arr[4] = new JCheckBox("Mrs. Peacock");
		suspeitos_arr[5] = new JCheckBox("Cor. Mustard");

		comodos_arr[0] = new JCheckBox("Biblioteca");
		comodos_arr[1] = new JCheckBox("Cozinha");
		comodos_arr[2] = new JCheckBox("Entrada");
		comodos_arr[3] = new JCheckBox("Escritorio");
		comodos_arr[4] = new JCheckBox("Jardim de Inverno");
		comodos_arr[5] = new JCheckBox("Sala De Estar");
		comodos_arr[6] = new JCheckBox("Sala De Jantar");
		comodos_arr[7] = new JCheckBox("Sala De Musica");
		comodos_arr[8] = new JCheckBox("Salao De Jogos");

//      suspeitos
		suspeitos.setBounds(15, 0, 150, 20);
		suspeitos_arr[0].setBounds(15, 40, 150, 20);
		suspeitos_arr[1].setBounds(15, 80, 150, 20);
		suspeitos_arr[2].setBounds(15, 120, 150, 20);
		suspeitos_arr[3].setBounds(15, 160, 150, 20);
		suspeitos_arr[4].setBounds(15, 200, 150, 20);
		suspeitos_arr[5].setBounds(15, 240, 150, 20);
		this.add(suspeitos);

//		armas
		armas.setBounds(180, 0, 150, 20);
		armas_arr[0].setBounds(180, 40, 150, 20);
		armas_arr[1].setBounds(180, 80, 150, 20);
		armas_arr[2].setBounds(180, 120, 150, 20);
		armas_arr[3].setBounds(180, 160, 150, 20);
		armas_arr[4].setBounds(180, 200, 150, 20);
		armas_arr[5].setBounds(180, 240, 150, 20);
		this.add(armas);

//      comodos
		comodos.setBounds(330, 0, 150, 20);
		comodos_arr[0].setBounds(330, 40, 150, 20);
		comodos_arr[1].setBounds(330, 80, 150, 20);
		comodos_arr[2].setBounds(330, 120, 150, 20);
		comodos_arr[3].setBounds(330, 160, 150, 20);
		comodos_arr[4].setBounds(330, 200, 150, 20);
		comodos_arr[5].setBounds(330, 240, 150, 20);
		comodos_arr[6].setBounds(330, 280, 150, 20);
		comodos_arr[7].setBounds(330, 320, 150, 20);
		comodos_arr[8].setBounds(330, 360, 150, 20);
		this.add(comodos);

//      atualizando estado das chekcboxes de armas e suspeitos
		for (int i = 0; i < 6; i++) {
			this.add(armas_arr[i]);
			armas_arr[i].setSelected(bool_armas[i]);

			this.add(suspeitos_arr[i]);
			suspeitos_arr[i].setSelected(bool_suspeitos[i]);
		}

//      atualizando estado das chekcboxes de comodos
		for (int i = 0; i < 9; i++) {
			this.add(comodos_arr[i]);
			comodos_arr[i].setSelected(bool_comodos[i]);
		}

//      salvando estado das checkboxes de arma e suspeito
		for (int i = 0; i < 6; i++) {
			bool_armas[i] = armas_arr[i].isSelected();
			bool_suspeitos[i] = suspeitos_arr[i].isSelected();
		}

//      salvando estado das checkboxes de comodos
		for (int i = 0; i < 9; i++) {
			bool_comodos[i] = comodos_arr[i].isSelected();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
