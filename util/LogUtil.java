package com.accessibility.keylogger.util;

import android.support.annotation.Nullable;
import android.util.Log;

import com.accessibility.keylogger.envr.AppEnvr;

public class LogUtil {
    private static final String TAG = LogUtil.class.getName();

    // Verbose
    public static void v(@Nullable String tag, @Nullable String msg) {
        if (!AppEnvr.LOG_V) {
            return;
        }

        if (msg == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.v(tag, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.v(TAG, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }

    public static void v(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        if (!AppEnvr.LOG_V) {
            return;
        }

        if (msg == null || tr == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.v(tag, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.v(TAG, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }
    // - Verbose

    // Debug
    public static void d(@Nullable String tag, @Nullable String msg) {
        if (!AppEnvr.LOG_D) {
            return;
        }

        if (msg == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.d(tag, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.d(TAG, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }

    public static void d(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        if (!AppEnvr.LOG_D) {
            return;
        }

        if (msg == null || tr == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.d(tag, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.d(TAG, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }
    // - Debug

    // Info
    public static void i(@Nullable String tag, @Nullable String msg) {
        if (!AppEnvr.LOG_I) {
            return;
        }

        if (msg == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.i(tag, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.i(TAG, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }

    public static void i(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        if (!AppEnvr.LOG_I) {
            return;
        }

        if (msg == null || tr == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.i(tag, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.i(TAG, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }
    // - Info

    // Warn
    public static void w(@Nullable String tag, @Nullable String msg) {
        if (!AppEnvr.LOG_W) {
            return;
        }

        if (msg == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.w(tag, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.w(TAG, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }

    public static void w(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        if (!AppEnvr.LOG_W) {
            return;
        }

        if (msg == null || tr == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.w(tag, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.w(TAG, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }
    // - Warn

    // Error
    public static void e(@Nullable String tag, @Nullable String msg) {
        if (!AppEnvr.LOG_E) {
            return;
        }

        if (msg == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.w(tag, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.w(TAG, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }

    public static void e(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        if (!AppEnvr.LOG_E) {
            return;
        }

        if (msg == null || tr == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.e(tag, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        } else {
            try {
                Log.e(TAG, msg, tr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());

                e.printStackTrace();
            }
        }
    }
    // - Error

    // What a Terrible Failure
    public static void wtf(@Nullable String tag, @Nullable String msg) {
        if (!AppEnvr.LOG_WTF) {
            return;
        }

        if (msg == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.wtf(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Log.wtf(TAG, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void wtf(@Nullable String tag, @Nullable String msg, @Nullable Throwable tr) {
        if (!AppEnvr.LOG_WTF) {
            return;
        }

        if (msg == null || tr == null) {
            return;
        }

        if (tag != null) {
            try {
                Log.wtf(tag, msg, tr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Log.wtf(TAG, msg, tr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // - What a Terrible Failure
}
