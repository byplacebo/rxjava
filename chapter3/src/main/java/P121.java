import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import org.apache.commons.lang3.tuple.Pair;

public class P121 {
    public static void main(String[] args) {
        alphabet.compose(odd()).subscribe(System.out::println);
        alphabet.compose(odd()).subscribe(System.out::println);
    }

    private static <T> ObservableTransformer<T, T> odd() { // Observable.Transformer
        Observable<Boolean> trueFalse = Observable.just(true, false).repeat();
        return upstream -> upstream
                .zipWith(trueFalse, Pair::of)
                .filter(Pair::getRight)
                .map(Pair::getLeft);
    }

    private static Observable<Character> alphabet =
            Observable.range(0, 'Z' - 'A' + 1)
                    .map(c -> (char) ('A' + c));
}
