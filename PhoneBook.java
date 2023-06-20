import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> book = new HashMap<>(6);

        for (int i = 0; i < book.size(); i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = scan.nextLine();
            System.out.println("Введите номер телефона: ");
            String number = scan.nextLine();
            if (!(book.containsKey(name))) {
                ArrayList<String> lst = new ArrayList<>();
                lst.add(number);
                book.put(name, lst);
                scan.close();
            } else {
                book.get(name).add(number);
                scan.close();
            }

        }

        ArrayList<Integer> sizes = new ArrayList<>(book.size());
        for (var item : book.entrySet()) {
            sizes.add(item.getValue().size());
        }
        sizes.sort(Comparator.reverseOrder());

        Map<String, ArrayList<String>> tempBook = new HashMap<>(book);

        for (int i : sizes) {
            Iterator<Map.Entry<String, ArrayList<String>>> iter = book.entrySet().iterator();
            while (iter.hasNext()) {
                if (iter.next().getValue().size() == i) {
                    System.out.printf("Имя: %s Номера телефонов: %s\n", iter.next().getKey(),
                            iter.next().getValue().toString().replaceAll(",", " "));
                    iter.remove();
                }
            }
        }

        book = tempBook;

    }
}
