/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cja.app.base.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * AsOne定名称<br>
 * 该内只在netbank.firm.base.security及其子包内使用<br>
 * 外部包不允许调用
 * 
 * @author AsOne
 * @copy by wizard
 */
public final class SecurityUserHolder {

	private static final ThreadLocal<UserLoginInfo> USER_LOGIN_INFOR_TL = new ThreadLocal<UserLoginInfo>() {

		@Override
		protected UserLoginInfo initialValue() {
			return new UserLoginInfo();
		}
	};

	public static UserLoginInfo getUserLoginInfo() {
		return USER_LOGIN_INFOR_TL.get();
	}

	public static void setUserLoginInfo(UserLoginInfo info) {
		USER_LOGIN_INFOR_TL.set(info);
	}

	public static void cleanUserLoginInfo() {
		USER_LOGIN_INFOR_TL.remove();
	}

	public static String getCbn() {
		return getUserLoginInfo().getCbn();
	}

	public static void setCbn(String cbn) {
		getUserLoginInfo().setCbn(cbn);
	}

	public static String getDNISO() {
		return getUserLoginInfo().getDniso();
	}
	
	public static void setPasswordRandToken(String randToken){
		getUserLoginInfo().setPasswordRandToken(randToken);
	}
	public static String getPasswordRandToken(){
		return getUserLoginInfo().getPasswordRandToken();
	}

	public static void setDNISO(String dniso) {
		getUserLoginInfo().setDniso(dniso);
	}

	public static String getPassword() {
		return getUserLoginInfo().getPassword();
	}

	public static void setPassword(String password) {
		getUserLoginInfo().setPassword(password);
	}

	public static String getUserName() {
		return getUserLoginInfo().getUserName();
	}

	public static void setUserName(String userName) {
		getUserLoginInfo().setUserName(userName);
	}

	public static Boolean isNeedNote() {
		return getUserLoginInfo().isNeedNote();
	}

	public static void setNeedNote(Boolean needNote) {
		getUserLoginInfo().setNeedNote(needNote);
	}

	/**
	 * 返回当前用户信息
	 * 
	 * @return userContext 实现spring security 's userDetails
	 */
	public static SessionContext getCurrentUser() {
		if (SecurityContextHolder.getContext() == null) {
			return null;
		}
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			return null;
		}
		return (SessionContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
