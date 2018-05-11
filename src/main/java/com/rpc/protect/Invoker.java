/**
 * Package: com.rpc.protect
 * Description: 
 */
package com.rpc.protect;

/**
 * Description:  
 * Date: 2018年5月11日 下午2:43:53
 * @author wufenyun 
 */
public interface Invoker {

    Object invoke(RpcInvocation invocation);
    
    Url getUrl();
}
