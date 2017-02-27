package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.internal.de.C0134b;
import com.google.android.gms.internal.de.C0415c;
import com.google.android.gms.internal.de.C0582d;
import com.google.android.gms.internal.fk.C0460a;
import com.google.android.gms.plus.PlusClient.OnAccessRevokedListener;
import com.google.android.gms.plus.PlusClient.OnMomentsLoadedListener;
import com.google.android.gms.plus.PlusClient.OnPeopleLoadedListener;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class fl extends de<fk> implements GooglePlayServicesClient {
    private Person ro;
    private fn rp;

    /* renamed from: com.google.android.gms.internal.fl.f */
    final class C0461f extends C0134b<OnAccessRevokedListener> {
        final /* synthetic */ fl rr;
        private final ConnectionResult rs;

        public C0461f(fl flVar, OnAccessRevokedListener onAccessRevokedListener, ConnectionResult connectionResult) {
            this.rr = flVar;
            super(flVar, onAccessRevokedListener);
            this.rs = connectionResult;
        }

        protected void m1503a(OnAccessRevokedListener onAccessRevokedListener) {
            this.rr.disconnect();
            if (onAccessRevokedListener != null) {
                onAccessRevokedListener.onAccessRevoked(this.rs);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.b */
    final class C0593b extends C0415c<OnMomentsLoadedListener> {
        final /* synthetic */ fl rr;
        private final ConnectionResult rs;
        private final String rt;
        private final String ru;

        public C0593b(fl flVar, OnMomentsLoadedListener onMomentsLoadedListener, ConnectionResult connectionResult, C0348d c0348d, String str, String str2) {
            this.rr = flVar;
            super(flVar, onMomentsLoadedListener, c0348d);
            this.rs = connectionResult;
            this.rt = str;
            this.ru = str2;
        }

        protected void m1925a(OnMomentsLoadedListener onMomentsLoadedListener, C0348d c0348d) {
            onMomentsLoadedListener.onMomentsLoaded(this.rs, c0348d != null ? new MomentBuffer(c0348d) : null, this.rt, this.ru);
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.d */
    final class C0594d extends C0415c<OnPeopleLoadedListener> {
        final /* synthetic */ fl rr;
        private final ConnectionResult rs;
        private final String rt;

        public C0594d(fl flVar, OnPeopleLoadedListener onPeopleLoadedListener, ConnectionResult connectionResult, C0348d c0348d, String str) {
            this.rr = flVar;
            super(flVar, onPeopleLoadedListener, c0348d);
            this.rs = connectionResult;
            this.rt = str;
        }

        protected void m1927a(OnPeopleLoadedListener onPeopleLoadedListener, C0348d c0348d) {
            onPeopleLoadedListener.onPeopleLoaded(this.rs, c0348d != null ? new PersonBuffer(c0348d) : null, this.rt);
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.a */
    final class C0634a extends fg {
        private final OnMomentsLoadedListener rq;
        final /* synthetic */ fl rr;

        public C0634a(fl flVar, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.rr = flVar;
            this.rq = onMomentsLoadedListener;
        }

        public void m2119a(C0348d c0348d, String str, String str2) {
            C0348d c0348d2;
            ConnectionResult connectionResult = new ConnectionResult(c0348d.getStatusCode(), c0348d.aM() != null ? (PendingIntent) c0348d.aM().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || c0348d == null) {
                c0348d2 = c0348d;
            } else {
                if (!c0348d.isClosed()) {
                    c0348d.close();
                }
                c0348d2 = null;
            }
            this.rr.m1243a(new C0593b(this.rr, this.rq, connectionResult, c0348d2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.c */
    final class C0635c extends fg {
        final /* synthetic */ fl rr;
        private final OnPeopleLoadedListener rv;

        public C0635c(fl flVar, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.rr = flVar;
            this.rv = onPeopleLoadedListener;
        }

        public void m2120a(C0348d c0348d, String str) {
            C0348d c0348d2;
            ConnectionResult connectionResult = new ConnectionResult(c0348d.getStatusCode(), c0348d.aM() != null ? (PendingIntent) c0348d.aM().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || c0348d == null) {
                c0348d2 = c0348d;
            } else {
                if (!c0348d.isClosed()) {
                    c0348d.close();
                }
                c0348d2 = null;
            }
            this.rr.m1243a(new C0594d(this.rr, this.rv, connectionResult, c0348d2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.e */
    final class C0636e extends fg {
        final /* synthetic */ fl rr;
        private final OnAccessRevokedListener rw;

        public C0636e(fl flVar, OnAccessRevokedListener onAccessRevokedListener) {
            this.rr = flVar;
            this.rw = onAccessRevokedListener;
        }

        public void m2121b(int i, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            this.rr.m1243a(new C0461f(this.rr, this.rw, new ConnectionResult(i, pendingIntent)));
        }
    }

    public fl(Context context, fn fnVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, fnVar.cZ());
        this.rp = fnVar;
    }

    public boolean m1929Y(String str) {
        return Arrays.asList(aY()).contains(str);
    }

    protected void m1930a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.ro = fv.m1980e(bundle.getByteArray("loaded_person"));
        }
        super.m1241a(i, iBinder, bundle);
    }

    protected void m1931a(dj djVar, C0582d c0582d) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_id", this.rp.df());
        bundle.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.rp.da());
        djVar.m374a(c0582d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.rp.dd(), this.rp.dc(), aY(), this.rp.getAccountName(), bundle);
    }

    public void m1932a(OnPeopleLoadedListener onPeopleLoadedListener, Collection<String> collection) {
        bc();
        fh c0635c = new C0635c(this, onPeopleLoadedListener);
        try {
            ((fk) bd()).m604a(c0635c, new ArrayList(collection));
        } catch (RemoteException e) {
            c0635c.m2120a(C0348d.m1092r(8), null);
        }
    }

    public void m1933a(OnPeopleLoadedListener onPeopleLoadedListener, String[] strArr) {
        m1932a(onPeopleLoadedListener, Arrays.asList(strArr));
    }

    protected String ag() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected fk ar(IBinder iBinder) {
        return C0460a.aq(iBinder);
    }

    public void clearDefaultAccount() {
        bc();
        try {
            this.ro = null;
            ((fk) bd()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        bc();
        try {
            return ((fk) bd()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        bc();
        return this.ro;
    }

    public void loadMoments(OnMomentsLoadedListener listener) {
        loadMoments(listener, 20, null, null, null, "me");
    }

    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        bc();
        Object c0634a = listener != null ? new C0634a(this, listener) : null;
        try {
            ((fk) bd()).m600a(c0634a, maxResults, pageToken, targetUrl, type, userId);
        } catch (RemoteException e) {
            c0634a.m2119a(C0348d.m1092r(8), null, null);
        }
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        bc();
        Object c0635c = new C0635c(this, listener);
        try {
            ((fk) bd()).m599a(c0635c, 1, orderBy, -1, pageToken);
        } catch (RemoteException e) {
            c0635c.m2120a(C0348d.m1092r(8), null);
        }
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        loadVisiblePeople(listener, 0, pageToken);
    }

    protected /* synthetic */ IInterface m1934p(IBinder iBinder) {
        return ar(iBinder);
    }

    public void removeMoment(String momentId) {
        bc();
        try {
            ((fk) bd()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        bc();
        clearDefaultAccount();
        Object c0636e = new C0636e(this, listener);
        try {
            ((fk) bd()).m605b(c0636e);
        } catch (RemoteException e) {
            c0636e.m2121b(8, null);
        }
    }

    public void writeMoment(Moment moment) {
        bc();
        try {
            ((fk) bd()).m597a(ec.m1306a((fs) moment));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
