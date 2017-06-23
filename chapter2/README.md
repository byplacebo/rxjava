
## P38
Observable.OnSubscribe is deprecated in rxjava2

### [Release Note](https://github.com/ReactiveX/RxJava/releases/tag/v1.2.7)
> Deprecation of create(OnSubscribe)
>   
> The method started out in RxJava 0.x as a simple and direct way for implementing custom operators because 0.x had a much simpler protocol requirements. Over the years, as the Observable protocol evolved and create became a powerful and complicated extension point of RxJava that required users to implement the Observable protocol, including cancellation and backpressure manually.
>   
> Unfortunately, guides, blogs, StackOverflow answers and mere typical user behavior still leads to this create method and lots of confusion, unstoppable sequences and MissingBackpressureException. We tried remedying the situation by introducing fromEmitter with limited discoverability success.
> 
> Therefore, as of 1.2.7 the create() method is now deprecated (but won't be removed due to binary compatibility requirements). In addition fromEmitter has been deprecate-renamed to create(Action1, BackpressureMode) and the experimental-marked fromEmitter itself will be removed in 1.3.0.
>   
> Since the functionality of create() was useful for writing (custom) operators inside and outside of RxJava, the new unsafeCreate(OnSubscribe) method was introduced as the replacement.
>
> The new create() and unsafeCreate() methods will be fast-tracked to become standard in 1.3.0.

#### Modified Sample Code in rxjava2
```java
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
```

