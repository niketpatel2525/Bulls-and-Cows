package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.internal.C0174g.C0508a;

public interface ILocationSourceDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.ILocationSourceDelegate.a */
    public static abstract class C0488a extends Binder implements ILocationSourceDelegate {

        /* renamed from: com.google.android.gms.maps.internal.ILocationSourceDelegate.a.a */
        private static class C0487a implements ILocationSourceDelegate {
            private IBinder dG;

            C0487a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public void activate(C0174g listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void deactivate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0488a() {
            attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
        }

        public static ILocationSourceDelegate m1542M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ILocationSourceDelegate)) ? new C0487a(iBinder) : (ILocationSourceDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    activate(C0508a.m1559R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    deactivate();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void activate(C0174g c0174g) throws RemoteException;

    void deactivate() throws RemoteException;
}
