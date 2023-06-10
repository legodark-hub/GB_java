package GB_java.seminar2;

// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class task2 {
    public static void main(String[] args) {
        String json = "{\"\u0444\u0430\u043C\u0438\u043B\u0438\u044F\":\"\u0418\u0432\u0430\u043D\u043E\u0432\",\"\u043E\u0446\u0435\u043D\u043A\u0430\":\"5\",\"\u043F\u0440\u0435\u0434\u043C\u0435\u0442\":\"\u041C\u0430\u0442\u0435\u043C\u0430\u0442\u0438\u043A\u0430\"},{\"\u0444\u0430\u043C\u0438\u043B\u0438\u044F\":\"\u041F\u0435\u0442\u0440\u043E\u0432\u0430\",\"\u043E\u0446\u0435\u043D\u043A\u0430\":\"4\",\"\u043F\u0440\u0435\u0434\u043C\u0435\u0442\":\"\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0442\u0438\u043A\u0430\"},{\"\u0444\u0430\u043C\u0438\u043B\u0438\u044F\":\"\u041A\u0440\u0430\u0441\u043D\u043E\u0432\",\"\u043E\u0446\u0435\u043D\u043A\u0430\":\"5\",\"\u043F\u0440\u0435\u0434\u043C\u0435\u0442\":\"\u0424\u0438\u0437\u0438\u043A\u0430\"}";

        System.out.println(stringFromJSON(json));
    }

    static String stringFromJSON(String json) {
        StringBuilder buildedString = new StringBuilder();
        String[] separated = json.replace("{", "")
                .replace(" ", "")
                .replace("\"", "")
                .replace("фамилия", "")
                .replace("оценка", "")
                .replace("предмет", "")
                .replace(":", "")
                .split("},");
        for (String string : separated) {
            String[] data = string.split(",");
            String lastName = data[0];
            String score = data[1];
            String subject = data[2];
            buildedString.append("Студент ")
                    .append(lastName)
                    .append(" получил ")
                    .append(score)
                    .append(" по предмету ")
                    .append(subject)
                    .append(".\n");
        }
        return (buildedString.toString().replace("}", ""));
    }
}
