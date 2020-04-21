package com.clarusone.poker.handutils;

import com.clarusone.poker.PokerHand;
import com.clarusone.poker.Rank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.clarusone.poker.HandResult.*;
import static org.junit.Assert.assertEquals;

public class RankComparatorUtilTest {

    @Test
    public void first_card_higher() {
        List<Rank> playerHand = Arrays.asList(Rank.TEN, Rank.EIGHT);
        List<Rank> opponentHand = Arrays.asList(Rank.NINE, Rank.EIGHT);
        assertEquals(WIN, RankComparatorUtil.compareOrdered(playerHand, opponentHand));
    }

    @Test
    public void first_card_lower() {
        List<Rank> playerHand = Arrays.asList(Rank.NINE, Rank.EIGHT);
        List<Rank> opponentHand = Arrays.asList(Rank.TEN, Rank.EIGHT);

        assertEquals(LOSS, RankComparatorUtil.compareOrdered(playerHand, opponentHand));
    }

    @Test
    public void first_card_same_second_card_higher() {
        List<Rank> playerHand = Arrays.asList(Rank.TEN, Rank.NINE);
        List<Rank> opponentHand = Arrays.asList(Rank.TEN, Rank.EIGHT);
        assertEquals(WIN, RankComparatorUtil.compareOrdered(playerHand, opponentHand));
    }

    @Test
    public void first_card_same_second_card_lower() {
        List<Rank> playerHand = Arrays.asList(Rank.TEN, Rank.EIGHT);
        List<Rank> opponentHand = Arrays.asList(Rank.TEN, Rank.NINE);
        assertEquals(LOSS, RankComparatorUtil.compareOrdered(playerHand, opponentHand));
    }

    @Test
    public void all_cards_same_ranks() {
        List<Rank> playerHand = Arrays.asList(Rank.TEN, Rank.NINE);
        List<Rank> opponentHand = Arrays.asList(Rank.TEN, Rank.NINE);
        assertEquals(TIE, RankComparatorUtil.compareOrdered(playerHand, opponentHand));
    }

    @Test
    public void hands_are_sorted_before_comparison() {
        PokerHand playerHand = new PokerHand("3S AS JS TS 8S");
        PokerHand opponentHand = new PokerHand("4S KS JS TS 8S");
        assertEquals(WIN, RankComparatorUtil.compareNoSets(playerHand, opponentHand));
    }
}
