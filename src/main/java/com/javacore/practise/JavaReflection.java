package com.javacore.practise;

import com.models.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaReflection {
    public static void main(String[] args) {
        try {
            reflections(Model.class);
        } catch (NoSuchFieldException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void reflections(Class<T> clazz) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println(clazz.getName());

        //get all public fields and methods of the class
        var fields = clazz.getDeclaredFields();
        var methods = clazz.getDeclaredMethods();

        System.out.println("\n>>>>>>>>>>>>> Get all fields declared by the class");
        for (Field f : fields) {
            System.out.println("The field is " + f.getName() + " and the type is " + f.getType().getSimpleName() + " and access modifier is " + f.getModifiers());
        }

        System.out.println("\n>>>>>>>>>>>>> Get all methods declared by the class");
        for (var m : methods) {
            System.out.println(m);
        }


        System.out.println("\n>>>>>>>>>>>>> Invoke method by name");
        Method nameField = clazz.getDeclaredMethod("setName", String.class);
        nameField.setAccessible(true);
        var newModel = new Model();
        nameField.invoke(newModel, "John Doe");
        System.out.println(newModel.getName());

        //obtain the constructor with params
        System.out.println("\n>>>>>>>>>>>>> Obtain instance by call constructor");
        Class params[] = new Class[4];
        params[0] = String.class;
        params[1] = Integer.class;
        params[2] = String.class;
        params[3] = String.class;
        var constructor = clazz.getConstructor(params);
        Constructor ctr = clazz.getConstructor(params);
        Object modelX = ctr.newInstance("John Doe", 23, "Male", "john@gmail.com");
        if (modelX instanceof Model modelParse) {
            modelParse.printDetails();
        }
    }
}
