package com.clarusone.poker.handranks;

import com.clarusone.poker.HandResult;
import com.clarusone.poker.PokerHand;

public interface HandRank {
    boolean matches(PokerHand hand);
    HandResult compareEqualHandRank(PokerHand yours, PokerHand opponents);
}
