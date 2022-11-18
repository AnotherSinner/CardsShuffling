package ru.anothersinner.cardsshuffling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {

        // часть 1
        int players = input();
        // часть 2
        checkInput(players);
        // часть 3
        game(players);
    }
    //часть 1
    public  static Integer input() throws PlayersExceptions {
        System.out.println("Введите кол-во игроков:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        int b = 0;
        try {
            s = reader.readLine();
            b = Integer.parseInt(s);

        } catch (NumberFormatException e) {
            System.out.println("Введён не верный символ, или Ваше число слишком большое!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return b;
    }
    //часть 2
    public static Integer checkInput(int num) {
        if (num < 0) {
            throw new PlayersExceptions("Число игроков не может быть меньше 0.");
        } if (num > 10) {
            throw new PlayersExceptions("Слишком много игроков!");
        } if (num == 0) {
            throw new PlayersExceptions("Игра прекращена.");
        }
        return num;
    }
    // часть 3
    public static void game (int players) {
        int n = CardsSuits.values().length * CardsRanks.values().length; // количество карт
        int cardsPerPlayer = 5;
        String[] deck = new String[n];
        for (int i = 0; i < CardsRanks.values().length; i++) {
            for (int j = 0; j < CardsSuits.values().length; j++) {
                deck[CardsSuits.values().length * i + j] = CardsRanks.values()[i] + " " + CardsSuits.values()[j];
            }
        }
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i)); // случайная карта в колоде
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // часть 5 - перетасованная колода выводится на экран
        for (int i = 0; i < players * cardsPerPlayer; i++) {
            System.out.println(deck[i]);
            if (i % cardsPerPlayer == cardsPerPlayer - 1)
                System.out.println();
        }
    }
}
