package com.cja.app.base.security.providers;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service("menuAccessDecisionManagerBean")
public class MenuAccessDecisionManager implements AccessDecisionManager {
	private static Logger logger = LoggerFactory
			.getLogger(MenuAccessDecisionManager.class);

	//检查用户是否够权限访问资源,方法重写
    //参数authentication是从spring的全局缓存SecurityContextHolder中拿到的，里面是用户的权限信息
    //参数object是url
    //参数configAttributes所需的权限
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (configAttributes == null) {
			return;
		}

//		SessionContext sessionContext = (SessionContext) authentication
//				.getPrincipal();
//		FilterInvocation fi = (FilterInvocation) object;
//		HttpServletRequest req = fi.getHttpRequest();
//		String funId = (String) req.getAttribute(Utils.FUN_ID);
//		String url = req.getRequestURL().toString();
//
//		StringBuilder sb = null;
//		if (logger.isDebugEnabled()) {
//			sb = new StringBuilder();
//			sb.append("url=[" + url + "]\nconfig=[" + configAttributes
//					+ "]\nfunId=[" + funId + "]\nauthentication=[");
//
//			boolean b = false;
//			for (GrantedAuthority ga : authentication.getAuthorities()) {
//				if (b) {
//					sb.append(',');
//				} else {
//					b = true;
//				}
//				sb.append(ga);
//			}
//
//			sb.append(']');
//		}
//		
//		
//		if(decideByAuthentication(configAttributes,authentication,funId,sessionContext)){
//			return;
//		}
//		decideByBizAuth(funId,sessionContext);
//		
//		throw new AccessDeniedException("no right");
	}
	
	/**
	 * 根据用户角色类型检查
	 * @param configAttributes
	 * @param authentication
	 * @return
	 */
	//private boolean decideByAuthentication(Collection<ConfigAttribute> configAttributes,Authentication authentication,String funId,SessionContext sessionContext) {
		//boolean flag = false;
//		Iterator<ConfigAttribute> ite = configAttributes.iterator();
//		while (ite.hasNext()) {
//			ConfigAttribute ca = ite.next();
//			String needRole = ca.getAttribute();
//			for (GrantedAuthority ga : authentication.getAuthorities()) {
//				if (needRole.equals(ga.getAuthority())) {// ga is user's role.
//					if(RoleType.BIZ_SUBMITOR.equals(needRole)||RoleType.BIZ_GRANTOR.equals(needRole)){
//						decideByBizAuth(funId,sessionContext);
//					}
//					flag=true;
//				}
//			}
//		}
		//return flag;
	//}
//
//	/**
//	 * 根据操作员授权书检查
//	 * @param funId
//	 * @param sessionContext
//	 */
//	private void decideByBizAuth(String funId,SessionContext sessionContext) {
//		try {
//			navMenuService.validatyByContext(funId, sessionContext);
//		} catch(Exception e){
//			throw new AccessDeniedException("no right");
//		}
//	}

	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
