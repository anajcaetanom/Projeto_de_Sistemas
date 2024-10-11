package org.example.model;

import org.example.model.operations.IOperation;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CalculatorModel {

    public List<Class<? extends IOperation>> getClassesNames() {
        Reflections reflections = new Reflections("org.example.model.operations");

        Set<Class<? extends IOperation>> classes = reflections.getSubTypesOf(IOperation.class);

        return new ArrayList<>(classes);
    }

    public void sortClassList(List<Class<? extends IOperation>> classList) {

        classList.sort((c1, c2) -> {
            try {
                IOperation instance1 = c1.getDeclaredConstructor().newInstance();
                IOperation instance2 = c2.getDeclaredConstructor().newInstance();

                int value1 = instance1.getId();
                int value2 = instance2.getId();

                return Integer.compare(value1, value2);

            } catch (IllegalAccessException | InstantiationException |
                     NoSuchMethodException | InvocationTargetException e) {
                System.out.print("erro no sort");
                return 0;
            }
        });

    }
}
