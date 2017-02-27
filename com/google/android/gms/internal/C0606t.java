package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.ab.C0368a;

/* renamed from: com.google.android.gms.internal.t */
public final class C0606t extends C0368a {
    private final AdListener dT;

    public C0606t(AdListener adListener) {
        this.dT = adListener;
    }

    public void onAdClosed() {
        this.dT.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.dT.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.dT.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.dT.onAdLoaded();
    }

    public void onAdOpened() {
        this.dT.onAdOpened();
    }
}
