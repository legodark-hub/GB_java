package GB_java.seminar2;

// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class task1 {
    public static void main(String[] args) {
        String request = "select * from students where ";
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        StringBuilder newRequest = new StringBuilder(request);
        String[] pairs = filter.replace("{", "")
                .replace("}", "")
                .replace(" ", "")
                .split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replace("\"","");
            String value = keyValue[1];
            if (!value.equals("\"null\"")) {
                newRequest.append(key).append(" = ").append(value).append(" AND ");
            }
        }
        newRequest.setLength(newRequest.length()-5);
        request = newRequest.toString();
    }
}
