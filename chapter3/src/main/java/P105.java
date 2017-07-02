import io.reactivex.Observable;

/**
 * Created by 1002225 on 2017. 7. 2..
 */
public class P105 {
    public static void main(String[] args) {
        Observable.range(1,5).take(3).subscribe(System.out::println);
        System.out.println("\n---------------");
        Observable.range(1,5).skip(3).subscribe(System.out::println);
        System.out.println("\n---------------");
        Observable.range(1,5).take(5).subscribe(System.out::println);
        System.out.println("---------------");
        System.out.println("---------------");
        Observable.range(1,5).takeLast(2).subscribe(System.out::println);
        System.out.println("\n---------------");
        Observable.range(1,5).skipLast(2).subscribe(System.out::println);
    }
}
