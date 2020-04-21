package com.clarusone.poker;

import com.clarusone.poker.handranks.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand implements Comparable<PokerHand> {

    private static final List<HandRank> ORDERED_HAND_RANKS = Arrays.asList(
            new StraightFlush(),
            new FourOfAKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfAKind(),
            new TwoPair(),
            new OnePair(),
            new HighCard()
    );

    private Set<PlayingCard> cards;

    public Set<PlayingCard> getCards() {
        return this.cards;
    }

    public PokerHand(String fiveCards) {
        this.cards = Stream.of(fiveCards.split(" "))
                .map(PlayingCard::fromString)
                .collect(Collectors.toSet());
    }

    @Override
    public int compareTo(PokerHand opponentHand) {
        HandRank playerHandRank = getRankFor(this);
        HandRank opponentHandRank = getRankFor(opponentHand);

        if(ORDERED_HAND_RANKS.indexOf(playerHandRank) < ORDERED_HAND_RANKS.indexOf(opponentHandRank)) {
            return HandResult.WIN.comparatorValue;
        } else if(ORDERED_HAND_RANKS.indexOf(playerHandRank) > ORDERED_HAND_RANKS.indexOf(opponentHandRank)) {
            return HandResult.LOSS.comparatorValue;
        } else {
            return playerHandRank.compareEqualHandRank(this, opponentHand).comparatorValue;
        }
    }

    private HandRank getRankFor(PokerHand pokerHand) {
        return ORDERED_HAND_RANKS.stream().filter(rank -> rank.matches(pokerHand)).findFirst().get();
    }
}
