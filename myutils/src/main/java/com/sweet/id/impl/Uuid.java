package com.sweet.id.impl;

import com.sweet.id.IdGenerator;

import java.util.UUID;

/**
 * 简化的UUID，去掉了横线
 * <p>
 * Author: 
 * Created: 2018/10/17
 */
public class Uuid implements IdGenerator {
    
    @Override
    public String id() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
