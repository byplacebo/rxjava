import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.interval;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P95 {
    public static void main(String[] args) throws InterruptedException {
        // some of slow up stream is trashed, cause's that fast stream was not published first event even after started slow stream
        Observable<String> fast = interval(10, MILLISECONDS)
                .map(x -> "F" + x)
                .delay(100, MILLISECONDS);

        Observable<String> slow = interval(17, MILLISECONDS).map(x -> "S" + x);

        slow
                .withLatestFrom(fast, (s, f) -> s +":" + f)
                .forEach(System.out::println);

        TimeUnit.SECONDS.sleep(3);

        // Correct Case
//        Observable<String> fast = interval(10, MILLISECONDS)
//                .map(x -> "F" + x)
//                .delay(100, MILLISECONDS)
//                .startWith("FX");
//
//        Observable<String> slow = interval(17, MILLISECONDS).map(x -> "S" + x);
//
//        slow
//                .withLatestFrom(fast, (s, f) -> s +":" + f)
//                .forEach(System.out::println);
//
//        TimeUnit.SECONDS.sleep(3);

    }
}
