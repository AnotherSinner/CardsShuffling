package ru.anothersinner.cardsshuffling;

    public enum CardsSuits {
        Spades("Пик"),
        Diamonds("Бубен"),
        Hearts("Черв"),
        Clubs("Треф");

        private String suit;
        CardsSuits (String suit) {
            this.suit = suit;
        }
        public String getSuit() {
            return suit;
        }
    }

