package hw04.reflection;

import hw04.reflection.cluster.ClusterOfFourCaches;

public class ClusterCustomer {
    private ClusterOfFourCaches cluster;

    public ClusterCustomer(ClusterOfFourCaches cluster) {
        this.cluster = cluster;
    }

    public void put(Integer k, String v) {
        cluster.put(k, v);
    }

    public void get(Integer i) {
        System.out.println(cluster.getFromCacheOne(i));
        System.out.println(cluster.getFromCacheTwo(i));
        System.out.println(cluster.getFromCacheThree(i));
        System.out.println(cluster.getFromCacheFour(i));
    }

    public void putTestValues() {
        int k1 = 1;
        int k2 = 23;
        int k3 = 3;
        int k4 = 459;
        int k5 = 50;
        String v1 = "one";
        String v2 = "two";
        String v3 = "three";
        String v4 = "four";
        String v5 = "five";
        System.out.println("Putting the next test values into the cluster: ");
        System.out.println("Key: " + k1 + "   Value: " + v1);
        System.out.println("Key: " + k2 + "   Value: " + v2);
        System.out.println("Key: " + k3 + "   Value: " + v3);
        System.out.println("Key: " + k4 + "   Value: " + v4);
        System.out.println("Key: " + k5 + "   Value: " + v5);
        cluster.put(k1, v1);
        cluster.put(k2, v2);
        cluster.put(k3, v3);
        cluster.put(k4, v4);
        cluster.put(k5, v5);
        System.out.println();
    }

    public void getTestValues() {
        System.out.println("Values from the 1st cache: ");
        cluster.getAllFromCacheOne().forEach((k,v) -> System.out.println("Key: " + k + "   Value: " + v));
        System.out.println();
        System.out.println("Values from the 2nd cache: ");
        cluster.getAllFromCacheTwo().forEach((k,v) -> System.out.println("Key: " + k + "   Value: " + v));
        System.out.println();
        System.out.println("Values from the 3rd cache: ");
        cluster.getAllFromCacheThree().forEach((k,v) -> System.out.println("Key: " + k + "   Value: " + v));
        System.out.println();
        System.out.println("Values from the 4th cache: ");
        cluster.getAllFromCacheFour().forEach((k,v) -> System.out.println("Key: " + k + "   Value: " + v));
    }
}
