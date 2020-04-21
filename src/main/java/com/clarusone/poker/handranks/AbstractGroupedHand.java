package com.clarusone.poker.handranks;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.Rank;
import com.clarusone.poker.handutils.RankComparatorUtil;
import com.clarusone.poker.handutils.RankCountUtil;

import java.util.List;

public abstract class AbstractGroupedHand implements HandRank {
    protected abstract List<Integer> handRankCounts();

    @Override
    public boolean matches(final PokerHand hand) {
        final List<Integer> rankCounts = RankCountUtil.countRanks(hand);
        return handRankCounts().equals(rankCounts);
    }

    @Override
    public HandResult compareEqualHandRank(final PokerHand yours, final PokerHand opponents) {
        final List<Rank> yourRanksInOrder = RankCountUtil.ranksByCountThenRank(yours);
        final List<Rank> opponentsRanksInOrder = RankCountUtil.ranksByCountThenRank(opponents);

        return RankComparatorUtil.compareOrdered(yourRanksInOrder, opponentsRanksInOrder);
    }
}
