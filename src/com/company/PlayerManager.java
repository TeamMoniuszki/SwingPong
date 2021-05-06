package com.company;

import java.util.ArrayList;
import java.util.List;


public abstract class PlayerManager {
    private static List<Player> players;

    private static boolean isInitialized = false;

    public void initialize() {
        if (isInitialized) return;

        players = new ArrayList<>();

        isInitialized = true;
    }
}
