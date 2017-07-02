import io.reactivex.Observable;
import org.apache.commons.lang3.tuple.Pair;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.just;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by 1002225 on 2017. 7. 2..
 */
public class P108 {
    public static Observable<String> alice = speak("To be, or not to be: that is the question", 110);
    public static Observable<String> bob = speak("Though this be madness, yet there is methods in't", 90);
    public static  Observable<String> jane = speak("There are more things in Heaven and Earth, Horatio, than are dreamt of in your philosophy", 100);

    public static void main(String[] args) throws InterruptedException {

        Observable.merge(
                alice.map(w -> "Alice: "  + w),
                bob.map(w -> "Bob:   " + w),
                jane.map(w -> "Jane:  " + w)
                )
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);
        System.out.println("\n--------------------------\n");
        Observable.concat(
                alice.map(w -> "Alice: "  + w),
                bob.map(w -> "Bob:   " + w),
                jane.map(w -> "Jane:  " + w)
        )
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);
    }

    public static Observable<String> speak(String quote, long millisPerChar) {
        String[] tokens = quote.replaceAll("[:,]", "").split(" ");
        Observable<String> words = Observable.fromArray(tokens); // deprecated method: .from()
        Observable<Long> absoluteDelay = words
                .map(String::length)
                .map(len -> len * millisPerChar)
                .scan((total, current) -> total + current);
        return words
                .zipWith(absoluteDelay.startWith(0L), Pair::of)
                .flatMap(pair -> just(pair.getLeft())
                        .delay(pair.getRight(), MILLISECONDS));
    }
}
