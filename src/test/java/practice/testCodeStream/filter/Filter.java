package practice.testCodeStream.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Filter {

    List<String> list = Arrays.asList("Park","Kim","Woo","Han","Cho","Lee","Yo","Seees","Ao");

    @DisplayName("글자수가 3자리 미만 출력")
    @Test
    void twoNamesLength() {
        list.stream()
                .filter(v -> v.length() < 3)
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("2번째 글자가 a인 이름 출력")
    @Test
    void twoNamesA() {
        list.stream()
                .filter(v -> v.substring(1,2).equals("a"))
                .toList()
                .forEach(System.out::println);
    }
    @DisplayName("이름에 o가 들어간 이름 출력")
    @Test
    void namesContainToO() {
        list.stream()
                .filter(v -> v.toLowerCase().contains("o"))
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("첫글자가 P 또는 마지막 글자가 s인 이름 출력")
    @Test
    void firstNamePOrLastNameS() {
        list.stream()
                .filter(v -> v.toLowerCase().startsWith("p") || v.toLowerCase().endsWith("s"))
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("모음으로 시작하는 이름 출력")
    @Test
    void vowelPattern() {
        list.stream()
                // Y는 직접 추가해야 모음 취급 받음 AEIOUaeiou 쓸 시
                .filter(v -> v.matches("^[AEIOUYaeiouy].*"))
                .toList()
                .forEach(System.out::println);
    }
}
