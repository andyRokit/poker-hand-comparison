package com.clarusone.poker.handutils;

import com.clarusone.poker.PlayingCard;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.Rank;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RankSorterUtil {
    public static List<Rank> sortHiLow(final PokerHand hand) {
        return hand.getCards().stream().map(PlayingCard::getRank).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static boolean isSequential(final PokerHand hand) {
        final List<Rank> sortedByRank = RankSorterUtil.sortHiLow(hand);

        for(int i = 1; i < sortedByRank.size(); i++) {
            final Rank cardRank = sortedByRank.get(i);
            final Rank precedingCardRank = sortedByRank.get(i-1);

            if(cardRank.ordinal() != precedingCardRank.ordinal() - 1) {
                return false;
            }
        }

        return true;
    }
}
