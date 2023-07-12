import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OraInt
{

    public static void main(String[] args){
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee("Tulasi", 8000, 12);
        Employee e2 = new Employee("Tuhin", 500, 13);
        Employee e3 = new Employee("Abhi", 400, 14);
        Employee e4 = new Employee("Lily", 1000, 15);
        Employee e5 = new Employee("Tushar", 3000, 16);


        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.stream().filter(emp->{
            return emp.salary > 2;
        }).map(emp-> emp.name)
    .forEach(emp->System.out.println(emp));
    }

}
