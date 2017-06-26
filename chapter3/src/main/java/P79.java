import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P79 {
    public static void main(String[] args) {
        final Observable<Integer> delay = Observable.just(1, 2, 3).delay(1, TimeUnit.SECONDS);

        final Observable<Observable<Integer>> map = Observable.timer(1, TimeUnit.SECONDS).map(i -> Observable.just(1, 2, 3));

        final Observable<Integer> integerObservable = Observable.timer(1, TimeUnit.SECONDS).flatMap(i -> Observable.just(1, 2, 3));
    }
}
