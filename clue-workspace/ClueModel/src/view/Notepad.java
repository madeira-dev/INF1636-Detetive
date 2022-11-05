package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Notepad extends JFrame implements ActionListener {


    JCheckBox corda= new JCheckBox("Corda");
    JCheckBox cano_chumbo= new JCheckBox("Cano de Chumbo");
    JCheckBox faca= new JCheckBox("Faca");
    JCheckBox chave_inglesa= new JCheckBox("Chave Inglesa");
    JCheckBox castical= new JCheckBox("Castiçal");
    JCheckBox revolver= new JCheckBox("Revolver");

    JCheckBox scarlett= new JCheckBox("Mrs. Scarlett");
    JCheckBox mustard= new JCheckBox("Coronel Mustard");
    JCheckBox white= new JCheckBox("Mrs. White");
    JCheckBox peacock= new JCheckBox("Mrs. Peacock");
    JCheckBox plum= new JCheckBox("Prof. Plum");
    JCheckBox green= new JCheckBox("Rev. Green");

    JCheckBox study= new JCheckBox("Study");
    JCheckBox hall= new JCheckBox("Hall");
    JCheckBox lounge= new JCheckBox("Lounge");
    JCheckBox library= new JCheckBox("Library");
    JCheckBox dining_room= new JCheckBox("Dining Room");
    JCheckBox kitchen= new JCheckBox("Kitchen");
    JCheckBox ball_room= new JCheckBox("Ball Room");
    JCheckBox conservatory= new JCheckBox("Conservatory");
    JCheckBox billard_room= new JCheckBox("Billard Room");

    JButton salvar = new JButton("Salvar");



    public Notepad()
    {


        salvar.setBounds(450,300,100,20);
        salvar.addActionListener(this);

        scarlett.setBounds(15,40,150,20);
        green.setBounds(15,80,150,20);
        white.setBounds(15,120,150,20);
        mustard.setBounds(15,160,150,20);
        plum.setBounds(15,200,150,20);
        peacock.setBounds(15,240,150,20);

        corda.setBounds(180,40,150,20);
        cano_chumbo.setBounds(180,80,150,20);
        faca.setBounds(180,120,150,20);
        chave_inglesa.setBounds(180,160,150,20);
        castical.setBounds(180,200,150,20);
        revolver.setBounds(180,240,150,20);

        study.setBounds(330,40,150,20);
        hall.setBounds(330,80,150,20);
        lounge.setBounds(330,120,150,20);
        library.setBounds(330,160,150,20);
        dining_room.setBounds(330,200,150,20);
        kitchen.setBounds(330,240,150,20);
        ball_room.setBounds(330,280,150,20);
        conservatory.setBounds(330,320,150,20);
        billard_room.setBounds(330,360,150,20);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600, 400);
        this.setVisible(true);
        this.setTitle("Bloco de Notas");


        this.add(salvar);
        this.add(scarlett);
        this.add(green);
        this.add(white);
        this.add(mustard);
        this.add(plum);
        this.add(peacock);

        this.add(corda);
        this.add(cano_chumbo);
        this.add(faca);
        this.add(chave_inglesa);
        this.add(castical);
        this.add(revolver);

        this.add(study);
        this.add(billard_room);
        this.add(library);
        this.add(conservatory);
        this.add(kitchen);
        this.add(dining_room);
        this.add(lounge);
        this.add(hall);
        this.add(ball_room);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
