package com.cja.app.base.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户登陆后的session上下文信息
 * 
 */
public class SessionContext extends Hashtable<String, Object> implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	public final static String KEY_USER_NO = "USRID";// 操作员工号
	public final static String KEY_USERNAME = "NAME";// 操作员名称
	public final static String KEY_PASSWORD = "PWD";// 密码
	public final static String KEY_SYSROLE = "USRTYPE";// 系统操作员类型
	
	
	public final static String KEY_MENUS = "MENUS";//操作员拥有菜单
	
	public final static String KEY_FAIL_TIME = "FAILTIME";// 最近失败时间
	public final static String KEY_SUCC_TIME = "SUCCTIME";// 最近成功时间
	public final static String KEY_LOCALE = "LOCALE";// 多语言设置(中文、英文等)
	
	public final static String RESET_PASSWORD_TIME="RESETPASSWORDTIME"; //更新密码时间
	public final static String RESET_PASSWORD="RESETPASSWORD"; //首次登入密码是否修改
	
	private static boolean disabled;


	public SessionContext() {
		super();
	}

	public SessionContext(int initialCapacity) {
		super(initialCapacity);
	}

	public SessionContext(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public SessionContext(Map<String, Object> map) {
		super(map);
	}

	
	/**
	 * 设置操作员工号
	 * @param userNo
	 */
	public void setUserNo(String userNo) {
		this.put(KEY_USER_NO, userNo);
	}

	/**
	 * 获取操作员工号
	 * @return
	 */
	public String getUserNo() {
		return (String) this.get(KEY_USER_NO);
	}

	/**
	 * 设置操作员姓名
	 * @param userNo
	 */
	public void setUserName(String userName) {
		this.put(KEY_USERNAME, userName);
	}

	/**
	 * 获取操作员姓名
	 * @return
	 */
	public String getUserName() {
		return (String) this.get(KEY_USERNAME);
	}

	/**
	 * 设置操作员密码
	 * @param userNo
	 */
	public void setUserPassword(String password) {
		this.put(KEY_PASSWORD, password);
	}

	/**
	 * 获取操作员密码
	 * @return
	 */
	public String getUserPassword() {
		return (String) this.get(KEY_PASSWORD);
	}
	
	/**
	 * 设置系统管理角色
	 * @param userNo
	 */
	public void setSystemRole(String role) {
		this.put(KEY_SYSROLE, role);
	}

	/**
	 * 获取系统管理角色
	 * @return
	 */
	public String getSystemRole() {
		return (String) this.get(KEY_SYSROLE);
	}
	
	/**
	 * 获取上次失败时间
	 * @return
	 */
	public Date getLastFailTime() {
		return (Date) this.get(KEY_FAIL_TIME);
	}

	/**
	 * 获取上次成功时间
	 * @return
	 */
	public Date getLastSuccTime() {
		return (Date) this.get(KEY_SUCC_TIME);
	}

	/**
	 * 设置失败时间
	 * @param lastFailTime
	 */
	public void setLastFailTime(Date lastFailTime) {
		this.put(KEY_FAIL_TIME, lastFailTime);
	}

	/**
	 * 设置成功时间
	 * @param lastSuccTime
	 */
	public void setLastSuccTime(Date lastSuccTime) {
		this.put(KEY_SUCC_TIME, lastSuccTime);
	}
	
	
	
	/**
	 * 是否密码更新时间超过180
	 * @return
	 */
	public Boolean getisUpPasswordTimeOver() {
		return (Boolean) this.get(RESET_PASSWORD_TIME);
	}
	/**
	 * 设置密码更新时间是否超过180
	 * @param upPasswordTime
	 */
	public void setisUpPasswordTimeOver(boolean isUpPasswordTimeOver) {
		this.put(RESET_PASSWORD_TIME,isUpPasswordTimeOver);
	}
	/**
	 * 获取是否重置初始密码
	 * @param upPasswordTime
	 */
	public boolean getisInitPassword() {
		return  (Boolean) this.get(RESET_PASSWORD);
	}
	/**
	 * 设置 是否初始化初始密码
	 * @param upPasswordTime
	 */
	public void setisInitPassword(boolean initPassword) {
		this.put(RESET_PASSWORD, initPassword);
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new GrantedAuthorityImpl((String) this.get(KEY_SYSROLE)));
		return grantedAuthorities;
	}

	public String getAuthoritiesString() {
		List<String> authorities = new ArrayList<String>();
		for (GrantedAuthority authority : this.getAuthorities()) {
			authorities.add(authority.getAuthority());
		}
		return StringUtils.join(authorities, ",");
	}

	public String getPassword() {
		return (String) this.get(KEY_PASSWORD);
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return !disabled;
	}

	public static void setDisabled(boolean disabled) {
		SessionContext.disabled = disabled;
	}

	public String getMachineFlag() {
		return "";
	}

	public void setLocale(Locale locale) {
		this.put(KEY_LOCALE, locale);
	}

	public Locale getLocale() {
		return (Locale) this.get(KEY_LOCALE);
	}

	@Override
	public boolean equals(Object that) {
		if (null == that) {
			return false;
		}
		if (that == this) {
			return true;
		}
		if (this.getClass() == that.getClass()) {
			SessionContext sc = (SessionContext) that;
			return this.getUserNo().equals(sc.getUserNo());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getUserNo().hashCode();
	}
	
	public String getUsername() {
		return (String) this.get(KEY_USER_NO);
	}
}
