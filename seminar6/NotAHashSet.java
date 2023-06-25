package GB_java.seminar6;

// Разработать программу, имитирующую поведение коллекции HashSet. 
// В программе содать метод add добавляющий элемент, метод toString 
// возвращающий строку с элементами множества и метод позволяющий 
// читать элементы по индексу. Формат данных Integer.

import java.util.ArrayList;
import java.util.List;

public class NotAHashSet {
    private List<Integer> elements = new ArrayList<>();

    public void add(Integer element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public String toString() {
        return elements.toString();
    }

    public Integer get(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }
}
