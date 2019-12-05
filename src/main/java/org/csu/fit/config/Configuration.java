package org.csu.fit.config;

public class Configuration {

    /* 录音使用到的参数 */
    public static final boolean METHOD_RAW = false; // 默认以json方式上传音频文件
    //  填写网页上申请的appkey
    public static final String APP_KEY = "ImktfB4y3i0hoH4rxsHpV7el";
    // 填写网页上申请的APP SECRET
    public static final String SECRET_KEY = "hkGEmfwezu151CRXPL55jlYZzp6R5DFG";
    // 需要识别的文件
    public static final String FILENAME = "E:\\test.wav";
    // 文件格式, 支持pcm/wav/amr 格式，极速版额外支持m4a 格式
    public static final String FORMAT = FILENAME.substring(FILENAME.length() - 3);
    public static final String CUID = "1234567JAVA";
    // 采样率固定值
    public static final int RATE = 16000;
    // URL
    public static final String URL = "http://vop.baidu.com/server_api"; // 可以改为https
    //  1537 表示识别普通话，使用输入法模型。1536表示识别普通话，使用搜索模型。 其它语种参见文档
    public static final int DEV_PID = 1537;

    public static final String SCOPE = "audio_voice_assistant_get";


}
