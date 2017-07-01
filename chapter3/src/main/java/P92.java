import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.interval;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P92 {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> red = interval(10, MILLISECONDS);
        Observable<Long> green = interval(11, MILLISECONDS);

        Observable.zip(
                red.timestamp(),
                green.timestamp(),
                (r, g) -> r.time() - g.time()).forEach(System.out::println);

        TimeUnit.SECONDS.sleep(3);


    }
}
