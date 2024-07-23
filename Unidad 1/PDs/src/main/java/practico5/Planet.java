/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico5;

/**
 *
 * @author TomasUcu
 */
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);
    
    private final double mass;
    private final double radius;
    
    private Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    
    public String obtenerInformacion() {
        return "Masa: " + this.mass + " Radio: " + this.radius;
    }
    
    public static void main(String[] args) {
        
        Planet mercurio = Planet.MERCURY;
        System.out.println(mercurio.obtenerInformacion());
        
        Planet venus = Planet.VENUS;
        System.out.println(venus.obtenerInformacion());
        
        Planet tierra = Planet.EARTH;
        System.out.println(tierra.obtenerInformacion());
        
        Planet urano = Planet.URANUS;
        System.out.println(urano.obtenerInformacion());
        
        System.out.println(urano.name());
        System.out.println(Planet.values());
        
        for (Planet p : Planet.values()) {
            System.out.println(p);
        }
        
    }
}
