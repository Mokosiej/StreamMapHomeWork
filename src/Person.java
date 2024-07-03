import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    private String name;
    private Person father;
    private Person mother;

    public Person(String name, Person father, Person mother) {
        this.name = name;
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Person john = new Person("John", null, null);
        Person mary = new Person("Mary", null, null);
        Person elizabeth = new Person("Elizabeth", null, null);
        Person alexander = new Person("Alexander", null, null);


        Person child1 = new Person("Anna", john, mary);
        Person child2 = new Person("Peter", alexander, elizabeth);
        Person child3 = new Person("Chris", john, elizabeth);


        List<Person> people = List.of(child1, child2, child3);


        List<Person> parentsWithLongNames = people.stream()
                .flatMap(person -> Stream.of(person.getFather(), person.getMother()))
                .filter(parent -> parent != null && parent.getName().length() > 6)
                .distinct()
                .collect(Collectors.toList());


        System.out.println("Мамы и папы с именем длиннее 6 букв:");
        parentsWithLongNames.forEach(System.out::println);
    }
}

