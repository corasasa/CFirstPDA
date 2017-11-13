package cn.xbwl.cfirstpda.entity.response;

/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 */

public class HttpResult<T> {

    /**
     * reason :
     * success : true
     * data : {"userName":"叶小燕","deptId":"247","deptName":"广州汽运中心","jobnum":"7609","token":"fb96cbb8ff2649d8bf9d13cad9ac82b9"}
     */

    private String reason;
    private boolean success;
    private T data;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
