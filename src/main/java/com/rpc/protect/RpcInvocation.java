/**
 * Package: com.rpc.protect
 * Description: 
 */
package com.rpc.protect;

/**
 * Description:  
 * Date: 2018年5月11日 下午2:37:31
 * @author wufenyun 
 */
public interface RpcInvocation {

    String method();
    
    String version();
    
    Object[] args();
}
