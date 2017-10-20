package hw04.reflection;

import hw04.reflection.annotation.CacheDeclaration;
import hw04.reflection.annotation.InjectCache;
import hw04.reflection.cache.Cache;
import hw04.reflection.cluster.ClusterOfCaches;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

public class CacheInjector {
    private static Map<String, Class<?>> mapOfCaches = new HashMap<>();

    public static void inject(ClusterOfCaches cluster) {
        List<Field> fields = new ArrayList<>();
        getAllFields(fields, cluster.getClass());

        System.out.println("Class:");
        System.out.println(cluster.getClass() + "\n");
        for (Field f : fields) {
            System.out.println("Field:");
            System.out.println(f);
            InjectCache injectCache = f.getAnnotation(InjectCache.class);
            if (injectCache != null) {
                f.setAccessible(true);
                Cache cache = null;
                try {
                    cache = (Cache) mapOfCaches.get(injectCache.name()).getConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException
                        | InvocationTargetException | NoSuchMethodException e) {
                    System.out.printf("The exception has been thrown while trying to create new instance "
                            + "of the cache with Reflection API!");
                }
                try {
                    f.set(cluster, cache);
                } catch (IllegalAccessException e) {
                    System.out.println("IllegalAccessException has been thrown while trying to inject the field!");
                }
            } else {
                System.out.println("The annotation is not found.");
            }
            System.out.println();
        }
    }

    public static void updateMapOfCaches(String scannedPackage) {
        Map<String, Class<?>> mapOfCaches = new HashMap<>();
        List<Class<?>> cacheClasses = ClassFinder.find(scannedPackage);
        for (Class c : cacheClasses) {
            CacheDeclaration cd = (CacheDeclaration) c.getAnnotation(CacheDeclaration.class);
            if (cd != null) {
                mapOfCaches.put(cd.name(), c);
            }
        }
        CacheInjector.mapOfCaches = mapOfCaches;
    }

    private static void getAllFields(List<Field> fields, Class<?> c) {
        fields.addAll(Arrays.asList(c.getDeclaredFields()));
        if (!c.getCanonicalName().equals(ClusterOfCaches.class.getCanonicalName())) {
            if (c.getSuperclass() != null) {
                getAllFields(fields, c.getSuperclass());
            }
        }
    }

    private static class ClassFinder {
        private static final char PKG_SEPARATOR = '.';

        private static final char DIR_SEPARATOR = '/';

        private static final String CLASS_FILE_SUFFIX = ".class";

        private static final String BAD_PACKAGE_ERROR = "Unable to get resources from the path '%s'. Are you sure the package '%s' exists?";

        static List<Class<?>> find(String scannedPackage) {
            String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
            URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
            if (scannedUrl == null) {
                throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
            }
            File scannedDir = new File(scannedUrl.getFile());
            List<Class<?>> classes = new ArrayList<>();
            File[] files = scannedDir.listFiles();
            if (files == null) {
                System.out.println("The package is not a directory or IO error has been occurred!");
                return classes;
            }
            for (File file : files) {
                classes.addAll(find(file, scannedPackage));
            }
            return classes;
        }

        private static List<Class<?>> find(File file, String scannedPackage) {
            List<Class<?>> classes = new ArrayList<>();
            if (file == null) {
                return classes;
            }
            String resource = scannedPackage + PKG_SEPARATOR + file.getName();
            if (file.isDirectory()) {
                if (file.listFiles() == null) {
                    System.out.printf("IO error has been occurred while attempting to get the list of files (directory: %s)!",
                            file.getName());
                    return classes;
                }
                for (File child : file.listFiles()) {
                    classes.addAll(find(child, resource));
                }
            } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
                int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
                String className = resource.substring(0, endIndex);
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException ignore) {
                    System.out.printf("Class %s has been found in the package but cannot be located!", className);
                }
            }
            return classes;
        }
    }
}
