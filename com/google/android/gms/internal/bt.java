package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.by.C0406a;
import com.google.android.gms.internal.de.C0582d;

public class bt extends de<by> {
    private final int gz;

    public bt(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.gz = i;
    }

    protected void m1802a(dj djVar, C0582d c0582d) throws RemoteException {
        djVar.m381g(c0582d, this.gz, getContext().getPackageName(), new Bundle());
    }

    protected String ag() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public by ai() {
        return (by) super.bd();
    }

    protected by m1803o(IBinder iBinder) {
        return C0406a.m1207q(iBinder);
    }

    protected /* synthetic */ IInterface m1804p(IBinder iBinder) {
        return m1803o(iBinder);
    }
}
