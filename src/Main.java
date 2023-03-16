import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // first
        List<Integer> list = List.of(5,6,8,9,7,1,5);
        System.out.println(multiplyToTwo(list));
        // Third
        List<Person> people = new ArrayList<>();
        people.add(new Person("Yernur",18));
        people.add(new Person("Kate",25));
        people.add(new Person("Jake",12));
        people.add(new Person("Hammilton",40));
        System.out.println(sortByAge(people));
        // Second
        List<String> strings = List.of("Alua","Myamoto","Kate","Alina","Musashi","Anya","Messi");
        System.out.println(sortByA(strings));
        // Fourth
        List<String> words = List.of("Kate","Anna","Kyoto","Kate","Lola","Jake","Kyoto");
        System.out.println(distinctTest(words));
        // fifth
        List<Student> students = new ArrayList<>();
        students.add(new Student("Yernur",4));
        students.add(new Student("Bally",3));
        students.add(new Student("Hooks",4));
        students.add(new Student("Gates",2));
        students.add(new Student("Sasha",3));
        System.out.println(avgGrade(students));
        // 6 task
        List<String> stringList = List.of("Kate","Sasha","Mark");
        List<Character> chars = Main.uniqueAndChar(stringList);
        System.out.println(chars);


        /*int n = new Scanner(System.in).nextInt();
        System.out.println(findRadius(n ,radius));
        List<Integer> nums = List.of(47,4,58,6767,55,56,4,45,532,5);
        Map<Integer , Integer> map = new HashMap<>();
        for(int c : nums)
            map.compute(c , (k,v) -> (v == null) ? 1 : ++v);*/
    }
    static List<Character> convertList(char[] arr){
        List<Character> chars = new ArrayList<>();
        for (Character ch: arr){
            chars.add(ch);
        }
        return chars;
    }

    static List<Integer> multiplyToTwo(List<Integer> list){
        return list.stream().map(el->el*2).toList();
    }
   static Predicate<Person> adult = (person) -> person.age > 18;
    static List<Person> sortByAge(List<Person> people){
        return people.stream().filter(adult).toList();
    }
    static List<String> sortByA(List<String> strings){
        return strings.stream().filter(el -> el.startsWith("A")).toList();
    }
    static List<String> distinctTest(List<String> list){
        return list.stream().distinct().toList();
    }
    static double avgGrade(List<Student> students){
        return (double) students.stream().mapToInt(std->std.grade).average().orElse(0.0);
    }
    static List<Character> uniqueAndChar(List<String> strings){
        return strings.stream().map(String::toCharArray).map(Main::convertList).flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }


    static List<String> distinctTest2(List<String> list){
        return new ArrayList<>(new HashSet<>(list));
    }
    static Function<Integer , Double> radius = (n) -> 3.14 * n;
    static Double findRadius(int  n , Function<Integer , Double> function ){
        System.out.println("n: " + n);
        return function.apply(n);
    }
}