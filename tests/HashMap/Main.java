import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("Jerry", 182983);
        empIds.put("Carl", 782324);
        empIds.put("George", 238974);

        System.out.println(empIds);

        System.out.println(empIds.get("Carl"));

        System.out.println(empIds.containsKey("Juliette"));

        System.out.println(empIds.containsValue(238974));

        empIds.put("John", 98765);
        System.out.println(empIds);

        empIds.replace("Kramer", 777);
        System.out.println(empIds);

        empIds.putIfAbsent("Steve", 222);
        System.out.println(empIds);

        empIds.remove("Steve");
        System.out.println(empIds);
    }
}
