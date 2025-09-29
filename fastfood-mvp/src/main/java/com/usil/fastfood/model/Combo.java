package com.usil.fastfood.model;

public class Combo {
    private ComboType tipo;
    private String bebida;
    private String acompanamiento;
    private String extra;
    private double precio;

    public Combo(ComboType tipo) {
        this.tipo = tipo;
    }

    // package-private setters usados por el Builder
    void setBebida(String bebida) { this.bebida = bebida; }
    void setAcompanamiento(String acompanamiento) { this.acompanamiento = acompanamiento; }
    void setExtra(String extra) { this.extra = extra; }
    void setPrecio(double precio) { this.precio = precio; }

    public ComboType getTipo() { return tipo; }
    public String getBebida() { return bebida; }
    public String getAcompanamiento() { return acompanamiento; }
    public String getExtra() { return extra; }
    public double getPrecio() { return precio; }

    public String getResumen() {
        return String.format("Combo: %s\nBebida: %s\nAcompañamiento: %s\nExtra: %s\nPrecio: S/ %.2f",
                tipo, bebida, acompanamiento, extra, precio);
    }
}
