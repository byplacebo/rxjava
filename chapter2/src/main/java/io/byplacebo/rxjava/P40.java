package io.byplacebo.rxjava;

import io.reactivex.Observable;

/**
 * Created by 1002225 on 2017. 6. 23..
 */
public class P40 {
    private static void log(Object msg) {
        System.out.println(
                Thread.currentThread().getName() + ": " + msg
        );
    }

    public static void main(String[] args) {
        just(10).subscribe(P40::log);

        System.out.println("\n----------------------------\n");

        Observable<Integer> ints = Observable.create(subscriber -> {
            log("Create");
            subscriber.onNext(42);
            subscriber.onComplete();
        });

        log("Starting");
        ints.subscribe(i -> log("Element A: " + i));
        ints.subscribe(i -> log("Element B: " + i));
        log("Exit");
        System.out.println("\n----------------------------\n");


        Observable<Object> intsOnCache = Observable.create(subscriber -> {
            log("Create");
            subscriber.onNext(42);
            subscriber.onComplete();
        })
                .cache();

        log("Starting");
        intsOnCache.subscribe(i -> log("Element A: " + i));
        intsOnCache.subscribe(i -> log("Element B: " + i));
        log("Exit");
    }

    static <T> Observable<T> just(T x) {
        return Observable.create(subscribe -> {
            subscribe.onNext(x);
            subscribe.onComplete();
        });
    }

    static <T> Observable<T> never(T x) {
        return Observable.create(subscribe -> {
            try {
                subscribe.onComplete();
            } catch (Exception ignored) {
            }
        });
    }

    static <T> Observable<T> empty(T x) {
        return Observable.create(subscribe -> {
            try {
                subscribe.onComplete();
            } catch (Exception e) {
                subscribe.onError(e);
            }
        });
    }

    static <T extends Integer> Observable<T> range(T x, T count) {
        return Observable.create(subscribe -> {
            for (int i = 0; i < count.intValue(); i++) {
                //subscribe.onNext((T)(x + i);
                subscribe.onNext(x); // how to?
            }
            subscribe.onComplete();
        });
    }
}
