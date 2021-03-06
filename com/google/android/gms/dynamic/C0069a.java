package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0069a<T extends LifecycleDelegate> {
    private T lV;
    private Bundle lW;
    private LinkedList<C0068a> lX;
    private final C0071d<T> lY;

    /* renamed from: com.google.android.gms.dynamic.a.5 */
    class C00675 implements OnClickListener {
        final /* synthetic */ Context gO;
        final /* synthetic */ C0069a lZ;
        final /* synthetic */ int mg;

        C00675(C0069a c0069a, Context context, int i) {
            this.lZ = c0069a;
            this.gO = context;
            this.mg = i;
        }

        public void onClick(View v) {
            this.gO.startActivity(GooglePlayServicesUtil.m25a(this.gO, this.mg, -1));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.a */
    private interface C0068a {
        void m134b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a.1 */
    class C03511 implements C0071d<T> {
        final /* synthetic */ C0069a lZ;

        C03511(C0069a c0069a) {
            this.lZ = c0069a;
        }

        public void m1109a(T t) {
            this.lZ.lV = t;
            Iterator it = this.lZ.lX.iterator();
            while (it.hasNext()) {
                ((C0068a) it.next()).m134b(this.lZ.lV);
            }
            this.lZ.lX.clear();
            this.lZ.lW = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.2 */
    class C03522 implements C0068a {
        final /* synthetic */ C0069a lZ;
        final /* synthetic */ Activity ma;
        final /* synthetic */ Bundle mb;
        final /* synthetic */ Bundle mc;

        C03522(C0069a c0069a, Activity activity, Bundle bundle, Bundle bundle2) {
            this.lZ = c0069a;
            this.ma = activity;
            this.mb = bundle;
            this.mc = bundle2;
        }

        public void m1110b(LifecycleDelegate lifecycleDelegate) {
            this.lZ.lV.onInflate(this.ma, this.mb, this.mc);
        }

        public int getState() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.3 */
    class C03533 implements C0068a {
        final /* synthetic */ C0069a lZ;
        final /* synthetic */ Bundle mc;

        C03533(C0069a c0069a, Bundle bundle) {
            this.lZ = c0069a;
            this.mc = bundle;
        }

        public void m1111b(LifecycleDelegate lifecycleDelegate) {
            this.lZ.lV.onCreate(this.mc);
        }

        public int getState() {
            return 1;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.4 */
    class C03544 implements C0068a {
        final /* synthetic */ C0069a lZ;
        final /* synthetic */ Bundle mc;
        final /* synthetic */ FrameLayout md;
        final /* synthetic */ LayoutInflater me;
        final /* synthetic */ ViewGroup mf;

        C03544(C0069a c0069a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.lZ = c0069a;
            this.md = frameLayout;
            this.me = layoutInflater;
            this.mf = viewGroup;
            this.mc = bundle;
        }

        public void m1112b(LifecycleDelegate lifecycleDelegate) {
            this.md.removeAllViews();
            this.md.addView(this.lZ.lV.onCreateView(this.me, this.mf, this.mc));
        }

        public int getState() {
            return 2;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.6 */
    class C03556 implements C0068a {
        final /* synthetic */ C0069a lZ;

        C03556(C0069a c0069a) {
            this.lZ = c0069a;
        }

        public void m1113b(LifecycleDelegate lifecycleDelegate) {
            this.lZ.lV.onResume();
        }

        public int getState() {
            return 3;
        }
    }

    public C0069a() {
        this.lY = new C03511(this);
    }

    private void m135J(int i) {
        while (!this.lX.isEmpty() && ((C0068a) this.lX.getLast()).getState() >= i) {
            this.lX.removeLast();
        }
    }

    private void m139a(Bundle bundle, C0068a c0068a) {
        if (this.lV != null) {
            c0068a.m134b(this.lV);
            return;
        }
        if (this.lX == null) {
            this.lX = new LinkedList();
        }
        this.lX.add(c0068a);
        if (bundle != null) {
            if (this.lW == null) {
                this.lW = (Bundle) bundle.clone();
            } else {
                this.lW.putAll(bundle);
            }
        }
        m142a(this.lY);
    }

    public void m141a(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence b = GooglePlayServicesUtil.m30b(context, isGooglePlayServicesAvailable, -1);
        CharSequence b2 = GooglePlayServicesUtil.m29b(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (b2 != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(b2);
            linearLayout.addView(button);
            button.setOnClickListener(new C00675(this, context, isGooglePlayServicesAvailable));
        }
    }

    protected abstract void m142a(C0071d<T> c0071d);

    public T bP() {
        return this.lV;
    }

    public void onCreate(Bundle savedInstanceState) {
        m139a(savedInstanceState, new C03533(this, savedInstanceState));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        m139a(savedInstanceState, new C03544(this, frameLayout, inflater, container, savedInstanceState));
        if (this.lV == null) {
            m141a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.lV != null) {
            this.lV.onDestroy();
        } else {
            m135J(1);
        }
    }

    public void onDestroyView() {
        if (this.lV != null) {
            this.lV.onDestroyView();
        } else {
            m135J(2);
        }
    }

    public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
        m139a(savedInstanceState, new C03522(this, activity, attrs, savedInstanceState));
    }

    public void onLowMemory() {
        if (this.lV != null) {
            this.lV.onLowMemory();
        }
    }

    public void onPause() {
        if (this.lV != null) {
            this.lV.onPause();
        } else {
            m135J(3);
        }
    }

    public void onResume() {
        m139a(null, new C03556(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.lV != null) {
            this.lV.onSaveInstanceState(outState);
        } else if (this.lW != null) {
            outState.putAll(this.lW);
        }
    }
}
