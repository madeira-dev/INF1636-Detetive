package models;

public class Cell{
    String personagem;
    boolean comodo;
    boolean comodo_canto;
    boolean fora_do_mapa;
    public Cell(){
        personagem = "";
        comodo = false;
        comodo_canto = false;
        fora_do_mapa = false;
    }
    public void print(){
        if(fora_do_mapa){
            System.out.print("X ");
        }
        else{
            System.out.print(". ");
        }
    }
}