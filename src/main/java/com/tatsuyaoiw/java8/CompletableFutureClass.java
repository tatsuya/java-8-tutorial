package com.tatsuyaoiw.java8;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureClass {
    static <T> CompletableFuture<List<T>> supplyAsync(T input) {
        return CompletableFuture.supplyAsync(() -> ImmutableList.of(input));
    }

    static <T> CompletableFuture<List<T>> thenApply(CompletableFuture<List<T>> future, T input) {
        return future.thenApply(x -> ImmutableList.<T>builder().addAll(x).add(input).build());
    }

    static <T> CompletableFuture<List<T>> thenCompose(CompletableFuture<List<T>> future, T input) {
        return future.thenCompose(x -> CompletableFuture.supplyAsync(() -> ImmutableList.<T>builder().addAll(x).add(input).build()));
    }

    static <T> CompletableFuture<List<T>> thenCombine(CompletableFuture<List<T>> future, T input) {
        return future.thenCombine(supplyAsync(input), (a, b) -> ImmutableList.<T>builder().addAll(a).addAll(b).build());
    }

    static <T> CompletableFuture<Void> thenAccept(CompletableFuture<T> future) {
        return future.thenAccept(System.out::println);
    }

    static <T> CompletableFuture<Void> thenRun(CompletableFuture<T> future) {
        return future.thenRun(() -> System.out.println("finished"));
    }
}
