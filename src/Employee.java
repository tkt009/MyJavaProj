public class Employee{
    String name;
    Integer salary;
    int age;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override public String toString ()
    {
        return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", age="
            + age + ", id=" + id + '}';
    }

    public Employee(String name, int salary, int id, int age){
        this.name = name;
        this.salary = salary;
        this.id = id;
        this.age = age;
    }

    public Employee(String name, int salary, int id){
        this.name = name;
        this.salary = salary;
        this.id = id;
    }


}