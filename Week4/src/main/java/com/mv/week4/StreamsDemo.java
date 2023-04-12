package com.mv.week4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
        names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        // Print each name in the list
        names.stream().forEach(System.out::println);

        // reduce(BinaryOperator<T> accumulator)
        // This terminal operation applies the given binary operator to the elements of the stream
        // and returns an Optional that represents the reduced result.
        // The binary operator is a functional interface that takes two elements and returns a single element.
        Integer sum = numbers.stream().reduce((a, b) -> a + b).get();
        System.out.println(sum);

        // collect(Collector<T, A, R> collector)
        // This terminal operation collects the elements of the stream into a new data structure
        // or performs some other mutable reduction operation using the specified collector.
        // The collector is a complex functional interface that defines how the elements of the stream should be collected.
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


    }

}
