import io.reactivex.Observable;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P89 {
    public static void main(String[] args) {
        Observable<Integer> oneToEight = Observable.range(1, 8);
        Observable<String> ranks = oneToEight.map(Object::toString);
        Observable<String> files = oneToEight
                .map(x -> 'a' + x-1)
                .map(ascii -> (char)ascii.intValue())
                .map(ch -> Character.toString(ch));

        Observable squares = files.flatMap(file -> ranks.map(rank -> file + rank));
        squares.subscribe(System.out::println);
    }
}
