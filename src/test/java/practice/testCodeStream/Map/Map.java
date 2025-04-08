package practice.testCodeStream.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class Map {
    List<HashMap<String, Object>> people = Arrays.asList(
            new HashMap<String, Object>() {{
                put("name", "PARK");
                put("age", 23);
            }},
            new HashMap<String, Object>() {{
                put("name", "LONE");
                put("age", 25);
            }},
            new HashMap<String, Object>() {{
                put("name", "JONE");
                put("age", 11);
            }},
            new HashMap<String, Object>() {{
                put("name", "KIM");
                put("age", 15);
            }},
            new HashMap<String, Object>() {{
                put("name", "LEE");
                put("age", 30);
            }}
    );


    @DisplayName("이름만 추출하기")
    @Test
    void nameOutPut() {
        people.stream()
                .map(v -> v.get("name"))
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("나이만 추출하기")
    @Test
    void ageOutPut() {
        people.stream()
                .map(v -> v.get("age"))
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("이름 3글자 이하만 뽑기")
    @Test
    void lengthThreeName() {
        people.stream()
                .map(v -> v.get("name"))
                .filter(name -> name instanceof String &&((String) name).length() <= 3)
                .toList()
                .forEach(System.out::println);

    }
    @DisplayName("20대만 뽑기")
    @Test
    void lengthThreeAge() {
        people.stream()
                .filter(person -> person.get("age") instanceof Integer
                && (Integer) person.get("age") >= 20
                && (Integer) person.get("age") < 30)
                .map(v -> v.get("name"))
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("이름 - 나이 자기소개하기")
    @Test
    void nameAndAge() {
        people.stream()
                .map(p -> "My Nmae is " +p.get("name") + " and my age is " + p.get("age"))
                .toList()
                .forEach(System.out::println);
    }
}
