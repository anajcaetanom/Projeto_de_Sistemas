package classloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassLoader {
    public void loadOperations() {
        String packageName = "model.operations";
        String packagePath = packageName.replace('.', '/');

        File directory = new File("src/" + packagePath);

        List<Class<?>> operations = new ArrayList<>();

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().replace(".class", "");
                        try {
                            Class<?> clazz = Class.forName(className);
                            operations.add(clazz);
                        } catch (ClassNotFoundException e) {
                            System.out.print("Class not found.");
                        }
                    }
                }
            }
        }

        for (Class<?> clazz : operations) {
            System.out.println(clazz.getName());
        }
    }
}
