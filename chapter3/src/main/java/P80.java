import io.reactivex.Observable;

import static io.reactivex.Observable.timer;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P80 {
    public static void main(String[] args) throws InterruptedException {
        Observable
                .just("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipscing", "elit")
                .delay(word -> timer(word.length(), SECONDS))
                .subscribe(System.out::println);
        SECONDS.sleep(15);

        System.out.println("\n--------------------------------------------\n");

        Observable
                .just("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipscing", "elit")
                .flatMap(word -> timer(word.length(), SECONDS).map(x -> word))
                .subscribe(System.out::println);
        SECONDS.sleep(15);
    }
}
