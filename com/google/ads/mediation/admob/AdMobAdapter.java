package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.cm;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {
    private AdView f611h;
    private InterstitialAd f612i;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C0344a extends AdListener {
        private final AdMobAdapter f492j;
        private final MediationBannerListener f493k;

        public C0344a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f492j = adMobAdapter;
            this.f493k = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f493k.onDismissScreen(this.f492j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f493k.onFailedToReceiveAd(this.f492j, bb.m198f(errorCode));
        }

        public void onAdLeftApplication() {
            this.f493k.onLeaveApplication(this.f492j);
        }

        public void onAdLoaded() {
            this.f493k.onReceivedAd(this.f492j);
        }

        public void onAdOpened() {
            this.f493k.onClick(this.f492j);
            this.f493k.onPresentScreen(this.f492j);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C0345b extends AdListener {
        private final AdMobAdapter f494j;
        private final MediationInterstitialListener f495l;

        public C0345b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f494j = adMobAdapter;
            this.f495l = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f495l.onDismissScreen(this.f494j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f495l.onFailedToReceiveAd(this.f494j, bb.m198f(errorCode));
        }

        public void onAdLeftApplication() {
            this.f495l.onLeaveApplication(this.f494j);
        }

        public void onAdLoaded() {
            this.f495l.onReceivedAd(this.f494j);
        }

        public void onAdOpened() {
            this.f495l.onPresentScreen(this.f494j);
        }
    }

    private static AdRequest m1765a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        NetworkExtras adMobExtras2;
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        Gender gender = mediationAdRequest.getGender();
        if (gender != null) {
            builder.setGender(bb.m194a(gender));
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(cm.m290l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            builder.tagForChildDirectedTreatment(adMobServerParameters.tagForChildDirectedTreatment == 1);
        }
        if (adMobExtras == null) {
            adMobExtras2 = new AdMobExtras(new Bundle());
        }
        Bundle extras = adMobExtras2.getExtras();
        extras.putInt("gw", 1);
        extras.putString("mad_hac", adMobServerParameters.allowHouseAds);
        extras.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras2);
        return builder.build();
    }

    public void destroy() {
        if (this.f611h != null) {
            this.f611h.destroy();
            this.f611h = null;
        }
        if (this.f612i != null) {
            this.f612i = null;
        }
    }

    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    public View getBannerView() {
        return this.f611h;
    }

    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener bannerListener, Activity activity, AdMobServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f611h = new AdView(activity);
        this.f611h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f611h.setAdUnitId(serverParameters.adUnitId);
        this.f611h.setAdListener(new C0344a(this, bannerListener));
        this.f611h.loadAd(m1765a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(MediationInterstitialListener interstitialListener, Activity activity, AdMobServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f612i = new InterstitialAd(activity);
        this.f612i.setAdUnitId(serverParameters.adUnitId);
        this.f612i.setAdListener(new C0345b(this, interstitialListener));
        this.f612i.loadAd(m1765a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f612i.show();
    }
}
