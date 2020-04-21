package com.clarusone.poker.handutils;

import com.clarusone.poker.PokerHand;
import org.junit.Test;

import java.util.Arrays;

import static com.clarusone.poker.Rank.*;
import static org.junit.Assert.*;

public class RankSorterUtilTest {
    @Test
    public void hi_to_low_aces_high() {
        PokerHand hand = new PokerHand("4S AS 5S 3S 2S");
        assertEquals(Arrays.asList(ACE, FIVE, FOUR, THREE, TWO), RankSorterUtil.sortHiLow(hand));
    }

    @Test
    public void high_ace_sequential() {
        PokerHand hand = new PokerHand("TS JS QS KS AS");
        assertTrue(RankSorterUtil.isSequential(hand));
    }

    @Test
    public void low_ace_not_sequential() {
        PokerHand hand = new PokerHand("AS 2S 3S 4S 5S");
        assertFalse(RankSorterUtil.isSequential(hand));
    }
}
