package ru.anothersinner.cardsshuffling;

public enum CardsRanks {
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Ten("10"),
    Jack("Валет"),
    Queen("Королева"),
    Kind("Король"),
    Ace("Туз");

    private String rank;

    CardsRanks(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
