/**
 * Package: com.rpc.protect
 * Description: 
 */
package com.rpc.protect;

/**
 * Description:  
 * Date: 2018年5月11日 下午2:40:43
 * @author wufenyun 
 */
public interface Url {
    
    int getPort();
    
    String host();
    
    String path();
    
    String getParamValue(String key);
}
