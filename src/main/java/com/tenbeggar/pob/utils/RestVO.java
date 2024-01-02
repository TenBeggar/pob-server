package com.tenbeggar.pob.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestVO<T> {

    private Integer code;
    private T data;
    private String msg;

    public static RestVO<Void> OK() {
        return OK(null);
    }

    public static <T> RestVO<T> OK(T data) {
        return new RestVO<>(HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
    }

    public static RestVO<Void> ERROR(Integer code, String msg) {
        return new RestVO<>(code, null, msg);
    }

    public static RestVO<Void> ERROR(HttpStatus httpStatus, String msg) {
        return ERROR(httpStatus.value(), msg);
    }

    public static RestVO<Void> ERROR(HttpStatus httpStatus) {
        return ERROR(httpStatus, httpStatus.getReasonPhrase());
    }
}
