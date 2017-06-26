import io.reactivex.Observable;

import java.time.DayOfWeek;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.empty;
import static io.reactivex.Observable.just;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P81 {
    public static void main(String[] args) throws InterruptedException {
        just(10L, 1L)
                .flatMap(x ->
                        just(x).delay(x, TimeUnit.SECONDS))
                .subscribe(System.out::println);

        Observable.just(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
                .flatMap(P81::loadRecordsFor).subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(30);
    }

    private static Observable<String> loadRecordsFor(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case SUNDAY:
                return Observable.interval(90, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> "Sun-" + i);
            case MONDAY:
                return Observable.interval(65, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> "Mon-" + i);
            default:
                break;

        }
        return empty();
    }
}
