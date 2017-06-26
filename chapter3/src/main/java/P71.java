import io.reactivex.Observable;

/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P71 {
    public static void main(String[] args) {
        Observable
                .just(8, 9, 10)
                .doOnNext(i -> System.out.println("A: " + i))
                .filter(i -> i % 3 > 0)
                .doOnNext(i -> System.out.println("B: " + i))
                .map(i -> "#" + i * 10)
                .doOnNext(s -> System.out.println("C: " + s))
                .filter(s -> s.length() < 4)
                //.doOnNext(s -> System.out.println("D: " + s)); 구독(subscribe) 하지 않으면 스트림이 시작되지 않음
                .subscribe(s -> System.out.println("D: " + s));
    }
}
