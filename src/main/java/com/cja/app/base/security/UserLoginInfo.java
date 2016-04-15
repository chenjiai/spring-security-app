/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cja.app.base.security;

/**
 * 用户登录信息<br>
 * 该内只在netbank.firm.base.security及其子包内使用<br>
 * 外部包不允许调用
 * 
 * @author rabbit
 * @copy by wizard
 */
public class UserLoginInfo {

    /**
     * 企业客户号
     */
    private String cbn;
    /**
     * 证书DN号
     */
    private String dniso;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否需要登录短信认证
     */
    private Boolean needNote;
    /**
     * 用户登录密码加密随机串
     */
    private String passwordRandToken;
    /**
     *  国际化信息
     */
    private String locale;
    public String getCbn() {
        return cbn;
    }

    public void setCbn(String cbn) {
        this.cbn = cbn;
    }

    public String getDniso() {
        return dniso;
    }

    public void setDniso(String dniso) {
        this.dniso = dniso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean isNeedNote() {
        return needNote;
    }

    public void setNeedNote(Boolean needNote) {
        this.needNote = needNote;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

	public String getPasswordRandToken() {
		return passwordRandToken;
	}

	public void setPasswordRandToken(String passwordRandToken) {
		this.passwordRandToken = passwordRandToken;
	}
    
    
    
}
