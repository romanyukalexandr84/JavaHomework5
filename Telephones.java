import java.util.*;

public class Telephones {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> book = new HashMap<>();
        int numberOfPhones = 6;
        for (int i = 0; i < numberOfPhones; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = scan.nextLine();
            System.out.println("Введите номер телефона: ");
            String number = scan.nextLine();
            if (!(book.containsKey(name))) {
                ArrayList<String> lst = new ArrayList<>();
                lst.add(number);
                book.put(name, lst);
            } else {
                book.get(name).add(number);
            }
        }

        ArrayList<Integer> sizes = new ArrayList<>(book.size());
        for (var item : book.entrySet()) {
            if (!sizes.contains(item.getValue().size())) {
                sizes.add(item.getValue().size());
            }
        }
        sizes.sort(Comparator.reverseOrder());

        for (int i : sizes) {
            for (var item : book.entrySet()) {
                if (item.getValue().size() == i) {
                    System.out.printf("Имя: %s Номера телефонов: %s\n", item.getKey(), item.getValue());
                }
            }
        }
    }
}