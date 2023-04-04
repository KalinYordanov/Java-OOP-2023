package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList();

        randomArrayList.add(13);
        randomArrayList.add(33);
        randomArrayList.add(123);
        randomArrayList.add(23);

        System.out.println(randomArrayList.getRandomElement());

    }
}
