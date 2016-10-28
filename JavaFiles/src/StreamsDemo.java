import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Was too lazy to solve all problems, solved only 4 of 'em
 * Created by kulkarni_my on 10/28/2016.
 * enjoy
 */
class Fruit {
    private final String name;
    private final int calories;
    private final int price;
    private final String color;

    public Fruit(String name, int calories, int price, String color) {
        this.name = name;
        this.calories = calories;
        this.price = price;

        this.color = color;
    }

    private String getName() {
        return name;
    }

    private int getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return this.getName();
    }
}

class News {
    private final int newsId;
    private final String postedByUser;
    private final String commentByUser;
    private final String comment;

    public News(int newsId, String postedByUser, String commentByUser, String comment) {
        this.newsId = newsId;
        this.postedByUser = postedByUser;
        this.commentByUser = commentByUser;
        this.comment = comment;
    }

    private int getNewsId() {
        return newsId;
    }

    public String getPostedByUser() {
        return postedByUser;
    }

    public String getCommentByUser() {
        return commentByUser;
    }

    public String getComment() {
        return comment + " ";
    }

    public String toString() {
        return String.valueOf(this.getNewsId());
    }
}

// --Commented out by Inspection START (10/28/2016 11:58 AM):
//class Trader {
//    private final String name="";
//    private final String city="";
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCity() {
//        return city;
//    }
//}
// --Commented out by Inspection STOP (10/28/2016 11:58 AM)

// --Commented out by Inspection START (10/28/2016 11:58 AM):
//class Transaction {
//    private Trader trader;
//    private int year;
//    private int value;
//
//    public Trader getTrader() {
//        return trader;
//    }
//
//    public void setTrader(Trader trader) {
//        this.trader = trader;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//}
// --Commented out by Inspection STOP (10/28/2016 11:58 AM)

public class StreamsDemo {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Banana", 1827, 34, "Yellow"));
        fruits.add(new Fruit("Guava", 18, 34, "Green"));
        fruits.add(new Fruit("Mango", 88, 342, "Yellow"));
        fruits.add(new Fruit("Apple", 517, 334, "Red"));
        fruits.add(new Fruit("Apple2", 517, 123, "Red"));
        fruits.add(new Fruit("Apple3", 517, 43, "Red"));
        fruits.add(new Fruit("Apple4", 517, 88, "Red"));
        fruits.add(new Fruit("Kiwi", 27, 334, "Green"));

//        1.	Display the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories.
//            fruits
//                .stream()
//                .filter(Fruit::isLessThan100)
//                .forEach(System.out::println);


//        2.	Display color wise list of fruits.
//        Map<String, List<Fruit>> ans = fruits
//                .stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Fruit::getColor
//                        )
//                );
//        System.out.println(ans);


//        3.	Display only RED color fruits sorted as per their price in ascending order.
//        fruits
//                .stream()
//                .filter((Fruit f) -> f.getColor().equals("Red"))
//                .sorted((Fruit f1, Fruit f2) -> f1.getPrice() - f2.getPrice())
//                .forEach(System.out::println);

        List<News> newsList = new ArrayList<>();
        newsList.add(new News(1, "Tom", "Anand", "Very nice article on budget"));
        newsList.add(new News(2, "Ivan", "Bipin", "Good budget description"));
        newsList.add(new News(1, "Tom", "Narang", "How can you write such an article?"));
        newsList.add(new News(2, "Jerry", "Mitul", "I agree with you!!"));
        newsList.add(new News(2, "James", "Anand", "This seems to be paid news for glorifying the budget"));
        newsList.add(new News(3, "Sara", "Daji", "Good article"));

//        4.	Find out the newsId which has received maximum comments.
//        List<Long> ans= new ArrayList<>();
//        newsList
//                .stream()
//                .collect(Collectors.groupingBy(
//                        News::getNewsId, Collectors.counting()
//                ))
//                .entrySet()
//                .forEach((x) ->
//                    ans.add(x.getValue())
//                );
//
//        System.out.println(ans.stream().collect(Collectors.summarizingLong(Long::intValue)).getMax());

        StringBuilder sb = new StringBuilder();
        List<Long> ans = new ArrayList<>();
        newsList.forEach((x) -> sb.append(x.getComment()));
        Map<String, Long> collect = Stream.of(sb.toString())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect
                .entrySet()
                .forEach(x -> ans.add(x.getValue()));

        ans.forEach(System.out::println);
        System.out.println(ans.stream().collect(Collectors.summarizingLong(Long::intValue)).getMax());
    }
}
