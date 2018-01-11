package com.ec.demo.cons;

/**
 *整个应用通用的常量 
 *<br><b>类描述:</b>
 *<pre>|</pre>
 * @author 张昊
 *@see
 *@since
 */
public class CommonConstant
{
   /**
    * 用户对象放到Session中的键名称
    */
   public static final String USER_CONTEXT = "USER_CONTEXT";

    /**
     * 用户登录日志放到Session中的键名称
     */
    public static final String USER_LOGINLOG = "USER_LOGINLOG";
   
   /**
    * 将登录前的URL放到Session中的键名称
    */
   public static final String LOGIN_TO_URL = "toUrl";
   
   /**
    * 每页的记录数
    */
   public static final int PAGE_SIZE = 3;

    /**
     * 订单状态
     */
    public static final int ORDER_DEPRIVED = 0;
    public static final int ORDER_TO_BE_DELIVERED = 1;
    public static final int ORDER_TO_BE_CONFIRMED = 2;
    public static final int ORDER_ACCOMPLISHED = 3;

}
