package com.tianhan.study.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.security.acl.Permission;

/**
 * @Author NieAnTai
 * @Date 2021/2/26 12:07 下午
 * @Version 1.0
 * @Email nieat@foxmail.com
 * @Description cglib 动态代理
 **/
public class DynamicCglibAop {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoMi.class);
        enhancer.setCallback(new CustomsMehtodInterceptor());
        XiaoMi x = (XiaoMi) enhancer.create();
        x.who();
    }

    interface People {
        void who();
    }

    static class XiaoMi implements People {
        @Override
        public void who() {
            System.out.println("我是小米");
        }
    }

    static class CustomsMehtodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if ("who".equals(method.getName())) {
                System.out.println("你是谁?");
            }
            return methodProxy.invokeSuper(o, objects);
        }
    }
}
