package com.cja.app.base.security.providers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;

public class DESPasswordEncoder extends BasePasswordEncoder {

	public String encodePassword(String rawPass, Object salt) throws DataAccessException {
		String encodePassword = null;
		// try {
		// if(salt instanceof String){
		// salt = ((String) salt).trim();
		// }
		// encodePassword = DESCrypto.calcuPassword((String)salt, rawPass);
		// } catch (Exception e) {
		// throw new BadCredentialsException(e.getMessage());
		// }
		return encodePassword;
	}

	public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws DataAccessException {
		boolean flag = false;
		// try
		// {
		// String pass1 = ""+encPass;
		// String pass2 = encodePassword(rawPass, salt);
		// if(pass1.equals(pass2)){
		// flag = true;
		// }else{//为方便蜜橘错误时做重试次数加1处理，抛出特定异常。
		// throw new
		// BadCredentialsException(ManageErrCode.CRM_LOGIN_PASSWORD_ERR);
		// }
		// }catch(BadCredentialsException e) {
		// throw e;
		// }catch (Exception e) {
		// throw new BadCredentialsException(e.getMessage());
		// }
		return flag;
	}

}
