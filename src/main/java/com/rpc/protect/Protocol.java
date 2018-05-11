package com.rpc.protect;

public interface Protocol {
    
    Exporter export(Invoker invoker);
    
    Invoker refrence(Url url);
    
}
