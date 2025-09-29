package com.usil.fastfood.builder;

import com.usil.fastfood.model.Combo;
import com.usil.fastfood.model.ComboType;

public class ComboBuilder {
    private Combo combo;

    public ComboBuilder(ComboType tipo) {
        this.combo = new Combo(tipo);
    }

    public ComboBuilder setBebida(String bebida) {
        combo.setBebida(bebida);
        return this;
    }

    public ComboBuilder setAcompanamiento(String acompanamiento) {
        combo.setAcompanamiento(acompanamiento);
        return this;
    }

    public ComboBuilder setExtra(String extra) {
        combo.setExtra(extra);
        return this;
    }

    public ComboBuilder setPrecio(double precio) {
        combo.setPrecio(precio);
        return this;
    }

    public Combo build() {
        // validaciones simples
        if (combo.getBebida() == null) combo.setBebida("Sin bebida");
        if (combo.getAcompanamiento() == null) combo.setAcompanamiento("Sin acompañamiento");
        if (combo.getExtra() == null) combo.setExtra("-");
        return combo;
    }
}
