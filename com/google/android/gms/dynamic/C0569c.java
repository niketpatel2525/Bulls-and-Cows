package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0070b.C0357a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.c */
public final class C0569c<T> extends C0357a {
    private final T mh;

    private C0569c(T t) {
        this.mh = t;
    }

    public static <T> T m1772b(C0070b c0070b) {
        if (c0070b instanceof C0569c) {
            return ((C0569c) c0070b).mh;
        }
        IBinder asBinder = c0070b.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0070b m1773g(T t) {
        return new C0569c(t);
    }
}
