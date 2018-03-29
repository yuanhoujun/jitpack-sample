package com.youngfeng.library;

/**
 * This is a short description.
 *
 * @author Scott Smith 2018-03-29 16:36
 */
public class JitPack {
    private static JitPack instance;

    public static synchronized JitPack get() {
        if (null == instance) instance = new JitPack();
        return instance;
    }

    public void pack() {
        println("Pack api is working");
    }

    public void unPack() {
        println("Unpack api is working");
    }

    private void println(String msg) {
        System.out.println("" + msg);
    }
}
