package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.common.data.C0349f;

public final class LeaderboardBuffer extends C0349f<Leaderboard> {
    public LeaderboardBuffer(C0348d dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m1774a(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Leaderboard getEntry(int rowIndex, int numChildren) {
        return new C0361a(this.jf, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
