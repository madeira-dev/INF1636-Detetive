package models;

import java.util.Objects;

// Abstração da "casa" lógica do tabuleiro
class Cell{
    private String personagem;    // Personagem que ocupa a casa no momento ("" se nenhum)
    private final int x;    // Coordenada x da casa no tabuleiro
    private final int y;  // Coordenada y da casa no tabuleiro
    private String comodo; // Comodo que essa casa está, "" se está nos corredores
    private Cell passagem_secreta; // Passagem secreta que essa casa leva para, null se nenhum
    private boolean fora_do_mapa; // Se a casa está fora do tabuleiro (out of bounds ou interior dos comodos)
    
    public Cell(int x, int y)   //Construtor
     {
        personagem = "";
        comodo = "";
        fora_do_mapa = false;
        this.x = x;
        this.y = y;
        passagem_secreta = null;
    }
    /* Usado para debugging. Printa no terminal o que essa casa contém. NÃO É PERMANENTE, SERÁ SUBSTITUÍDO
    PELA INTERFACE GRÁFICA ESCOLHIDA
     */
    public void print()  {
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
    // Usados para criar a abstração lógica do tabuleiro
    public void tira_do_mapa()
     {
        this.fora_do_mapa = true;
    }
    public Cell get_passagem(){
        return passagem_secreta;
    }
    public void vira_comodo(String comodo) {
        this.comodo = comodo;
    }
    public void coloca_no_mapa(){this.fora_do_mapa = false;}
    public void aloca_personagem(String personagem){this.personagem = personagem;}
    public void configura_passagem(Cell cell){
        passagem_secreta = cell;
    }
    // Getters
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public String getComodo(){
        return comodo;
    }
    // Checa se o espaço é válida
    public boolean is_free(){
        return !fora_do_mapa && Objects.equals(personagem, "");
    }
    // Usado para debug
    public void print_coord(){
        System.out.printf("(%d, %d)\n", x, y);
    }
}