## P80
it's not different between delay() and flatMap()
 
#### Source Code 1 
```java
Observable
        .just("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipscing", "elit")
        .delay(word -> timer(word.length(), SECONDS))
        .subscribe(System.out::println);
SECONDS.sleep(15);
```

#### Result 1
```
 sit
 amet
 elit
 dolor
 Lorem
 ipsum
 adipscing
 consectetur
 ```
 
#### Source Code 2
 ```java
Observable
        .just("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipscing", "elit")
        .flatMap(word -> timer(word.length(), SECONDS).map(x -> word))
        .subscribe(System.out::println);
SECONDS.sleep(15);
```
 
#### Result 2
 ```
 sit
 amet
 elit
 Lorem
 ipsum
 dolor
 adipscing
 consectetur
 ```