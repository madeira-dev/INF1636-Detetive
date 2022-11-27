package models;

import controller.Controller;
import view.JogoClue;
import view.Notepad;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class API implements ObservadorIF{
    static Board board;
    static MoveGenerator move_generator;
    private static Player[] players;
    private static API instance;

    public static API getInstance(){
        if(instance == null){
            instance = new API();
        }
        return instance;
    }
    public API() {
        board = Board.getInstance();
        move_generator = new MoveGenerator(board);
        players = new Player[6];
    }
    public static int[][] get_casas(int x, int y, int depth){
        move_generator.reset_generator(board.get_cell(x, y));
        return move_generator.cell_to_coord(move_generator.get_moves(depth));
    }
    public static String prepara_palpite(Player p) {
        return board.get_room(p).getName();
    }
    public static void move_player(Player p, int[] coord){
        board.move_player(p, coord);
    }
    public static void set_character(String player, int x, int y){
        board.set_character(player, x, y);
    }
    public static boolean acusar(String[] cards) {
        for (int i = 0; i < 3; i++) {
            if (!Objects.equals(cards[i], Componentes.getArquivo_secreto()[i].getName())) {
                return false;
            }
        }
        return true;
    }
    public static InfoPalpite guess(String g, String[] cards) {
        Player guesser = get_player_by_character(g);
        // Move o acusado para a sala
        Player acusado = get_player_by_character(cards[1]);
        if (acusado != null) {
            assert guesser != null;
            move_player(acusado, guesser.get_coord());
        }

        assert guesser != null;
        Player temp = guesser.getVizinho();
        Card[] options;

        // Se chegamos de novo no palpitador, encerramos o loop
        while (!Objects.equals(temp.get_character(), guesser.get_character())){
            // Cartas que o jogador respondendo na vez possui dentre as 3 do palpite
            options = temp.possui_algum(cards);
            for(Card c: options){
                System.out.println(c.getName());
            }
            // Se o jogador pode mostrar algo, encerramos
            if(options.length != 0){
                return new InfoPalpite(temp, options);
            }
            // Se não, avançamos para o próximo
            temp = temp.getVizinho();
        }
        return null;
    }
    public static Player get_player_by_character(String name) {
        for (Player p : players) {
            if (Objects.equals(p.get_character(), name)) {
                return p;
            }
        }
        return null;
    }
    public static Player get_player(int i) {
        return players[i];
    }

    public static void add_player(String character, String name, int num_players){
        for(int i = 0; i < num_players; i++){
            if(Objects.equals(players[i].get_character(), character)){
                return;
            }
        }
        players[num_players] = new Player(character, name);
    }
    private static void set_neighbors(int num_players){
        for(int i=0; i < num_players; i++){
            players[i].setVizinho(players[(i + 1) % num_players]);
        }
    }
    public static void deal_cards(){
        int i = 0;
        boolean[] ja_usado = new boolean[18];
        Card[] cards = new Card[18];
        Card[] suspeitos = Componentes.personagens_cartas();
        Card[] armas = Componentes.armas_cartas();
        Card[] locais = Componentes.comodos_cartas();
        Card[] arquivo_confidencial = Componentes.getArquivo_secreto();
        int num_players = Controller.get_num_players();
        for (Card sus : suspeitos) {
            if (!Objects.equals(sus.getName(), arquivo_confidencial[1].getName())) {
                cards[i] = sus;
                i++;
            }
        }

        for (Card arma : armas) {
            if (!Objects.equals(arma.getName(), arquivo_confidencial[0].getName())) {
                cards[i] = arma;
                i++;
            }
        }

        for (Card local : locais) {
            if (!Objects.equals(local.getName(), arquivo_confidencial[2].getName())) {
                cards[i] = local;

                i++;
            }
        }

        for (int j = 0; j < 18; j++) {
            ja_usado[j] = false;
        }

        Random result = new Random();

        int val;
        for (int j = 0; j < 18; j++) {
            val = result.nextInt(18);
            while (true) {
                if (!ja_usado[val]) {
                    players[j % num_players].addCard(cards[val]);
                    players[j % num_players].setNoteOptions(cards[val].getName(), cards[val].getType());


                    ja_usado[val] = true;
                    break;
                }

                else {
                    val = (val + 1) % 18;
                }
            }

        }
    }
    public static void mudaNote() {
        int turn = Controller.get_turn();
        new Notepad(players[turn].getNoteOptionsWeapons(), players[turn].getNoteOptionsSuspects(),
                players[turn].getNoteOptionsRooms());
    }
    public static void init_all() {
        int num_players = Controller.get_num_players();
        set_neighbors(num_players);
        deal_cards();
        players = Arrays.copyOf(players, num_players);
    }
    public static void remove_player() {
        int counter = 0;
        Player[] new_array = new Player[Controller.get_num_players() - 1];

        for (Player pl : players) {
            if (pl != get_current_player()) {
                new_array[counter] = pl;
                counter++;
            }
        }
        players = new_array;
    }

    public static void salvaJogo() {
        /*
         * bonecos escolhidos na partida bonecos vivos/mortos
         */
        JFileChooser j = new JFileChooser("C:\\Users\\thiag\\Desktop\\teste");
        j.setMultiSelectionEnabled(false);
        int turn = Controller.get_turn();
        Player current = get_current_player();
        int r = j.showSaveDialog(null);
        int num_players = Controller.get_num_players();
        Card[] arquivo_confidencial = Componentes.getArquivo_secreto();
        if (r == JFileChooser.APPROVE_OPTION) {

            try {

                FileWriter escritor = new FileWriter(j.getSelectedFile().getPath());

                // System.out.printf("%d",players.length );

                escritor.write(turn + "\n");
                escritor.write(current.get_character() + "\n");
                escritor.write(num_players + "\n");
                escritor.write(arquivo_confidencial[0].getName() + " " + arquivo_confidencial[1].getName() + " "
                        + arquivo_confidencial[2].getName() + "\n");
                for (Player c : players) {
                    escritor.write(c.get_character() + "\n");
                    escritor.write(c.get_coord()[0] + "\n");
                    escritor.write(c.get_coord()[1] + "\n");
                    escritor.write(c.getCardsArr().length + "\n");
                    for (Card carta : c.getCardsArr()) {
                        escritor.write(carta.getType() + " " + carta.getName() + "\n");
                    }
                    for (Boolean v : c.getNoteOptionsRooms()) {
                        escritor.write(v + "\n");
                    }
                    for (Boolean v : c.getNoteOptionsWeapons()) {
                        escritor.write(v + "\n");
                    }
                    for (Boolean v : c.getNoteOptionsSuspects()) {
                        escritor.write(v + "\n");
                    }
                }

                escritor.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void continuaJogo() {
        JFileChooser j = new JFileChooser("C:\\Users\\thiag\\Desktop\\teste");
        j.setMultiSelectionEnabled(false);
        int turn = Controller.get_turn();
        int r = j.showSaveDialog(null);
        String nome_jogador;

        if (r == JFileChooser.APPROVE_OPTION) {

            try {
                FileReader arquivo = new FileReader(new File(j.getSelectedFile().getPath()));
                BufferedReader linha_arquivo = new BufferedReader(arquivo);
                Player current_player;
                String[] aux;
                Card[] personagens =  Componentes.personagens_cartas();
                Card[] armas_cartas =  Componentes.armas_cartas();
                Card[] comodos_cartas =  Componentes.comodos_cartas();

                int qtd_jogadores, x, y, i = 0, qtd_cards,p;

                String linha = linha_arquivo.readLine();
                Controller.set_turn(Integer.parseInt(linha));

                linha = linha_arquivo.readLine();
                current_player = new Player(linha, "temp");
                players[turn] = current_player;

                linha = linha_arquivo.readLine();
                qtd_jogadores = Integer.parseInt(linha);
                Controller.set_num_players(qtd_jogadores);

                linha = linha_arquivo.readLine();
                aux = linha.split(" ");

                Componentes.setArquivo_secreto(0, new Card(aux[0], "arma"));
                Componentes.setArquivo_secreto(1, new Card(aux[1], "personagens"));
                Componentes.setArquivo_secreto(2, new Card(aux[2], "comodo"));

                linha = linha_arquivo.readLine();

                while (linha != null) {

                	nome_jogador=linha;
                	linha=linha_arquivo.readLine();
                    players[i] = new Player(linha, nome_jogador); /* i ou turn?, estou com sono */

                    linha = linha_arquivo.readLine();
                    x = Integer.parseInt(linha);
                    linha = linha_arquivo.readLine();
                    y = Integer.parseInt(linha);
                    players[i].move(x, y); /* i ou turn?, estou com sono */
                    set_character(players[i].get_character(), x, y);
                    linha = linha_arquivo.readLine();
                    qtd_cards = Integer.parseInt(linha);

                    for ( p = 0; p < qtd_cards; p++) {
                        linha = linha_arquivo.readLine();
                        aux = linha.split(" ");
                        players[i].addCard(new Card(aux[1], aux[0]));
                    }

                    for ( p = 0; p < 9; p++) {
                        linha=linha_arquivo.readLine();

                        if(Objects.equals(linha, "true")) {
                            players[i].setNoteOptions(comodos_cartas[p].getName(), comodos_cartas[p].getType());
                        }

                    }
                    for ( p = 0; p < 6; p++) {
                        linha=linha_arquivo.readLine();
                        if(Objects.equals(linha, "true")) {
                            players[i].setNoteOptions(armas_cartas[p].getName(),armas_cartas[p].getType());
                        }
                    }
                    for ( p = 0; p < 6; p++) {
                        linha=linha_arquivo.readLine();
                        if(Objects.equals(linha, "true")) {
                            players[i].setNoteOptions(personagens[p].getName(),personagens[p].getType());
                        }
                    }
                    players[i].printNote();

                    i++;
                    linha = linha_arquivo.readLine();

                }
                new JogoClue();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static Player get_current_player() {
        return get_player(Controller.get_turn());
    }
    public static String get_current_player_character(){return get_current_player().get_character();}

    public static int[] get_player_coord(int i){
        return players[i].get_coord();
    }
    public static String get_player_character(int i){
        return players[i].get_character();
    }
    public static String get_player_name(int i){
        return players[i].get_name();
    }
    public static String[][] get_player_cards_by_type(int i){
        Player p = get_player(i);
        String[] armas = p.get_card_by_type("arma");
        String[] personagens = p.get_card_by_type("personagem");
        String[] comodos = p.get_card_by_type("comodo");

        return new String[][]{comodos, armas, personagens};
    }
    public static void set_player_note(String name, String card, String type){
        Player p = get_player_by_character(name);
        assert p != null;
        p.setNoteOptions(card, type);
    }

    @Override
    public void notify_dado_jogado(ObservadoIF ob) {

    }
}
