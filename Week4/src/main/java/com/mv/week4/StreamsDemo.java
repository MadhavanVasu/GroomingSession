package com.mv.week4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    // Stream.empty() to avoid returning null for empty list.
    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public static void main(String[] args) {

        // In Java, a Stream is a powerful and expressive API introduced in Java 8
        // that provides a functional programming approach for processing collections of data.
        // It allows for efficient and concise manipulation of data in a declarative manner,
        // without the need for explicit iteration or loops.

        // Streams in Java are immutable, which means that once a stream is created,
        // its elements and their order cannot be changed.
        // Any operation performed on a stream creates a new stream, leaving the original stream unchanged.

        // Creating an empty stream
        Stream<String> streamEmpty = Stream.empty();
        System.out.println(streamEmpty.count());

        // Can create stream for any type of Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        System.out.println(streamOfCollection);

        // Can create stream from an array
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        System.out.println(streamOfArray);
        String[] strArry = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(strArry);
        System.out.println(streamOfArrayFull);

        // Can also create stream for part of an array.
        Stream<String> streamOfArrayPart = Arrays.stream(strArry, 1, 3);
        System.out.println(streamOfArrayPart);

        // Can create stream using builder()
        // When builder is used, the desired type should be additionally specified in the right part of the statement
        // otherwise the build() method will create an instance of the Stream<Object>
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();
        System.out.println(streamBuilder);
        Stream.Builder<Integer> sBuilder = Stream.builder();
        for (int i = 0; i < 5; i++)
            sBuilder.add(i);
        Stream<Integer> streamFromBuilder = sBuilder.build();
        streamBuilder.forEach(System.out::println);

        // Intermediate operations

        // filter(Predicate<T> predicate)
        // This intermediate operation returns a new stream
        // that contains only the elements that satisfy the given predicate.
        // The predicate is a functional interface that takes an element of the stream
        // and returns a boolean value.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> evenStream = numbers.stream().filter((a) -> a % 2 == 0);
        evenStream.forEach(System.out::println);

        // map(Function<T, R> mapper)
        // This intermediate operation applies the given function to each element of the stream
        // and returns a new stream that contains the results.
        // The function is a functional interface that takes an element of the stream
        // and returns a new element.
        System.out.println("map() :");
        Stream<Integer> perfectSquareStream = numbers.stream().map((a) -> a * a);
        perfectSquareStream.forEach(System.out::println);
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        // Convert names to uppercase
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseNames);

        // flatMap()
        // This intermediate operation flattens the stream of streams into a single stream.
        // It takes a function (Function<T, Stream<R>>) as a parameter,
        // which represents a mapping function that takes an element of the stream
        // and returns a stream of new elements.
        System.out.println("flatMap() :");
        List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9));
        // Flatten the nested list of numbers
        List<Integer> flattenedNumbers = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedNumbers);

        // distinct()
        // The distinct() method returns a new stream consisting of distinct elements
        // based on their natural order or the order imposed by a provided comparator.
        System.out.println("-------------------------------------------");
        System.out.println("distinct() :");
        List<Integer> duplicateNumbers = Arrays.asList(7, 7, 3, 2, 1, 3, 4, 2, 1, 5);
        List<Integer> distinctNumbers = duplicateNumbers.stream()
                .distinct() // Filter out duplicate elements
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        // sorted()
        // The sorted() method is used to sort the elements of a stream based on their natural order
        // or using a custom comparator. It returns a new stream that contains the sorted elements.
        System.out.println("-------------------------------------------");
        System.out.println("sorted() :");
        numbers = Arrays.asList(5, 2, 8, 1, 6, 3, 7, 4);
        // Sort elements in natural order
        List<Integer> sortedNumbers1 = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers1);

        // limit()
        // The limit() method is used to truncate a stream to a specified size, i.e.,
        // it returns a new stream that contains at most the specified number of elements.
        System.out.println("-------------------------------------------");
        System.out.println("limit() :");
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limitedNumbers = numbers.stream().limit(3).collect(Collectors.toList());
        System.out.println(numbers);

        // skip()
        // Skips the specified numbers of elements in the stream from the beginning.
        System.out.println("-------------------------------------------");
        System.out.println("skip() :");
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skippedNumbers = numbers.stream().skip(2).collect(Collectors.toList());
        System.out.println(skippedNumbers);

        // limit() & skip() can be used for pagination.
        // If we are working with a large collection of data that needs to be displayed
        // or processed in smaller chunks, we can use limit() and skip() to implement pagination.
        // For example, we can use limit() to restrict the number of elements to be displayed per page,
        // and skip() to skip the elements from previous pages.

        // Terminal operations

        // forEach(Consumer<T> action)
        // This terminal operation applies the given action to each element of the stream.
        // The action is a functional interface that takes an element of the stream
        // and performs a side-effect.
        System.out.println("-------------------------------------------");
        System.out.println("foEach() & forEachOrdered() :");
        names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        // Print each name in the list
        names.stream().forEach(System.out::println);
        // Print each element of the list in order using forEachOrdered()
        names.stream().forEachOrdered(System.out::println);


        // reduce(BinaryOperator<T> accumulator)
        // This terminal operation applies the given binary operator to the elements of the stream
        // and returns an Optional that represents the reduced result.
        // The binary operator is a functional interface that takes two elements and returns a single element.
        System.out.println("-------------------------------------------");
        System.out.println("reduce() :");
        Integer sum = numbers.stream().reduce((a, b) -> a + b).get();
        System.out.println(sum);


        // collect(Collector<T, A, R> collector)
        // This terminal operation collects the elements of the stream into a new data structure
        // or performs some other mutable reduction operation using the specified collector.
        // The collector is a complex functional interface that defines how the elements of the stream should be collected.
        System.out.println("-------------------------------------------");
        System.out.println("collect() :");
        perfectSquareStream = numbers.stream().map((a) -> a * a);
        List<Integer> perfectSquareList = perfectSquareStream.collect(Collectors.toList());
        // IllegalStateException: stream has already been operated upon or closed
        // As that stream was already terminated using forEach
        System.out.println(perfectSquareList);
        names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        // Collect names into a comma-separated string
        String namesString = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(namesString); // Output: John, Alice, Bob, Charlie

        // min()
        System.out.println("-------------------------------------------");
        System.out.println("min() :");
        int min = numbers.stream().min((a, b) -> a - b).orElse(0);
        System.out.println(min);

        // max()
        System.out.println("-------------------------------------------");
        System.out.println("max() :");
        int max = numbers.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(0);
        System.out.println(max);

        // findAny()
        //  This method is used to find any element in a stream.
        //  It returns an Optional<T> where T is the type of elements in the stream.
        //  If the stream is empty, the Optional will be empty.
        //  Note that the element returned by findAny() is non-deterministic (random)
        //  and may vary between invocations of the method.
        System.out.println("-------------------------------------------");
        System.out.println("findAny() :");
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> any = numbers.stream().findAny();
        System.out.println(any.orElse(null));

        // findFirst()
        // This method is used to find the first element in a stream.
        // It returns an Optional<T> where T is the type of elements in the stream.
        // If the stream is empty, the Optional will be empty.
        System.out.println("-------------------------------------------");
        System.out.println("findFirst() :");
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println(first.orElse(null));

        // anyMatch()
        // This method is used to check if any element in a stream matches a given predicate.
        // It returns a boolean value (true if any element matches, false otherwise).
        System.out.println("-------------------------------------------");
        System.out.println("anyMatch() :");
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 3);
        System.out.println(anyMatch);

        // allMatch()
        // This method is used to check if all elements in a stream match a given predicate.
        // It returns a boolean value (true if all elements match, false otherwise).
        System.out.println("-------------------------------------------");
        System.out.println("allMatch() :");
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        System.out.println(allMatch);

        // Sort map based on values
        System.out.println("-------------------------------------------");
        System.out.println("Map sorted based on values :");
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 40);
        map.put("Dave", 35);
        map.put("Eve", 20);
        // Three ways of comparing map by value
        // 1. (c1,c2) -> c1.getValue().compareTo(c2.getValue())
        // 2. Comparator.comparing(Map.Entry::getValue)
        // 3. Map.Entry.comparingByValue()
        // groupingBy()
        // Method 1
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> v1,
                LinkedHashMap::new));
        // Map.Entry::getKey and Map.Entry::getValue:
        // These are method references that specify how to extract the keys and values from the Map.Entry objects.
        // Map.Entry::getKey refers to the getKey() method of Map.Entry, which returns the key,
        // and Map.Entry::getValue refers to the getValue() method of Map.Entry, which returns the value.
        //
        //(v1, v2) -> v1:
        // This is a merge function that specifies how to resolve conflicts when multiple entries in the
        // original map have the same key in the sorted map.
        // In this case, it simply selects the first value encountered and discards the second value.
        // The parameters v1 and v2 represent the values of the conflicting entries,
        // and the lambda expression (v1, v2) -> v1 returns v1, effectively choosing the first value as the merged value.
        //
        //LinkedHashMap::new:
        // This specifies the type of Map to be created, which is a LinkedHashMap in this case.
        // LinkedHashMap is used to preserve the order of elements based on their insertion order,
        // which ensures that the sorted map is returned with the entries sorted by values.
        System.out.println(sortedMap);

        // Method 2
        Map<String, Integer> sortedMap2 = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered((entry) ->
                sortedMap2.put(entry.getKey(), entry.getValue()));
        System.out.println(sortedMap2);


    }

}
