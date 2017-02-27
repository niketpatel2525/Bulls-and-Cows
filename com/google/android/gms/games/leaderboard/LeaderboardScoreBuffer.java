package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.common.data.DataBuffer;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final C0077b nv;

    public LeaderboardScoreBuffer(C0348d dataHolder) {
        super(dataHolder);
        this.nv = new C0077b(dataHolder.aM());
    }

    public C0077b cb() {
        return this.nv;
    }

    public LeaderboardScore get(int position) {
        return new C0573d(this.jf, position);
    }
}
