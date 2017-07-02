import io.reactivex.Observable;

/**
 * Created by 1002225 on 2017. 7. 2..
 */
public class P106 {
    public static void main(String[] args) {
        Observable.range(1, 5).takeUntil(x -> x ==3).subscribe(System.out::println);
        System.out.println("\n------------------\n");
        Observable.range(1, 5).takeWhile(x -> x !=3).subscribe(System.out::println);
    }
}
