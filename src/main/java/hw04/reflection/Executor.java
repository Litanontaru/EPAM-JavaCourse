package hw04.reflection;

import hw04.reflection.cluster.ClusterOfFourCaches;

public class Executor {
    public static void execute() {
        ClusterOfFourCaches cluster = new ClusterOfFourCaches();
        CacheInjector.inject(cluster, "hw04.reflection.cache");
        ClusterCustomer customer = new ClusterCustomer(cluster);
        customer.putTestValues();
        customer.getTestValues();
    }
}
