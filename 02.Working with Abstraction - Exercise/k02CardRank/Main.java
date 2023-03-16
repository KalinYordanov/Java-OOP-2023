package k02CardRank;

public class Main {
    enum CardRank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        for (CardRank value : CardRank.values()) {
            System.out.println("Ordinal value: " + value.ordinal() + "; Name value: " + value.name());
        }

    }
}
