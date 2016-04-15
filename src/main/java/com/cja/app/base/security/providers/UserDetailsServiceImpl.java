package com.cja.app.base.security.providers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 功能: <br/>
 * 用户信息读取类，存储用户细节。
 * @author wot_chenjiai
 * @since 2016-3-16
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Logger logger = LoggerFactory
            .getLogger(UserDetailsServiceImpl.class);

    /**
     * 获取用户Details信息的回调函数.
     */
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException, DataAccessException {
//        // String password = SecurityContextHolder.getPassword();
//        // TODO 实现从数据库获取用户对象的业务逻辑
//
//        /**
//         * *
//         * wizard begin 这里开发人员可根据实际业务情况，从数据库读取用户信息赋值给User对象。 例如： Saccount
//         * account = UserManager.getUserByName(userName);
//         * 如果用户不存在可以抛出UsernameNotFoundException; authSet
//         * 是用户的资源集合，可通过配置用户和资源的多对多的关系来获取。 详情可参见用户使用说明手册。
//         */
//        // 1-简单值校验
//        if (StringUtils.isBlank(userName)) {
//            throw new BadCredentialsException(ManageErrCode.LOGIN_FAIL, "登录异常，登录信息不完整！");
//        }
//
//        MngTeller teller = null;
//
//        try {
//        	teller = checkOperatorByName(userName);
//        } catch (BadCredentialsException e) {
//            logger.warn(MessageFormat.format("登录异常，loginName={0}, errCode={1}", userName, e.getMessage()), e);
//            throw e;
//        } catch (Exception et) {
//            logger.error(MessageFormat.format("登录异常，loginName={0}, errCode={1}", userName, et.getMessage()), et);
//            throw new BadCredentialsException(ManageErrCode.SYSTEM_FAIL);
//        }
//
//        SessionContext sessionContext = new SessionContext();
//
//
//        sessionContext.setUserName(teller.getTellerName());
//        sessionContext.setUserNo(teller.getIdTeller());
//        sessionContext.setUserPassword(teller.getPwdCipher());
//        sessionContext.setSystemRole(String.valueOf(teller.getTellerType()));
//        sessionContext.setBranchNo(teller.getDepartNo());
//        
//        List<Integer> authMenuIds =  MngTellerAuthDao.getAuthByTeller(teller.getIdTeller());
//        
////        System.out.println("列表长度:" + authMenuIds.size());
////        for(int i = 0 ; i<authMenuIds.size() ; i++){
////        	System.out.println("该柜员编号的菜单集合:"+authMenuIds.get(i));
////        }
//
//        sessionContext.setUserAuthMenuIdList(authMenuIds);
//        
//		//        // 设置时间
//		//        if (operator.getLastFailTime() != null) {
//		//            sessionContext.setLastFailTime(operator.getLastFailTime());
//		//        }
//		//        if (operator.getLastSuccTime() != null) {
//		//            sessionContext.setLastSuccTime(operator.getLastSuccTime());
//		//        }
//        
//        /**
//         * 放入密码重置时间是否超过，密码是否重置
//         * */
//		//        sessionContext.setisInitPassword(operator.isInitPassword());
//		//        sessionContext.setisUpPasswordTimeOver(operator.isModifyPassword());
//
//        
//        /**
//         * wizard end
//         */
//        return sessionContext;
    	return null;
    }
}
