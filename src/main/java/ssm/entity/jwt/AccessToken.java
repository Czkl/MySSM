package ssm.entity.jwt;

import ssm.entity.base.Entity;

import java.util.Date;

public class AccessToken  extends Entity{

    private String access_token;
    private String userId;
    private Date expiration_date;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getTableName() {
        return "access_token";
    }

    public String getPrimaryKey() {
        return "access_token";
    }
}
