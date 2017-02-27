package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.cn;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f618m;
    private CustomEventBanner f619n;
    private CustomEventInterstitial f620o;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C0565a implements CustomEventBannerListener {
        private final MediationBannerListener f613k;
        private final CustomEventAdapter f614p;

        public C0565a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f614p = customEventAdapter;
            this.f613k = mediationBannerListener;
        }

        public void onClick() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f613k.onClick(this.f614p);
        }

        public void onDismissScreen() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f613k.onDismissScreen(this.f614p);
        }

        public void onFailedToReceiveAd() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f613k.onFailedToReceiveAd(this.f614p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f613k.onLeaveApplication(this.f614p);
        }

        public void onPresentScreen() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f613k.onPresentScreen(this.f614p);
        }

        public void onReceivedAd(View view) {
            cn.m295m("Custom event adapter called onReceivedAd.");
            this.f614p.m1767a(view);
            this.f613k.onReceivedAd(this.f614p);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0566b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f615l;
        private final CustomEventAdapter f616p;
        final /* synthetic */ CustomEventAdapter f617q;

        public C0566b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f617q = customEventAdapter;
            this.f616p = customEventAdapter2;
            this.f615l = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            cn.m295m("Custom event adapter called onDismissScreen.");
            this.f615l.onDismissScreen(this.f616p);
        }

        public void onFailedToReceiveAd() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f615l.onFailedToReceiveAd(this.f616p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            cn.m295m("Custom event adapter called onLeaveApplication.");
            this.f615l.onLeaveApplication(this.f616p);
        }

        public void onPresentScreen() {
            cn.m295m("Custom event adapter called onPresentScreen.");
            this.f615l.onPresentScreen(this.f616p);
        }

        public void onReceivedAd() {
            cn.m295m("Custom event adapter called onReceivedAd.");
            this.f615l.onReceivedAd(this.f617q);
        }
    }

    private static <T> T m1766a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            cn.m299q("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m1767a(View view) {
        this.f618m = view;
    }

    public void destroy() {
        if (this.f619n != null) {
            this.f619n.destroy();
        }
        if (this.f620o != null) {
            this.f620o.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f618m;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f619n = (CustomEventBanner) m1766a(serverParameters.className);
        if (this.f619n == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f619n.requestBannerAd(new C0565a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f620o = (CustomEventInterstitial) m1766a(serverParameters.className);
        if (this.f620o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f620o.requestInterstitialAd(new C0566b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f620o.showInterstitial();
    }
}
