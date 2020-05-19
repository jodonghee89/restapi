package com.api.restapi.common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApiCustomStatus {

    REQUEST_SUCCESS(0, "정상적으로 처리되었습니다."),

    LOGIN_FAILED(1101, "아이디, 비밀번호를 확인해주세요."),

    PARAMETER_REQUIRED(2001, "필수 파라미터 없음 ({파라미터명})"),
    PARAMETER_INVALID(2002, "파라미터 검증 오류 ({파라미터명})"),

    DATA_NOT_FOUND(3001, "처리할 데이터를 찾을수 없습니다."),
    DATA_NOT_EXIST(3002, "데이터가 없습니다."),

    // System ERROR - 9xxx
    INTERNAL_SERVER_ERROR(9000, "예기치 못한 서버에러가 발생했습니다. 재시도 또는 개발팀에 문의하시기 바랍니다."),
    DATABASE_ACCESS_ERROR(9001, "Database Access 중 에러가 발생했습니다. 개발팀에 문의하시기 바랍니다."),
    JSON_BIND_ERROR(9002, "JSON 양식이 잘못되었습니다. 확인 후 다시 시도해주세요."),
    CATEGORIZED_SCAN_NOT_COMPLETED(9100, "존재하지 않는 송장번호입니다."),
    SOME_DATA_NOT_UPDATED(9101, "요청건이 일부만 처리되었습니다. 메세지 확인 후 재처리 하시기 바랍니다."),
    FILE_UPLOAD_FAILED(9010, "파일업로드가 실패하였습니다. 재시도시 계속 실패하면 개발팀에 문의하시기 바랍니다.");


    private final int code;
    private final String message;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public String toString() {
        return Integer.toString(this.code);
    }


    public static ApiCustomStatus valueOf(int statusCode) {
        ApiCustomStatus[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ApiCustomStatus customStatus = var1[var3];
            if (customStatus.code == statusCode) {
                return customStatus;
            }
        }

        throw new IllegalArgumentException("No matching message for [" + statusCode + "]");
    }

}
