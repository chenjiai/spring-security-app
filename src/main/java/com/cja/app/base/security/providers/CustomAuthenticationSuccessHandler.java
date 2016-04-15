package com.cja.app.base.security.providers;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.intensoft.navigator.menu.MenuRepository;

public class CustomAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	//    /**
	//     * 操作员DAO
	//     */
	//    @Resource(name = "core.mngTellerDao")
	//    private MngTellerDao mngTellerDao;
	    
	//    
	//    @Resource(name="core.operationLogService")
	//    private OperationLogService operationLogService;
	//    
	//    @Resource(name="core.sessionStateService")
	//    private SessionStateService sessionStateService;
	//	
	 @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	            Authentication authentication) throws ServletException, IOException {
		 super.onAuthenticationSuccess(request, response, authentication);
	 }
	//	 	 
	//	 private void resetOperatorTryCountByUserNo(Operator operator){ 
	//		 if(operator.getRetryCount()>0){
	//			 operator.setRetryCount(0);
	//			 Date now = new Date();
	//			 operator.setUpdateTime(now);
	//			 operator.setLastSuccTime(now);
	//			 operatorDao.update(operator);
	//		 }
	//	 }
	//	 
	//	/**
	//	 * 登录成功记录日志
	//	 * */
	//	private void loginSucess(SessionContext sessionContext,
	//			HttpServletRequest request) {
	//		OperationLog log = new OperationLog();//
	//		log.setClientIp(IPAddressUtil.getClientIp(request));
	//		log.setAgent(request.getHeader("User-Agent"));
	//		log.setContent("登录成功");
	//		log.setModule("");
	//		log.setBranchNo(sessionContext.getBranchNo());
	//		log.setUserNo(sessionContext.getUserNo());
	//		log.setAccountNo("");
	//		log.setBizServiceNo("");
	//		log.setBizCode("LOGININFO");
	//		log.setActionType(99);
	//		operationLogService.addOperationLog(log);
	//	}
	//	/**
	//	 * 登入成功 更新t_ses_pwd_state表
	//	 * */
	//	private void updateSessionState(Operator operator,HttpServletRequest request){
	//		SessionState state=new SessionState();
	//		String sessionStr=request.getSession().getId();
	//		state.setOid(operator.getUserNo());
	//		state.setSessionStr(sessionStr.substring(sessionStr.length()-20,sessionStr.length()));
	//		state.setIsOnline("Y");
	//		sessionStateService.update(state);
	//	}

}
