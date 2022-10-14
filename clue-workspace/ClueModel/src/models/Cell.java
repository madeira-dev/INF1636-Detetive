package models;

import java.util.Objects;

public class Cell{
    private String personagem;
    private String comodo;
    private boolean fora_do_mapa;
    public Cell(){
        personagem = "";
        comodo = "";
        fora_do_mapa = false;
    }
    public void print(){
        if(fora_do_mapa){
            System.out.print("X ");
        }
        else if(!Objects.equals(comodo, "")){
            System.out.print("* ");
        }
        else{
            System.out.print(". ");
        }
    }
    public void tira_do_mapa(){
        this.fora_do_mapa = true;
    }
    public void vira_comodo(String comodo) {
        this.comodo = comodo;
    }
    public void aloca_personagem(String personagem){this.personagem = personagem;}
}