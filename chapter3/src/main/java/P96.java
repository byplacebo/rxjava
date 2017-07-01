import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * Created by 1002225 on 2017. 7. 1..
 */
public class P96 {
    public static void main(String[] args) {
        // TODO 예제코드 재작성 필요
    }

    static Observable<String> stream(final int initialDelay, final int interval, String name) {
        return Observable.interval(initialDelay, interval, TimeUnit.MICROSECONDS)
                .map(x -> name + x)
                .doOnSubscribe(d -> System.out.println("Subscribe to " + name))
                .doOnTerminate(() -> System.out.println("Unsubscribe to " + name));
    }
}
