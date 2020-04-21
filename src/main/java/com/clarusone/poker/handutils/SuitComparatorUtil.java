package com.clarusone.poker.handutils;

import com.clarusone.poker.PlayingCard;
import com.clarusone.poker.PokerHand;
import com.clarusone.poker.Suit;

import java.util.Map;
import java.util.stream.Collectors;

public class SuitComparatorUtil {
    public static boolean allMatch(PokerHand hand) {
        final Map<Suit, Integer> countBySuit = hand.getCards().stream()
                .collect(
                        Collectors.groupingBy(
                                PlayingCard::getSuit,
                                Collectors.summingInt(x -> 1)));

        return countBySuit.size() == 1;
    }
}
