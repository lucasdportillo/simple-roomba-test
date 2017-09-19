package com.yoti.roomba.domain;

enum Direction {
    N, S, W, E;

    static Direction from(char c) {
        if ("E".equalsIgnoreCase(String.valueOf(c))) return E;
        if ("N".equalsIgnoreCase(String.valueOf(c))) return N;
        if ("S".equalsIgnoreCase(String.valueOf(c))) return S;

        return W;
    }
}
