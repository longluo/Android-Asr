package org.vosk;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class LibVosk {

    static {
        Native.register(LibVosk.class, "vosk");
    }

    public static native void vosk_set_log_level(int level);

    public static native Pointer vosk_model_new(String path);

    public static native void vosk_model_free(Pointer model);

    public static native Pointer vosk_spk_model_new(String path);

    public static native void vosk_spk_model_free(Pointer model);

    public static native Pointer vosk_recognizer_new(Model model, float sample_rate);

    public static native Pointer vosk_recognizer_new_spk(Pointer model, float sample_rate, Pointer spk_model);

    public static native Pointer vosk_recognizer_new_grm(Pointer model, float sample_rate, String grammar);

    public static native void vosk_recognizer_set_max_alternatives(Pointer recognizer, int max_alternatives);

    public static native void vosk_recognizer_set_words(Pointer recognizer, boolean words);

    public static native void vosk_recognizer_set_partial_words(Pointer recognizer, boolean partial_words);

    public static native void vosk_recognizer_set_spk_model(Pointer recognizer, Pointer spk_model);

    public static native boolean vosk_recognizer_accept_waveform(Pointer recognizer, byte[] data, int len);

    public static native boolean vosk_recognizer_accept_waveform_s(Pointer recognizer, short[] data, int len);

    public static native boolean vosk_recognizer_accept_waveform_f(Pointer recognizer, float[] data, int len);

    public static native String vosk_recognizer_result(Pointer recognizer);

    public static native String vosk_recognizer_final_result(Pointer recognizer);

    public static native String vosk_recognizer_partial_result(Pointer recognizer);

    public static native void vosk_recognizer_set_grm(Pointer recognizer, String grammar);

    public static native void vosk_recognizer_reset(Pointer recognizer);

    public static native void vosk_recognizer_free(Pointer recognizer);

    /**
     * Set log level for Kaldi messages.
     *
     * @param loglevel the level
     *                 0 - default value to print info and error messages but no debug
     *                 less than 0 - don't print info messages
     *                 greater than 0 - more verbose mode
     */
    public static void setLogLevel(LogLevel loglevel) {
        vosk_set_log_level(loglevel.getValue());
    }
}
