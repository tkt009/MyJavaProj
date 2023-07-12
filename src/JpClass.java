import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JpClass
{

    public static void main(String[] args){
        Employee e1 = new Employee("Tulasi", 8000, 12);
        Employee e2 = new Employee("Tuhin", 500, 13);
        Employee e3 = new Employee("Abhi", 400, 14);
        Employee e4 = new Employee("Lily", 1000, 15);
        Employee e5 = new Employee("Tushar", 3000, 16);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);

//        List<Employee> finalList = list.stream().filter(e->e.name.startsWith("T"))
//            .sorted((emp1,emp2)->emp2.salary.compareTo(emp1.salary))
//            .collect(Collectors.toList());
        list.stream().filter(e->e.name.startsWith("T"))
            .sorted((emp1,emp2)->emp2.salary.compareTo(emp1.salary))
            .forEach(e->{
                System.out.println("Employee name: "+e.name+ " Salary: "+e.salary);
            });



//        for (Employee e:finalList
//             ) {
//            System.out.println("Employee name: "+e.name+ " Salary: "+e.salary);
//        }
    }

}


