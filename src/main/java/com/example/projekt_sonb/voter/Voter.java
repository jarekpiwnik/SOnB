package com.example.projekt_sonb.voter;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Voter {
    public static Integer vote(Stream<Integer> integerStream) {
        Optional<List<Integer>> max =
                integerStream.collect(Collectors.groupingBy(e -> e)).values().stream()
                        .max(Comparator.comparing(List::size));

        if (max.isPresent()) {
            List<Integer> Integers = max.get();
            if (Integers.size() > 3) {
                if (Integers.get(0) == 0)
                    return null;
                else {
                    return Integers.get(0);
                }
            }
        }
        return null;
    }

}
