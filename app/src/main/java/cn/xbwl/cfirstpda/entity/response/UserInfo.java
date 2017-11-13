package cn.xbwl.cfirstpda.entity.response;

/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 */

public class UserInfo {

    /**
     * userName : 叶小燕
     * deptId : 247
     * deptName : 广州汽运中心
     * jobnum : 7609
     * token : fb96cbb8ff2649d8bf9d13cad9ac82b9
     */

    private String userName;
    private String deptId;
    private String deptName;
    private String jobnum;
    private String token;
    //登录成功，保存密码和账号
    private String pwd;
    private String account;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
