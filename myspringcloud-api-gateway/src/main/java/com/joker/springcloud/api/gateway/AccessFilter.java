package com.joker.springcloud.api.gateway;

import com.netflix.zuul.ZuulFilter;

public class AccessFilter extends ZuulFilter {
    /**
     * 过滤器类型，决定过滤器在哪个生命周期执行
     * pre：请求被路由之前调用
     * route:路由请求时候被调用
     * post:在routing和error过滤器之后被调用
     * error:处理请求时发生错误时被调用
     * static：
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序。数值越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //实际使用中，自定义逻辑处理
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        System.out.println("=== AccessFileter is running ===");
        return null;
    }
}
