package com.ec.demo.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 *<br><b>类描述:</b>
 *<pre>所示PO的父类</pre>
 *@author 张昊
 *@see
 *@since
 */
public class BaseDomain implements Serializable
{
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
