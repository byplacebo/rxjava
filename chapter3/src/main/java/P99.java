import io.reactivex.Observable;

import java.math.BigInteger;

/**
 * Created by 1002225 on 2017. 7. 1..
 */
public class P99 {
    public static void main(String[] args) {
        Observable<BigInteger> factorials = Observable.range(2, 100)
                .scan(BigInteger.ONE, (big, cur) -> big.multiply(BigInteger.valueOf(cur)));

        factorials.subscribe(System.out::println);

    }
}
