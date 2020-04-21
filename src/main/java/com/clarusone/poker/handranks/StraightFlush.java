package com.clarusone.poker.handranks;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.handutils.RankComparatorUtil;
import com.clarusone.poker.handutils.RankSorterUtil;
import com.clarusone.poker.handutils.SuitComparatorUtil;

public class StraightFlush implements HandRank {
    @Override
    public boolean matches(PokerHand hand) {
        return RankSorterUtil.isSequential(hand) && SuitComparatorUtil.allMatch(hand);
    }

    @Override
    public HandResult compareEqualHandRank(PokerHand yours, PokerHand opponents) {
        return RankComparatorUtil.compareNoSets(yours, opponents);
    }
}
