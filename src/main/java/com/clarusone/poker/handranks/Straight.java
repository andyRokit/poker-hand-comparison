package com.clarusone.poker.handranks;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.handutils.RankComparatorUtil;
import com.clarusone.poker.handutils.RankSorterUtil;

public class Straight implements HandRank {
    @Override
    public boolean matches(PokerHand hand) {
        return RankSorterUtil.isSequential(hand);
    }

    @Override
    public HandResult compareEqualHandRank(PokerHand yours, PokerHand opponents) {
        return RankComparatorUtil.compareNoSets(yours, opponents);
    }
}
