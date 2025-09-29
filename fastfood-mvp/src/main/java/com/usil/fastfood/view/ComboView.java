package com.usil.fastfood.view;

import com.usil.fastfood.controller.ComboController;
import com.usil.fastfood.model.Combo;
import com.usil.fastfood.model.ComboType;

import java.util.Scanner;

public class ComboView {
    private final ComboController controller = new ComboController();
    private final Scanner sc = new Scanner(System.in);

    public void iniciarDemo() {
        System.out.println("Seleccione tipo de combo: 1-HAMBURGUESA 2-POLLO 3-VEGETARIANO");
        int opt = 1;
        try {
            opt = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Opción inválida, se selecciona HAMBURGUESA por defecto.");
        }
        ComboType tipo = opt == 1 ? ComboType.HAMBURGUESA : (opt == 2 ? ComboType.POLLO : ComboType.VEGETARIANO);
        Combo base = controller.obtenerComboBase(tipo);
        System.out.println("Combo base:");
        System.out.println(base.getResumen());

        System.out.println("\nPersonalizar (deje vacío para mantener la opción base):");
        System.out.print("Bebida: ");
        String bebida = sc.nextLine(); if (bebida.isBlank()) bebida = null;
        System.out.print("Acompañamiento: ");
        String acomp = sc.nextLine(); if (acomp.isBlank()) acomp = null;
        System.out.print("Extra: ");
        String extra = sc.nextLine(); if (extra.isBlank()) extra = null;
        System.out.print("Precio (s/): ");
        String precioStr = sc.nextLine();
        Double precio = precioStr.isBlank() ? null : Double.parseDouble(precioStr);

        Combo finalCombo = controller.personalizarCombo(base, bebida, acomp, extra, precio);
        System.out.println("\nResumen final:");
        System.out.println(finalCombo.getResumen());
    }
}
