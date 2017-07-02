import io.reactivex.Observable;

/**
 * Created by 1002225 on 2017. 7. 2..
 */
public class P107 {
    public static void main(String[] args) {
        Observable<Integer> numbers = Observable.range(1, 10);

        numbers.all(x -> x != 4).subscribe(System.out::print);
        System.out.println("\n--------------------");
        numbers.contains(4).subscribe(System.out::print);
        //numbers.exists(x -> x == 4); deprecated on 2.x
    }
}
