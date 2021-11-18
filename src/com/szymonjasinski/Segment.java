package com.szymonjasinski;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Segment {
    BUDGET("Budget"),       // >~50k
    STANDARD("Standard"),   // >100k
    PREMIUM("Premium");     // ~100k<

    private final String segment;

    Segment(String segment) {
        this.segment = segment;
    }

    // Creating new list of Segment with all the values from enum Segment.
    private static final List<Segment> SEGMENT_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = SEGMENT_LIST.size();

    public String getName() {
        return this.segment;
    }
}
