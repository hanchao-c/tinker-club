package org.tinker.auth.shiro.model;

import java.io.Serializable;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5667922219218423668L;
	
	 /**
     * 用户账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * salt 
     */
    private String salt;
    
    /**
     * 获取用户账号
     *
     * @return account - 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户账号
     *
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取salt 
     *
     * @return salt - salt 
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置salt 
     *
     * @param salt salt 
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 密码加密
     */
	public void encryptPassword() {
		final String algorithmName = Md5Hash.ALGORITHM_NAME;
		this.salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		ByteSource credentialsSalt = ByteSource.Util.bytes(this.account + this.salt);
		this.password = new SimpleHash(algorithmName, this.password, credentialsSalt).toHex();
	}
}
