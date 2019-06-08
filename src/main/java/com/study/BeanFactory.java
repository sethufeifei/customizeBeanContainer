package com.study;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fei
 * @version V1.0
 * @date 2019/06/08 12:42
 */
public class BeanFactory {
    /**
     * Bean对象容器
     */
    private static final Map<String, Object> BEAN_CONTAINER = new HashMap<>();


    /**
     * 对容器初始化
     * @param packageName
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void init(String packageName) throws IllegalAccessException, InstantiationException {

        if (packageName == null || packageName.isEmpty()) {
            packageName = "com.study";
        }

        Reflections reflection = new Reflections(packageName);

        // 获得此路径下所有带有自定义Service注解的类
        Set<Class<?>> typesAnnotatedWith = reflection.getTypesAnnotatedWith(Service.class);

        // 将这些类通过反射 新建对象并保存到beanContainer
        for (Class<?> aClass : typesAnnotatedWith) {
            Object bean = aClass.newInstance();
            Service annotation = aClass.getAnnotation(Service.class);
            BEAN_CONTAINER.put(annotation.value(), bean);
        }
    }


    /**
     * 根据注解名获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return BEAN_CONTAINER.get(beanName);
    }
}
