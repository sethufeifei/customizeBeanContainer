package com.study;

/**
 * @author fei
 * @version V1.0
 * @date 2019/06/08 12:54
 */
public class Main {

    public static void main(String[] args) {
        try {
            BeanFactory.init(null);

            TestService1 test1 = (TestService1) BeanFactory.getBean("test1");
            test1.index();

            TestService3 test3 = (TestService3) BeanFactory.getBean("test3");
            test3.index();


        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }


    }
}
