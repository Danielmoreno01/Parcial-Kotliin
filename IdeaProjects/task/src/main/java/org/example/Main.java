package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> prods = new HashMap<>();
        prods.put("papas", 2000);
        prods.put("galletas", 3000);
        prods.put("gansito", 1500);
        prods.put("cocacola", 2500);
        prods.put("agua", 3500);

        Scanner sc = new Scanner(System.in);
        int total = 0;
        int dinero;
        String op;

        System.out.println("Prods disponibles:");
        for (Map.Entry<String, Integer> entry : prods.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " $");
        }

        System.out.println("Ingresa el nombrel del producto a comprar :");
        for (int i = 0; i < 5; i++) {
            String prod = sc.next();
            if (prods.containsKey(prod)) {
                total += prods.get(prod);
            } else {
                System.out.println("Producto sin stock.");
            }
        }

        System.out.println("El total a pagar es: " + total + " $");
        System.out.print("Ingrese el dinero: ");
        dinero = sc.nextInt();

        if (dinero >= total) {
            int cambio = dinero - total;
            System.out.println("Espera, Tu cambio es: " + cambio + " $");
        } else {
            System.out.println("Fondos insuficiente #largo.");
        }

        System.out.println("Gracias por tu compra!");
        sc.close();
    }
}
