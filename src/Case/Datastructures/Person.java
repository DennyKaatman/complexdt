package Case.Datastructures;

public class Person implements Comparable<Person>{

    private String name;
    private int id;
    private int age;

    public Person(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " age:" + this.age;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.getAge());
    }
}
