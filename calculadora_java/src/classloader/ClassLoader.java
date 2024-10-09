package classloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassLoader {

    public List<Class<?>> loadOperations() {
        String packageName = "model.operations";
        // String packagePath = packageName.replace(".", File.separator);

        File directory = new File("C:\\Users\\jucae\\IdeaProjects\\Projeto_de_Sistemas\\calculadora_java\\src\\model\\operations");

        List<Class<?>> operations = new ArrayList<>();

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".java")) {
                        String className = packageName + '.' + file.getName().replace(".java", "");
                        try {
                            Class<?> clazz = Class.forName(className);
                            operations.add(clazz);
                        } catch (ClassNotFoundException e) {
                            System.out.print("Class not found.");
                        }
                    }
                }
            }
        } else {
            System.out.print("Directory does not exist.");
        }

        return operations;

    }
}
