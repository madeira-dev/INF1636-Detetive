package models;

import java.util.Objects;

public class Cell{
    private String personagem;
    private int x;
    private int y;
    private String comodo;
    private Cell passagem_secreta;
    private boolean fora_do_mapa;
    public Cell(int x, int y){
        personagem = "";
        comodo = "";
        fora_do_mapa = false;
        this.x = x;
        this.y = y;
        passagem_secreta = null;
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
    public void coloca_no_mapa(){this.fora_do_mapa = false;}
    public void aloca_personagem(String personagem){this.personagem = personagem;}
    public void configura_passagem(Cell cell){
        passagem_secreta = cell;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public boolean is_free(){
        return !fora_do_mapa;
    }
    public void print_coord(){
        System.out.printf("(%d, %d)\n", x, y);
    }
}