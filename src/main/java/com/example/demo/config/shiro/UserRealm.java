package com.example.demo.config.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DTO.SellerInfoDto;
import com.example.demo.constant.Constant;
import com.example.demo.manger.SellerInfoMng;

/**  
* @ClassName: UserRealm  
* @Description: TODO shiro检验规则
* @author cuixc  
* @date 2018年6月19日  
*    
*/  
public class UserRealm extends AuthorizingRealm {
	private static final Logger log = LoggerFactory.getLogger(UserRealm.class);
	@Autowired
	private SellerInfoMng sellerInfoMng;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub  授权
		log.info("============授权===============");
		return new SimpleAuthorizationInfo();
	}
	/**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		log.info("============登入认证===============");
		String loginName = (String) authcToken.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) authcToken.getCredentials());
        SellerInfoDto sellerInfo = new SellerInfoDto();
        sellerInfo.setUsername(loginName);
        sellerInfo.setPassword(password);
        //此处更改为从缓存中获取
        List<SellerInfoDto> sellerInfoDtos = sellerInfoMng.find(sellerInfo);
        if (sellerInfoDtos == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        SellerInfoDto seller = sellerInfoDtos.get(0);
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		seller.getUsername(),
        		seller.getPassword(),
                //ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                getName()
        );
        //session中不需要保存密码
        seller.setPassword("");;
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setTimeout(Constant.SESSION_TIME);
        SecurityUtils.getSubject().getSession().setAttribute(Constant.USER_INFO, seller);
        return authenticationInfo;
	}

}
