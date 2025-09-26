package Chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 */

public class DataStore {

    static List<Integer> randomNumbers(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int count = random.nextInt(3, 20);
        for(int i = 0; i < count; i++){
            list.add(random.nextInt(210, 350));
        }
        return list;
    }

    static Stream<String> cities(){
        return Stream.of("Midrand", "Pretoria", "Centurion", "RustenBurg", "Soccer");
    }
}
