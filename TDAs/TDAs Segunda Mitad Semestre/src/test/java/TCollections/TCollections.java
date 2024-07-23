/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCollections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class TCollections {

    
    // Set conjunto (no duplicados)
        // HashSet (sin orden)
        // TreeSet (orden de clave)
        // LinkedHashSet (orden de inserción)
    // List
        // LinkedList (acceso n) 
        // ArrayList  (acceso 1) (redimensionar)
    // Map (clave - valor)
        // HashMap (sin orden)
        // TreeMap (orden de clave)
        // LinkedHashMap (orden de inserción)
    @Test
    public void testCollectionsSet() {
        System.out.println("HashSet");
        HashSet hash = new HashSet();
        hash.add("-12312321");
        hash.add("1237348971");
        hash.add("2222222222");
        hash.add("213123");
        hash.add("1");
        hash.forEach(x -> System.out.println(x));
        
        System.out.println("");
        System.out.println("TreeSet");
        TreeSet tree = new TreeSet();
        tree.add("-12312321");
        tree.add("1237348971");
        tree.add("2222222222");
        tree.add("213123");
        tree.add("1");
        tree.forEach(x -> System.out.println(x));

        System.out.println("");
        System.out.println("LinkedHashSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("-12312321");
        linkedHashSet.add("1237348971");
        linkedHashSet.add("2222222222");
        linkedHashSet.add("213123");
        linkedHashSet.add("1");
        linkedHashSet.forEach(x -> System.out.println(x));
    }

    @Test
    public void testCollectionsMap() {
        System.out.println("HashMap");
        HashMap<Comparable, Comparable> hashMap = new HashMap<>();
        hashMap.put("12122", "Hola xd");
        hashMap.put("22232", null);
        hashMap.put("31313", null);
        hashMap.forEach((k, v) -> System.out.println(k));

    }
}
