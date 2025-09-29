package com.usil.fastfood.factory;

import com.usil.fastfood.model.Combo;
import com.usil.fastfood.model.ComboType;
import com.usil.fastfood.builder.ComboBuilder;

public class ComboFactory {

    public Combo crearComboBase(ComboType tipo) {
        switch (tipo) {
            case HAMBURGUESA:
                return new ComboBuilder(tipo)
                        .setBebida("Gaseosa 500ml")
                        .setAcompanamiento("Papas medianas")
                        .setExtra("Salsa especial")
                        .setPrecio(18.0)
                        .build();
            case POLLO:
                return new ComboBuilder(tipo)
                        .setBebida("Gaseosa 500ml")
                        .setAcompanamiento("Ensalada")
                        .setExtra("Aderezo")
                        .setPrecio(16.0)
                        .build();
            case VEGETARIANO:
                return new ComboBuilder(tipo)
                        .setBebida("Jugo natural")
                        .setAcompanamiento("Papas al horno")
                        .setExtra("Hummus")
                        .setPrecio(15.0)
                        .build();
            default:
                throw new IllegalArgumentException("Tipo de combo desconocido");
        }
    }
}
