package io.javalin.boot.api.exception;

import io.javalin.boot.api.ApiCode;

@SuppressWarnings("serial")
public class PayException extends BizRuntimeException {

    public PayException(ApiCode code, String i18n) {
        super(code, i18n);
    }

    public PayException(int code, String i18n, String defMsg) {
        super(code, i18n, defMsg);
    }

    public PayException(int code, String msg, Throwable cause) {
        super(code, msg, cause);
    }

}
