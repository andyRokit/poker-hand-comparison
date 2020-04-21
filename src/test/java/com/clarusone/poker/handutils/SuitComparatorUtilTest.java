package com.clarusone.poker.handutils;

import com.clarusone.poker.PokerHand;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuitComparatorUtilTest {
    @Test
    public void matching_suits() {
        PokerHand hand = new PokerHand("TS JS QS KS AS");
        assertTrue(SuitComparatorUtil.allMatch(hand));
    }

    @Test
    public void non_matching_suits() {
        PokerHand hand = new PokerHand("TD JS QS KS AS");
        assertFalse(SuitComparatorUtil.allMatch(hand));
    }
}
