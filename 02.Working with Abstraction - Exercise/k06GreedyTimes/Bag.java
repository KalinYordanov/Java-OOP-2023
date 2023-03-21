package k06GreedyTimes.greedyTimes;

import java.util.*;

import static k06GreedyTimes.greedyTimes.Type.*;


public class Bag {
    private List<Item> items;
    long capacity;

    public Bag(long capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public long getAmountByType(Type type) {
        return items.stream()
                .filter(e -> e.getType().equals(type))
                .mapToLong(Item::getAmount)
                .sum();
    }

    public long getBagAmount() {
        return getAmountByType(GEM)
                + getAmountByType(CASH)
                + getAmountByType(GOLD);
    }

    public void addToBag(Item item) {
        long currentAmount = item.getAmount();
        if (currentAmount + getBagAmount() <= capacity) {
            Type type = item.getType();

            switch (type.toString()) {
                case "GOLD":
                    if (isAllRulesValid(getAmountByType(GOLD) + currentAmount,
                            getAmountByType(GEM),
                            getAmountByType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "GEM":
                    if (isAllRulesValid(getAmountByType(GOLD),
                            getAmountByType(GEM) + currentAmount,
                            getAmountByType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "CASH":
                    if (isAllRulesValid(getAmountByType(GOLD),
                            getAmountByType(GEM),
                            getAmountByType(CASH) + currentAmount)) {
                        items.add(item);
                    }
                    break;
            }
        }
    }

    public boolean isAllRulesValid(long goldAmount, long getAmount, long cashAmount) {
        return (goldAmount >= getAmount && getAmount >= cashAmount);
    }

    private void printByGroupItem(Type type) {
        Map<String, Long> validByName = new TreeMap<>();
        items.stream().filter(e -> e.getType().equals(type))
                .forEach(e -> {
                    String name = e.getItemName();
                    validByName.putIfAbsent(name, 0L);
                    validByName.put(name, validByName.get(name) + e.getAmount());
                });
        Map<String, Long> sortedByAmount = new TreeMap<>(Collections.reverseOrder());
        validByName.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> sortedByAmount.put(e.getKey(), e.getValue()));

        sortedByAmount.forEach((key, value) -> System.out.printf("##%s - %s%n", key, value));
    }

    public void printContent() {
        if (getAmountByType(GOLD) > 0) {
            System.out.printf("<Gold> $%s%n", getAmountByType(GOLD));
            printByGroupItem(GOLD);
        }
        if (getAmountByType(GEM) > 0) {
            System.out.printf("<Gem> $%s%n", getAmountByType(GEM));
            printByGroupItem(GEM);
        }
        if (getAmountByType(CASH) > 0) {
            System.out.printf("<Cash> $%s%n", getAmountByType(CASH));
            printByGroupItem(CASH);
        }
    }
}
