package com.clarusone.poker.handranks;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.handutils.RankComparatorUtil;

public class HighCard implements HandRank {
    @Override
    public boolean matches(PokerHand hand) {
        return true;
    }

    @Override
    public HandResult compareEqualHandRank(PokerHand yours, PokerHand opponents) {
        return RankComparatorUtil.compareNoSets(yours, opponents);
    }
}
