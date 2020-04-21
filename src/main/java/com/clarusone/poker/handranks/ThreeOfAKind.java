package com.clarusone.poker.handranks;

import java.util.Arrays;
import java.util.List;

public class ThreeOfAKind extends AbstractGroupedHand {

    private static final List<Integer> HAND_RANK_COUNTS = Arrays.asList(3, 1, 1);

    @Override
    protected List<Integer> handRankCounts() {
        return HAND_RANK_COUNTS;
    }
}
