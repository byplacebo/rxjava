import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.interval;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P93 {
    public static void main(String[] args) throws InterruptedException {

        Observable.combineLatest(
                interval(17, MILLISECONDS).map(x -> "S" + x),
                interval(10, MILLISECONDS).map(x -> "F" + x),
                (s, f) -> f + ":" + s
        ).forEach(System.out::println);

        TimeUnit.SECONDS.sleep(3);
    }
}
