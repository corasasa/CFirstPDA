package cn.xbwl.cfirstpda.entity.response;


public class LoginResult {


    /**
     * reason :
     * data : {"userName":"张发康","deptId":"793","deptName":"广州白云服务中心","jobnum":"6412","token":"697b9263ee444c24872fee1a1690798c"}
     * success : true
     */

    private String reason;
    private DataBean data;
    private boolean success;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * userName : 张发康
         * deptId : 793
         * deptName : 广州白云服务中心
         * jobnum : 6412
         * token : 697b9263ee444c24872fee1a1690798c
         */

        private String userName;
        private String deptId;
        private String deptName;
        private String jobnum;
        private String token;

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
    }
}
