package com.clarusone.poker.handutils;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.Rank;

import java.util.List;

public class RankComparatorUtil {
    public static HandResult compareOrdered(final List<Rank> yourRanksInOrder, final List<Rank> opponentsRanksInOrder) {
        for(int i = 0; i < yourRanksInOrder.size(); i++) {
            final int comparisonValue = yourRanksInOrder.get(i).compareTo(opponentsRanksInOrder.get(i));

            if(comparisonValue < 0) {
                return HandResult.LOSS;
            }

            if(comparisonValue > 0) {
                return HandResult.WIN;
            }
        }

        return HandResult.TIE;
    }

    public static HandResult compareNoSets(final PokerHand yours, final PokerHand opponents) {
        final List<Rank> yourRanksInOrder = RankSorterUtil.sortHiLow(yours);
        final List<Rank> opponentsRanksInOrder = RankSorterUtil.sortHiLow(opponents);

        return RankComparatorUtil.compareOrdered(yourRanksInOrder, opponentsRanksInOrder);
    }
}
