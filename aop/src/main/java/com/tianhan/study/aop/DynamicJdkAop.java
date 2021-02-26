package com.tianhan.study.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author NieAnTai
 * @Date 2021/2/26 10:09 上午
 * @Version 1.0
 * @Email nieat@foxmail.com
 * @Description JDK动态AOP
 **/
public class DynamicJdkAop {
    public static void main(String[] args) {
        BossWork work = new BossWork();
        IWork iwork = (IWork) Proxy.newProxyInstance(BossWork.class.getClassLoader(),
                new Class[]{IWork.class},
                new WorkHandler(work));
        iwork.work();
    }


    interface IWork {
        void work();
    }

    static class BossWork implements IWork {
        @Override
        public void work() {
            System.out.println("Boss开始工作!");
        }
    }

    static class WorkHandler implements InvocationHandler {
        private final Object object;

        public WorkHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("object className: " + object.getClass().getName());
            System.out.println("proxy className: " + proxy.getClass().getName());
            if ("work".equals(method.getName())) {
                System.out.println("秘书预备工作文件.");
            }
            return method.invoke(object, args);
        }
    }
}
