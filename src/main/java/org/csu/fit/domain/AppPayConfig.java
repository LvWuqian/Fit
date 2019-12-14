package org.csu.fit.domain;

public class AppPayConfig {

    private String URL = "https://openapi.alipaydev.com/gateway.do";
    private String APPID = "2016101400685514";
    private String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCtlAsCjm3kCfvGSaENa891IeDMddRQ" +
            "EvyA0khvJ8aiTmzeCMGNnf2LPvxhpMm3I6DPGUN/detZ7b239KYyyOBpw0Pfv8d2CpLHv0GW4hv55ci1BXBHDR8c2InxS0b6Yy4cg89DRcG" +
            "6r1LhdZJO496gQJexDnJHn1VkvES+mGIbSPtULrG+gHJmYfr7AwlQpzJcdgrqnxejgJMIQeEsLu2SmTmsjB7CXtHGfMJma55I7jN8BgTOqU" +
            "AMW2VmjrjDpGeSEhGsyVtSFuRfotxNfNT9kUn52n36RWC/c1KvJ5KGpmiN6FGH8SRJ3hFP/HszbAPSIFoi8KxyDLfds1hyzNQzAgMBAAECgg" +
            "EAbjg2cY4di5MnU/cHFG2kE13K0Cn2Ak68FdTxd9vLDt871BW9Sf7Ls/Lv8dTg3bD6+Oay7KnlI3qKYNgx/Md/cMk0PU0bDAKUx8/Th0rWtu1" +
            "JcGEetY9IdVmu5hCF5pK6AhNUtgQCi1evCklM+VlK0XmSmTRyLranU8sU3+4FRgsZiRe11PjJV2ev0FkSbTmct11KlScNyZDeL27Jw4M7M/0" +
            "uJLC5qqRfylFKOftBEyO2zxO8p+URyrydqdrq5q9Xf4yVkvloWF0MwtnRtgp2rAL3zWMmanP/VtN0tgONKEfhBQT4L3MEb7yL8qE50nXw8e4LK" +
            "LzE//u5eDTOn5BzcQKBgQDqfm/8WYGmUdBTfbgDjY8X7CtNVm2MoczMgf3hFyMcyVVaeGKT7UnhR7dqsX2RvcLIzkaTBx5vH/tevFLWHjS3G8HA" +
            "vhpl6bn6YCxd6HO8mclXavM3C/HxVXbq3C6ouwRUyWjQkZSxdJhFJz9bdWbRYaZLO896pmyoqWwIMrubOwKBgQC9f2YxeYzcZ9TBPv8IZ8wvt566" +
            "ortoUejHiaMKsSGmQjW9pCpwMYvyODR+Ntr/P17bYLhN1nfBDzpLru+0f8ltmc1N3YuMQmFfizfXk1/qOy65UKyBcQh9v5ZNvpWOqPym5Y0C8AFX+" +
            "gKhO2Ox609e8OeGoI8CQ2fAMXDjIWHraQKBgHLD/PUJrX2ELyydrBD5GF6B9NN+CFG64qv4txOSKlotY3vKzZxOl0kNu4QZaDaLJCj5Y+sTod6LTZCZ" +
            "JQWsdOplSFeX8v2L/by/kxdG7FYTAkqpim2XiAswY+ogZymnlkAU7xqdFaQgR2IZClYtyGuTmjraA/qoNyf4+2mrwsv/AoGBALyUAtvrbW2NeqFRErW" +
            "HriAyaCitdzjKgo/H/dPPEICG1TpDG+SIug8zNbIA3xEyPDCu4Nq9OnGKuOXGUk9a99Y1P6VketH64TIWtly3EbVkbgwHJ5StKtkRBv+ZUPYmXz+roxew" +
            "RnYJnAJdusm9NUBzFsTYFVkYQTB3QzMU7oA5AoGBAKdjVZjjf2exhjRcsymS6ws7cpg7Y4wsfeBJKmzHAdQKVzjjll6Hgt5NYhNiSApko8X2db0j" +
            "nNbbxpGxxZc6NPUhNVbs9llu3Yf/Cj4XIDMXWLZiDRl3yRm41DspB+fvTxCTpZSIWoZHUrrCX4rLFI+t+QJtWzCzFctFcQHAt3m0";
    private String FORMAT = "json";
    private String CHARSET = "utf-8";
    private String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArZQLAo5t5An7xkmhDWvPdSHgzHXUUBL8gNJI" +
            "byfGok5s3gjBjZ39iz78YaTJtyOgzxlDf3XrWe29t/SmMsjgacND37/HdgqSx79BluIb+eXItQVwRw0fHNiJ8UtG+mMuHIPPQ0XBuq9S4XWS" +
            "TuPeoECXsQ5yR59VZLxEvphiG0j7VC6xvoByZmH6+wMJUKcyXHYK6p8Xo4CTCEHhLC7tkpk5rIwewl7RxnzCZmueSO4zfAYEzqlADFtlZo6" +
            "4w6RnkhIRrMlbUhbkX6LcTXzU/ZFJ+dp9+kVgv3NSryeShqZojehRh/EkSd4RT/x7M2wD0iBaIvCscgy33bNYcszUMwIDAQAB";
    private String SIGN_TYPE = "RSA2";

    public String getURL() {
        return URL;
    }

    public String getAPPID() {
        return APPID;
    }

    public String getAPP_PRIVATE_KEY() {
        return APP_PRIVATE_KEY;
    }

    public String getFORMAT() {
        return FORMAT;
    }

    public String getCHARSET() {
        return CHARSET;
    }

    public String getALIPAY_PUBLIC_KEY() {
        return ALIPAY_PUBLIC_KEY;
    }

    public String getSIGN_TYPE() {
        return SIGN_TYPE;
    }
}
