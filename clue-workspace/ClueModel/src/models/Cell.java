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
        fora_do_mapa = true;
    }
    public void print(){
        System.out.printf("Personagem: %s\nComodo? %b\nComodo Canto? %b\nFora do mapa? %b\n", personagem,
                comodo, comodo_canto, fora_do_mapa);
    }
}