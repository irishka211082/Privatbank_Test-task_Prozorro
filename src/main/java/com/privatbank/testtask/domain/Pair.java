package com.privatbank.testtask.domain;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Pair implements Comparable<Pair> {
    private String id;
    private String name;

    @Override
    public int compareTo(@NotNull Pair p) {
        return id.compareTo(p.getId());
    }
}
