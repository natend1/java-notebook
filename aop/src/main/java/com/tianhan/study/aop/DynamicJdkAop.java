package com.tianhan.stduy.aop;

/**
 * @Author NieAnTai
 * @Date 2021/2/26 10:09 上午
 * @Version 1.0
 * @Email nieat@foxmail.com
 * @Description JDK动态AOP
 **/
public class DynamicJdkAop {
    public static void main(String[] args) {
    }

    interface IWork {
        void work();
    }

    class BossWork implements IWork {
        @Override
        public void work() {
            System.out.println("Boss开始工作!");
        }
    }
}
