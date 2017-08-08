package ssm.entity;

import ssm.entity.base.Entity;

public class UserInfo extends Entity{
    private String userId;

    private String loginName;

    private String passWord;

    private String nickName;

    private Integer phone;

    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord = password == null ? null : password.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickname) {
        this.nickName = nickname == null ? null : nickname.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTableName() {
        return "userinfo";
    }

    public String getPrimaryKey() {
        return "userId";
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid='" + userId + '\'' +
                ", loginname='" + loginName + '\'' +
                ", password='" + passWord + '\'' +
                ", nickname='" + nickName + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}