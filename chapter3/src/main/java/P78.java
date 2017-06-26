import io.reactivex.Observable;

import static io.reactivex.Observable.empty;
import static io.reactivex.Observable.just;


/**
 * Created by 1002225 on 2017. 6. 27..
 */
public class P78 {
    public static void main(String[] args) {
        final Observable<Character> map = just('A', 'b', 'C')
                .map(Character::toLowerCase);

        final Observable<Observable<Sound>> map1 = just('A', 'b', 'C')
                .map(Character::toLowerCase)
                .map(P78::toMorseCode);

        final Observable<Sound> soundObservable = just('A', 'b', 'C')
                .map(Character::toLowerCase)
                .flatMap(P78::toMorseCode);

    }

    static Observable<Sound> toMorseCode(char ch) {
        switch (ch) {
            case 'a':
                return just(Sound.DI, Sound.DAH);
            case 'b':
                return just(Sound.DAH, Sound.DI, Sound.DI, Sound.DI);
            case 'c':
                return just(Sound.DAH, Sound.DI, Sound.DAH, Sound.DI);
            default:
                return empty();
        }
    }

    public enum Sound {DI, DAH}
}
