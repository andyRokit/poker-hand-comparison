package com.clarusone.poker.handutils;

import com.clarusone.poker.PokerHand;
import org.junit.Test;

import java.util.Arrays;

import static com.clarusone.poker.Rank.*;
import static org.junit.Assert.assertEquals;

public class RankCountUtilTest {
    @Test
    public void rank_sets_calculated_correctly() {
        PokerHand hand = new PokerHand("2D 3S 2S 3D 2C");
        assertEquals(Arrays.asList(3, 2), RankCountUtil.countRanks(hand));
    }

    @Test
    public void ordered_by_count_before_rank() {
        PokerHand hand = new PokerHand("4S 6S 7S 5S 5D");
        assertEquals(Arrays.asList(FIVE, SEVEN, SIX, FOUR), RankCountUtil.ranksByCountThenRank(hand));
    }
}
