package com.tatsuyaoiw.java8;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.tatsuyaoiw.java8.CompletableFutureClass.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CompletableFutureClassTest {
    @Test
    public void test_supplyAsync() throws Exception {
        CompletableFuture<List<String>> future = supplyAsync("hello");
        assertEquals(ImmutableList.of("hello"), future.get());
    }

    @Test
    public void test_thenApply() throws Exception {
        CompletableFuture<List<String>> future = thenApply(supplyAsync("hello"), "world");
        assertEquals(ImmutableList.of("hello", "world"), future.get());
    }

    @Test
    public void test_thenCompose() throws Exception {
        CompletableFuture<List<String>> future = thenCompose(supplyAsync("hello"), "world");
        assertEquals(ImmutableList.of("hello", "world"), future.get());
    }

    @Test
    public void test_thenCombine() throws Exception {
        CompletableFuture<List<String>> future = thenCombine(supplyAsync("hello"), "world");
        assertEquals(ImmutableList.of("hello", "world"), future.get());
    }

    @Test
    public void test_thenAccept() throws Exception {
        CompletableFuture<Void> future = thenAccept(supplyAsync("hello"));
        assertNull(future.get());
    }

    @Test
    public void test_thenRun() throws Exception {
        CompletableFuture<Void> future = thenRun(supplyAsync("hello"));
        assertNull(future.get());
    }
}