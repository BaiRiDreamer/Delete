import java.util.Map;
import java.util.TreeMap;

public class EmployeeManagementSystem {
    private Map<String, Integer> employees;

    public EmployeeManagementSystem() {
        employees = new TreeMap<>(); // 使用TreeMap自动按键（姓名）排序
    }

    public void addEmployee(String name, int age) {
        if (employees.containsKey(name)) {
            System.out.println("Employee " + name + " already exists. Updating age.");
        } else {
            System.out.println("Employee " + name + " added with age " + age + ".");
        }
        employees.put(name, age);
    }

    public void deleteEmployee(String name) {
        if (employees.containsKey(name)) {
            employees.remove(name);
            System.out.println("Employee " + name + " deleted.");
        } else {
            System.out.println("Employee " + name + " not found.");
        }
    }

    public void printEmployees() {
        System.out.println("All employees:");
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // 1. 添加三名员工 A, B 和 C
        system.addEmployee("A", 30);
        system.addEmployee("B", 25);
        system.addEmployee("C", 35);

        // 2. 删除员工 B
        system.deleteEmployee("B");

        // 3. 添加两名员工 A 和 D
        system.addEmployee("A", 30); // 这应该不会添加新的，因为A已经存在
        system.addEmployee("D", 45);

        // 4. 打印所有员工，应显示 A, C, D
        system.printEmployees();
    }
}
