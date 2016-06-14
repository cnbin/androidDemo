package cc.webservice.huaxun.wqtloginwebservice.model;

/**
 * Created by wuyongmin on 16/6/14.
 */
public class LoginModel {

    private String UserName;
    private String UserPwd;
    private String TrueName;
    private String Serils;
    private String Department;
    private String JiaoSe;
    private String ActiveTime;
    private String ZaiGang;
    private String ZhiWei;

    public String getZhiWei() {
        return ZhiWei;
    }

    public void setZhiWei(String zhiWei) {
        ZhiWei = zhiWei;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public String getSerils() {
        return Serils;
    }

    public void setSerils(String serils) {
        Serils = serils;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getJiaoSe() {
        return JiaoSe;
    }

    public void setJiaoSe(String jiaoSe) {
        JiaoSe = jiaoSe;
    }

    public String getActiveTime() {
        return ActiveTime;
    }

    public void setActiveTime(String activeTime) {
        ActiveTime = activeTime;
    }

    public String getZaiGang() {
        return ZaiGang;
    }

    public void setZaiGang(String zaiGang) {
        ZaiGang = zaiGang;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public LoginModel(String userName, String userPwd,String trueName, String serils,String department, String jiaoSe,String activeTime, String zhiWei,String zaiGang){

        setUserName(userName);
        setUserPwd(userPwd);
        setTrueName(trueName);
        setSerils(serils);
        setDepartment(department);
        setJiaoSe(jiaoSe);
        setActiveTime(activeTime);
        setZhiWei(zhiWei);
        setZaiGang(zaiGang);
    }
}
