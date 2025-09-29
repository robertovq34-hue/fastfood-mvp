package com.usil.fastfood.controller;

import com.usil.fastfood.factory.ComboFactory;
import com.usil.fastfood.model.Combo;
import com.usil.fastfood.model.ComboType;
import com.usil.fastfood.builder.ComboBuilder;

public class ComboController {

    private final ComboFactory factory = new ComboFactory();

    public Combo obtenerComboBase(ComboType tipo) {
        return factory.crearComboBase(tipo);
    }

    public Combo personalizarCombo(Combo base, String bebida, String acompanamiento, String extra, Double precioOverride) {
        ComboBuilder builder = new ComboBuilder(base.getTipo())
                .setBebida(bebida != null ? bebida : base.getBebida())
                .setAcompanamiento(acompanamiento != null ? acompanamiento : base.getAcompanamiento())
                .setExtra(extra != null ? extra : base.getExtra());
        if (precioOverride != null) {
            builder.setPrecio(precioOverride);
        } else {
            builder.setPrecio(base.getPrecio());
        }
        return builder.build();
    }
}
