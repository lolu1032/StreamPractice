package practice.testCodeStream.정렬;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.Collator;
import java.util.*;


@SpringBootTest
public class Stream {

    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Chali", "Bob", "Eva", "David", "kim", "kim","KIM","PARK"));

    @DisplayName("알파벳순으로 정렬(오름차순)")
    @Test
    void ascending() {
        names.add("kim");

        names.stream()
                .sorted()
                .toList()
                .forEach(name -> System.out.printf("%s ", name));
    }

    @DisplayName("알파벳순으로 정렬(내림차순)")
    @Test
    void descending() {
        names.stream()
                .sorted(Comparator.reverseOrder())
                .toList()
                .forEach(name -> System.out.printf("%s ", name));
    }

    @DisplayName("Collections 오름차순 정렬")
    @Test
    void collectionsAscending() {
        Collections.sort(names);

        names.forEach(System.out::println);
    }

    @DisplayName("중복제거 정렬")
    @Test
    void removeDuplicationAscending() {
        names.stream()
                .distinct()
                .sorted()
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("글자 길이를 통한 정렬 (오름차순)")
    @Test
    void lengthAscending() {
        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .distinct()
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("글자 길이를 통한 정렬(내림차순)")
    @Test
    void lengthDescending() {
        names.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.reverseOrder()))
                .distinct()
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("모든 값 대문자로 만들어서 비교(오름차순)")
    @Test
    void UpperCaseAscending() {
        names.stream()
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("소문자로 변경 후 정렬(오름차순)")
    @Test
    void LowerCaseDescending() {
        names.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("글자 수대로 정렬 후 길이 출력")
    @Test
    void lengthNumber() {
        names.stream()
                .map(String::length)
                .sorted()
                .toList()
                .forEach(System.out::println);
    }

    @DisplayName("Locale 기반 정렬 (한국어 우선)")
    @Test
    void localeSort() {
        names.stream()
                .sorted(Collator.getInstance(Locale.KOREAN))
                .forEach(System.out::println);
    }

}
