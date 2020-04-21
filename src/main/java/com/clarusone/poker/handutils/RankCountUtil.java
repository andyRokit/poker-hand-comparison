package com.clarusone.poker.handutils;

import com.clarusone.poker.PlayingCard;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class RankCountUtil {
    public static List<Integer> countRanks(final PokerHand hand) {
        final Map<Rank, Integer> countByRank = getCountsByRank(hand);

        return countByRank.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static Map<Rank, Integer> getCountsByRank(final PokerHand hand) {
        return hand.getCards().stream()
                .collect(
                        Collectors.groupingBy(
                                PlayingCard::getRank,
                                Collectors.summingInt(x -> 1)));
    }

    public static List<Rank> ranksByCountThenRank(final PokerHand hand) {
        final Map<Rank, Integer> countByRank = getCountsByRank(hand);

        return countByRank.entrySet().stream()
                .sorted((e1, e2) -> {
                    int countsCompared = e2.getValue().compareTo(e1.getValue());

                    if(countsCompared == 0) {
                        return e2.getKey().compareTo(e1.getKey());
                    } else {
                        return countsCompared;
                    }
                })
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
