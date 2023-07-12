import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Imerative
{

    public static void main(String[] args) {
        List<Employee> li = new ArrayList<Employee>();
        li.add(new Employee("n1", 100, 1, 25));
        li.add(new Employee("n2", 100, 2, 25));
        li.add(new Employee("n3", 100, 3, 23));
        li.add(new Employee("n4", 100, 4, 23));
        li.add(new Employee("n5", 100, 5, 16));
        li.add(new Employee("n6", 100, 6, 16));

        List<Employee> l2 = new ArrayList<Employee>();
        l2.add(new Employee("john", 100, 1, 25));
        l2.add(new Employee("john", 100, 2, 25));
        l2.add(new Employee("sohan", 100, 3, 23));
        l2.add(new Employee("mohan", 100, 4, 23));
        l2.add(new Employee("mohan", 100, 5, 16));
        l2.add(new Employee("sohan", 100, 6, 16));

        List<Employee> liFiltered = li.stream().filter(emp -> emp.age > 18).limit(2)
            .collect(Collectors.toList());
        System.out.println("filtered based on age");
        liFiltered.forEach(System.out::println);

        System.out.println("Min, max:-");
        li.stream().sorted((i,j)-> new Integer(j.id).compareTo(new Integer(i.id))).forEach(System.out::println);

        System.out.println("Min:-");
        System.out.println(li.stream().min((i,j)-> new Integer(i.id).compareTo(new Integer(j.id))));

        System.out.println("Max:-");
        System.out.println(li.stream().max((i,j)-> new Integer(i.id).compareTo(new Integer(j.id))));

        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        int any = Arrays.stream(a).filter(n->n<10).findAny().get();
        Predicate<Integer> predicate = n-> n>10;
        int first = Arrays.stream(a).filter(predicate).findAny().orElse(100);
        System.out.println("any: "+any);
        System.out.println("first: "+first);

        System.out.println("max age: "+li.stream().mapToInt(e->e.age).max().getAsInt());

        System.out.println("average age: "+li.stream().mapToInt(Employee::getAge).average().getAsDouble());

        int sum = li.stream().mapToInt(Employee::getAge).sum();
        System.out.println("sum ages: "+sum);

        DoubleSummaryStatistics statc = li.stream().mapToDouble(Employee::getAge).summaryStatistics();
        System.out.println(statc);

        //grouping
        li.stream().collect(Collectors.groupingBy(Employee::getAge))
            .forEach((age, emps)->{
                System.out.println(age);
                emps.forEach(System.out::println);
            });
        li.stream().collect(Collectors.groupingBy(Employee::getAge)).forEach((age,emps)->{
            System.out.println(emps.size() + " : " + age);
        });

        li.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()))
            .forEach((age,count)->{
                System.out.println(count + " : "+age);
        });

        l2.stream().map(Employee::getName)
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .forEach((nam,ct)->{
                System.out.println(nam + " : "+ct);
            });

        System.out.println(l2.stream().map(Employee::getName).collect(Collectors.joining(",")));

    }
}
