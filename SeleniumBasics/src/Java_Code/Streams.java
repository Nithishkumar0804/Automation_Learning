package Java_Code;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abishek");
        names.add("Nithish");
        names.add("Arun");
        names.add("abijith");
        long c = names.stream().filter(s -> s.startsWith("A")).count();
        //System.out.println(c);
        long d = names.parallelStream().filter(s -> s.length() > 3).count();
        //System.out.println(d);
        //Stream.of("nithish","nithin").filter(s->s.contains("ni")).limit(3).forEach(s->System.out.println(s));


        //Stream.of("Abijeet","Don","ilakiya","karunya").filter(s->s.endsWith("ya")).map(s->s.toUpperCase()).forEach(System.out::println);
        //System.out.println("Sorted:");
        //Stream.of("Abijeet","Don","ilakiya","karunya","Adam").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(System.out::println);

        String arr[] = {"Nithishkumar", "jaya", "kathir", "sakthivel"};
        List<String> arrlist = Arrays.asList(arr);
        Stream<String> newStream = Stream.concat(names.stream(), arrlist.stream());

        boolean flag = newStream.anyMatch(i -> i.equalsIgnoreCase("jaya"));
        Assert.assertTrue(flag);

        List<String> newList = Stream.of("Abijeet", "Don", "ilakiya", "karunya", "Adam").filter(s -> s.startsWith("A")).distinct().collect(Collectors.toList());
        System.out.println(newList.get(0));

    }

}
