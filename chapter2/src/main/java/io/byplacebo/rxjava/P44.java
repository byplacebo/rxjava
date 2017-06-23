package io.byplacebo.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by 1002225 on 2017. 6. 23..
 */
public class P44 {
    public static void main(String[] args) {

    }

    static <T> Observable<T> delayed(T x) {
        return Observable.create(
                subscriber -> {
                    Runnable r = () -> {
                        sleep(10, SECONDS);
                        if(!subscriber.isDisposed()) {
                            subscriber.onNext(x);
                            subscriber.onComplete();
                        }

                    };
                    final Thread thread = new Thread(r);
                    thread.start();
                    //subscriber.add(Subscriptions.create(thread::interrupt)); 해당 메소드가 없음
                }
        );
    }
    static void sleep(int timeout, TimeUnit unit) {
        try {
            unit.sleep(timeout);
        } catch (InterruptedException ignored) {

        }
    }
}
