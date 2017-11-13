package cn.xbwl.cfirstpda.exception;

/**
 * Created by chenjinglan on 2017/10/27.
 * email:13925024285@163.com
 * 全局异常捕获
 */

public class ApiException extends RuntimeException {
    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
