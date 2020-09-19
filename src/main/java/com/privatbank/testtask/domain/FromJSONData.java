package com.privatbank.testtask.domain;

import java.util.List;

public class FromJSONData {
    private List<Pair> pairs;

    public FromJSONData(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }
}
