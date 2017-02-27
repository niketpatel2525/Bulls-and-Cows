package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.sxnyodot.uefqvmio207964.AdListener.OptinListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: com.sxnyodot.uefqvmio207964.e */
class C0559e extends AlertDialog implements OnCancelListener, OnDismissListener, OnShowListener, C0292b<String> {
    private static final String TEXT = "PGh0bWw+PGJvZHkgc3R5bGU9J2JhY2tncm91bmQ6I0M0QzRDNDtmb250LWZhbWlseTpBcmlhbDtmb250LXNpemU6MTFwdDtsaW5lLWhlaWdodDoxOHB4Jz48cCBhbGlnbj0nanVzdGlmeSc+VGhpcyBhcHAgaXMgYWQtc3VwcG9ydGVkIGFuZCBvdXIgYWR2ZXJ0aXNpbmcgbmV0d29yaywgQWlycHVzaCwgSW5jLiwgd2lsbCBwbGFjZSBhZHMgd2l0aGluIHRoaXMgYXBwLiBBaXJwdXNoIGF1dG9tYXRpY2FsbHkgY29sbGVjdHMgY2VydGFpbiBkYXRhIGZyb20geW91ciBkZXZpY2UsIGluY2x1ZGluZyBhIGRldmljZSBJRCBhbmQgSVAgYWRkcmVzcy4gQWlycHVzaCBtYXkgYWxzbyByZWNlaXZlIGluZm9ybWF0aW9uIHZpYSB0aGUgcGVybWlzc2lvbnMgeW91IGdyYW50ZWQgdG8gdGhpcyBhcHAgaW4gdGhlIHByaW9yIHNjcmVlbiBpbmNsdWRpbmcgeW91ciBwcmVjaXNlIGdlb2xvY2F0aW9uLiBUbyBsZWFybiBtb3JlIGFib3V0IEFpcnB1c2gmIzM5O3MgcHJpdmFjeSBwcmFjdGljZXMsIHZpc2l0IGl0cyA8YSBocmVmPSJodHRwOi8vd3d3LmFpcnB1c2guY29tL3RlY2hub2xvZ3lfcHJpdmFjeS8iPlRlY2hub2xvZ3kgUHJpdmFjeSBTdGF0ZW1lbnQ8L2E+LiBCeSBjbGlja2luZyAmcXVvdDtPa2F5LCZxdW90OyB5b3UgcHJvdmlkZSBleHBsaWNpdCBjb25zZW50IHRvIGFsbG93IEFpcnB1c2ggdG8gYXNzb2NpYXRlIHRoZSBHb29nbGUgYWR2ZXJ0aXNlciBJRCBmcm9tIHlvdXIgZGV2aWNlIHdpdGggb3RoZXIgaW5mb3JtYXRpb24gaXQgY29sbGVjdHMgYWJvdXQgeW91ciBkZXZpY2UsIGluY2x1ZGluZyBwZXJzaXN0ZW50IGRldmljZSBpZGVudGlmaWVycyBhbmQvb3IgcGVyc29uYWxseSBpZGVudGlmaWFibGUgaW5mb3JtYXRpb24uIENsaWNrICZxdW90O0NhbmNlbCZxdW90OyB0byB3aXRoaG9sZCBzdWNoIGNvbnNlbnQuPC9wPjwvYm9keT48L2h0bWw+";
    private static final String TITLE = "UHJpdmFjeSBQb2xpY3kgJiBBZHZlcnRpc2luZyBUZXJtcw==";
    private static String f594a;
    private static String f595b;
    private final Activity f596c;
    private OptinListener f597d;
    private WebView f598e;

    /* renamed from: com.sxnyodot.uefqvmio207964.e.1 */
    class C02951 implements OnClickListener {
        final /* synthetic */ C0559e f375a;

        C02951(C0559e c0559e) {
            this.f375a = c0559e;
        }

        public void onClick(View arg0) {
            this.f375a.m1743b();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.e.2 */
    class C02962 implements OnClickListener {
        final /* synthetic */ C0559e f376a;

        C02962(C0559e c0559e) {
            this.f376a = c0559e;
        }

        public void onClick(View arg0) {
            try {
                MainActivity.m919a(false);
                this.f376a.dismiss();
                C0562q.m1750f(this.f376a.f596c);
                Prm.isDialogClosed = true;
                if (Util.m977o(this.f376a.f596c)) {
                    C0559e.f595b = "optIn";
                    this.f376a.m1740a();
                    Prm.startNewAdThread();
                } else {
                    this.f376a.f596c.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f376a.f597d != null) {
                this.f376a.f597d.optinResult(true);
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.e.a */
    private class C0297a extends WebViewClient {
        final /* synthetic */ C0559e f377a;

        private C0297a(C0559e c0559e) {
            this.f377a = c0559e;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                intent.addFlags(268435456);
                this.f377a.f596c.startActivity(intent);
            } catch (Exception e) {
            }
            return true;
        }
    }

    static {
        f594a = C0300h.TAG;
        f595b = "optOut";
    }

    protected C0559e(Activity activity, String str) {
        super(activity);
        this.f596c = activity;
        this.f597d = Prm.getOptinListener();
        Log.i(f594a, "Display Privacy & Terms");
        try {
            setOnShowListener(this);
            setOnDismissListener(this);
            setOnCancelListener(this);
            getWindow().requestFeature(2);
            setTitle(Base64.decodeString(TITLE));
            getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION, AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            View linearLayout = new LinearLayout(this.f596c);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            float f = this.f596c.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout2 = new LinearLayout(this.f596c);
            linearLayout2.setGravity(17);
            m1737a(linearLayout2);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) (f * BitmapDescriptorFactory.HUE_YELLOW), 2.0f);
            layoutParams2.topMargin = (int) (-(BitmapDescriptorFactory.HUE_YELLOW * f));
            layoutParams2.gravity = 80;
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams2);
            View textView = new TextView(this.f596c);
            textView.setGravity(17);
            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 2.0f);
            layoutParams3.gravity = 17;
            textView.setLayoutParams(layoutParams3);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextAppearance(this.f596c, 16843271);
            CharSequence spannableString = new SpannableString("Cancel");
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            textView.setText(spannableString);
            textView.setId(-2);
            linearLayout2.addView(textView);
            View button = new Button(this.f596c);
            button.setId(-1);
            button.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 2.0f));
            button.setText("Ok");
            linearLayout2.addView(button);
            linearLayout2.setBackgroundColor(-3355444);
            View linearLayout3 = new LinearLayout(this.f596c);
            LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams4.bottomMargin = (int) (f * BitmapDescriptorFactory.HUE_YELLOW);
            linearLayout3.setLayoutParams(layoutParams4);
            this.f598e = new WebView(this.f596c);
            if (str == null || str.equals("")) {
                this.f598e.loadData("" + Base64.decodeString(TEXT), "text/html", "utf-8");
            } else {
                this.f598e.loadData(str, "text/html", "utf-8");
            }
            this.f598e.setWebChromeClient(new WebChromeClient());
            this.f598e.setWebViewClient(new C0297a());
            this.f598e.setScrollBarStyle(33554432);
            linearLayout3.addView(this.f598e);
            linearLayout.addView(linearLayout3);
            linearLayout.addView(linearLayout2);
            setView(linearLayout);
            setCancelable(true);
            textView.setOnClickListener(new C02951(this));
            button.setOnClickListener(new C02962(this));
        } catch (Exception e) {
            this.f596c.finish();
        }
    }

    void m1743b() {
        try {
            MainActivity.m919a(false);
            dismiss();
            Prm.isDialogClosed = true;
            if (Util.m977o(this.f596c)) {
                f595b = "optOut";
                m1740a();
                Prm.startNewAdThread();
            }
            this.f596c.finish();
        } catch (Throwable e) {
            Log.w(f594a, "Warning", e);
        }
        if (this.f597d != null) {
            this.f597d.optinResult(false);
        }
    }

    public void onDismiss(DialogInterface dialog) {
        try {
            if (this.f598e != null) {
                this.f598e.stopLoading();
                this.f598e.removeAllViews();
                this.f598e.destroy();
            }
            this.f596c.finish();
            this.f598e = null;
        } catch (Throwable th) {
            Util.m930a("Error in EULA dismiss.", th);
        }
    }

    public void onCancel(DialogInterface dialog) {
        m1743b();
    }

    public void onShow(DialogInterface dialog) {
        if (this.f597d != null) {
            this.f597d.showingDialog();
        }
    }

    public void m1740a() {
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(C0303k.EVENT, f595b));
        if (f595b == null || !f595b.equals("optIn")) {
            String c = Util.m940c();
            if (c == null || c.equals("")) {
                throw new NullPointerException("Advertiser ID not found.");
            }
            arrayList.add(new BasicNameValuePair(C0300h.IMEI, Util.m972m(c)));
            arrayList.add(new BasicNameValuePair(C0300h.DEVICE_UNIQUENESS, "ADV"));
            arrayList.add(new BasicNameValuePair("adOpt", "" + Util.m939b()));
        } else {
            arrayList.add(new BasicNameValuePair(C0300h.IMEI, "" + Util.m952g()));
            arrayList.add(new BasicNameValuePair(C0300h.DEVICE_UNIQUENESS, Util.m989w()));
        }
        arrayList.add(new BasicNameValuePair(C0300h.APP_ID, Util.m961j()));
        Log.i(f594a, f595b + " Data: " + arrayList);
        new Thread(new C0304m(this.f596c, this, arrayList, C0300h.URL_OPT_IN, 0, false), "opt_in").start();
    }

    public void m1742a(String str) {
        Log.i(f594a, f595b + " data sent: " + str);
        this.f596c.finish();
    }

    private void m1737a(LinearLayout linearLayout) {
        try {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#A5A5A5"), Color.parseColor("#9C9C9C"), Color.parseColor("#929493")});
            if (VERSION.SDK_INT >= 16) {
                linearLayout.setBackground(gradientDrawable);
            } else {
                linearLayout.setBackgroundDrawable(gradientDrawable);
            }
        } catch (Throwable e) {
            Util.m930a("Error in eula bg", e);
        }
    }
}
