import io.reactivex.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.just;

/**
 * Created by 1002225 on 2017. 7. 2..
 */
public class P114 {
    public static void main(String[] args) throws InterruptedException {
        Random rad = new Random();
        Observable<Observable<String>> quotes = just(
                P108.alice.map(w -> "Alice: " + w),
                P108.bob.map(w -> "Bob:   " + w),
                P108.jane.map(w -> "Jane:  " + w))
                .flatMap(innerObs -> just(innerObs).delay(rad.nextInt(5), TimeUnit.SECONDS));

        Observable
                .switchOnNext(quotes)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);
    }
}
