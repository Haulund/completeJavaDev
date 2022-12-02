public class Main {
  
    public static void main(String[] args) {
        Employee zack = new Employee("Zack", "programmer");
        Employee gio = new Employee("Gio", "Analyst");
        Employee thomas = new Employee("Thomas", "specialist");
        System.out.println(Employee.getHiredCount());
    }
  
}
