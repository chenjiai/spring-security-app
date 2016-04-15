package com.cja.app.base.security.providers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


public class CustomAuthenticationFailHandler extends
		SimpleUrlAuthenticationFailureHandler {
    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";
    
    //@Resource(name="core.operationLogService")
    //private OperationLogService operationLogService;

//	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		//密码错误做重试次数加1处理
//		boolean isLoginPwdErr = isLoginPwdErr(exception);
//		if(isLoginPwdErr){
//			String userNo =request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
//			
//			if(StringUtils.isNotBlank(userNo)){
//				if (logger.isDebugEnabled()) {
//					logger.debug(MessageFormat.format("登录认证失败[{1}]:[loginName={0}].",userNo, new Date()));
//				}
//				//登入错误次数+1 并且写入操作日志
//				increaseRetryAndWriteLog(request,userNo);
//			}
//			
//			//密码错误不能直接提示
//			exception = new BadCredentialsException(CoreErrCode.LOGIN_FAIL,"登录失败, 请输入正确的用户名和密码!");
//		}
		
		super.onAuthenticationFailure(request, response, exception);

	}
	
//	private boolean isLoginPwdErr(AuthenticationException exception){
//		boolean flag=false;
//		if(exception!=null&&(exception instanceof BadCredentialsException)){
//			String errMsg= exception.getMessage();
//			flag =  CoreErrCode.CRM_LOGIN_PASSWORD_ERR.equals(errMsg);
//		}
//		return flag;
//	}
//	
//	private void increaseRetryAndWriteLog(HttpServletRequest request,String userNo){
//		Operator operator = operatorDao.getOperatorByUser(userNo);
//		increaseOperatorRetryCountByUserNo(operator);
//		loginFail(operator, request);
//	}
//	
//	private void increaseOperatorRetryCountByUserNo(Operator operator){
//		 
//		 if(operator!=null){
//			 int retryCount = operator.getRetryCount()+1;
//			 operator.setRetryCount(retryCount);
//			 Date now = new Date();
//			 operator.setUpdateTime(now);
//			 operator.setLastFailTime(now);
//			 operatorDao.update(operator);
//		 }
//	}
//	/**
//	 * 登入失败记录日志
//	 * */
//	private void loginFail(Operator operator, HttpServletRequest request){
//		if(operator!=null){
//			OperationLog log = new OperationLog();//
//	        log.setClientIp(IPAddressUtil.getClientIp(request));
//	        log.setAgent(request.getHeader("User-Agent"));
//	        log.setContent("登录失败");
//	        log.setModule("");
//	        log.setBranchNo(operator.getBranchNo());
//	        log.setUserNo(operator.getUserNo());
//	        log.setAccountNo("");
//	        log.setBizServiceNo("");
//	        log.setBizCode("LOGININFO");
//	        log.setActionType(99);
//	        operationLogService.addOperationLog(log);
//        }
//	}
	
}
