package com.clarusone.poker.handranks;

import java.util.Arrays;
import java.util.List;

public class TwoPair extends AbstractGroupedHand {

    private static final List<Integer> HAND_RANK_COUNTS = Arrays.asList(2, 2, 1);

    @Override
    protected List<Integer> handRankCounts() {
        return HAND_RANK_COUNTS;
    }
}
