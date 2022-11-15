package controller;

import models.Board;
import models.Card;
import models.Componentes;
import models.Player;

import java.util.Objects;
import java.util.Random;

public class Controller {
    private static Board board;
    private static int turn;
    private static Player[] players;
    private static int num_players;
    private static Card[] arquivo_confidencial;
    public static int get_turn(){
        return turn;
    }
    public static void pass_turn(){turn = (turn + 1) % num_players;}
    private static Controller instance = null;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    private Controller() {
        board = Board.getInstance();
    }
    {// Temporario
        init_players(3);
        add_player("Madeira", "Peacock");
        add_player("Rafael", "Green");
        add_player("Thiago", "Plum");
    }
    // Procura entre os jogadores alguém com o personagem. Retorna o personagem caso ache ou null caso contrário
    public static Player get_player_by_character(String name){
        for(Player p: players){
            if(Objects.equals(p.getCharacter(), name)){
                return p;
            }
        }
        return null;
    }
    // Palpite
    public static Player get_current_player(){
        return players[turn];
    }
    public static Card[] guess(Player guesser, Card[] cards){
        // Move o acusado para a sala
        Player acusado = get_player_by_character(cards[1].getName());
        if(acusado != null){
            board.move_player(acusado, guesser.get_cell());
        }

        Player temp = guesser.getVizinho();
        Card[] options = new Card[0];

        // Se chegamos de novo no palpitador, encerramos o loop
        while (!Objects.equals(temp.getName(), guesser.getName())){
            // Cartas que o jogador respondendo na vez possui dentre as 3 do palpite
            options = temp.possui_algum(cards);
            // Debug
            System.out.printf("%s pode mostrar\n", temp.getName());
            for(Card c: options){
                System.out.println(c.getName());
            }
            // Se o jogador pode mostrar algo, encerramos
            if(options.length != 0){
                return options;
            }
            // Se não, avançamos para o próximo
            temp = temp.getVizinho();
        }
        return options;
    }
    // Funções usadas para configurar lógica do tabuleiro
    private static void init_players(int num){
        players = new Player[num];
    }
    private static void add_player(String name, String character){
        players[num_players] = new Player(name, character);
        num_players++;
    }
    private static void set_neighbors(){
        for(int i=0; i < num_players; i++){
            players[i].setVizinho(players[(i + 1) % num_players]);
        }
    }
    private static void deal_cards(){
        int i = 0;
        boolean[] ja_usado = new boolean[18];
        Card[] cards = new Card[18];
        Card[] suspeitos = Componentes.personagens_cartas();
        Card[] armas = Componentes.armas_cartas();
        Card[] locais = Componentes.comodos_cartas();

        for(Card sus : suspeitos){
            if(!Objects.equals(sus.getName(), arquivo_confidencial[1].getName())){
                cards[i] = sus;
                i++;
            }
        }

        for(Card arma : armas){
            if(!Objects.equals(arma.getName(), arquivo_confidencial[0].getName())){
                cards[i] = arma;
                i++;
            }
        }

        for(Card local : locais){
            if(!Objects.equals(local.getName(), arquivo_confidencial[2].getName())){
                cards[i] = local;
                i++;
            }
        }

        for(int j=0; j < 18; j++){
            ja_usado[j] = false;
        }

        Random result = new Random();

        int val;
        for(int j=0; j < 18; j++){
            val = result.nextInt(18);
            while (true){
                if(!ja_usado[val]){
                    players[j % num_players].addCard(cards[val]);
                    ja_usado[val] = true;
                    break;
                }

                else {
                    val = (val + 1) % 18;
                }
            }
        }

    }
    private static void gera_arquivo(){
        arquivo_confidencial = Componentes.arquivo_confidencial();
    }
    private static void init_all(){
        set_neighbors();
        gera_arquivo();
        deal_cards();
        board.generate_grid();

    }
}
