package com.spartacus.house.exception;

import com.spartacus.house.result.ResultCode;

public class ServiceException extends RuntimeException {
    private int code;
    private String extraMessage;

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }


    public ServiceException(String message, Throwable cause) {

    }

    public ServiceException(int code, String message, String extraMessage, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.extraMessage = extraMessage;
    }


    public ServiceException(ResultCode resultCode, String extraMessage) {
        this(resultCode.getCode(), resultCode.getMessage(), extraMessage, null);
    }

    public ServiceException(String extraMessage) {
        this(ResultCode.INVALID_PARAM, extraMessage);
    }


    public int getCode() {
        return code;
    }

    public String getExtraMessage() {
        return extraMessage;
    }
}

