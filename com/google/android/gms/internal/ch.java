package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ch {
    private static final ThreadFactory hF;
    private static final ThreadPoolExecutor hG;

    /* renamed from: com.google.android.gms.internal.ch.1 */
    static class C01151 implements Runnable {
        final /* synthetic */ Runnable hH;

        C01151(Runnable runnable) {
            this.hH = runnable;
        }

        public void run() {
            Process.setThreadPriority(10);
            this.hH.run();
        }
    }

    /* renamed from: com.google.android.gms.internal.ch.2 */
    static class C01162 implements ThreadFactory {
        private final AtomicInteger hI;

        C01162() {
            this.hI = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.hI.getAndIncrement());
        }
    }

    static {
        hF = new C01162();
        hG = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), hF);
    }

    public static void execute(Runnable task) {
        try {
            hG.execute(new C01151(task));
        } catch (Throwable e) {
            cn.m293b("Too many background threads already running. Aborting task.", e);
        }
    }
}
