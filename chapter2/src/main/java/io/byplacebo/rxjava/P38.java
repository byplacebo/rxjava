package io.byplacebo.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by 1002225 on 2017. 6. 23..
 */
public class P38 {
    public static void main(String[] args) {
        log("Before");
        Observable
                .range(5, 3)
                .subscribe(P38::log);
        log("After");

        System.out.println("\n===========================\n");

        Observable<Integer> ints = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                log("Create");
                e.onNext(5);
                e.onNext(6);
                e.onNext(7);
                e.onComplete();
                log("Completed");
            }
        });

        log("Starting");
        ints.subscribe(i -> log("Element: " + i));
        log("Exit");
    }

    private static void log(Object msg) {
        System.out.println(
                Thread.currentThread().getName() + ": " + msg
        );
    }
}
