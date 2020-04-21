package com.clarusone.poker.handranks;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.handutils.RankComparatorUtil;
import com.clarusone.poker.handutils.SuitComparatorUtil;

public class Flush implements HandRank {
    @Override
    public boolean matches(PokerHand hand) {
        return SuitComparatorUtil.allMatch(hand);
    }

    @Override
    public HandResult compareEqualHandRank(PokerHand yours, PokerHand opponents) {
        return RankComparatorUtil.compareNoSets(yours, opponents);
    }
}
