/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author gisig
 */
public enum NivelDificuldade {
    
    FACIL(0.0),
    MEDIO(-0.1),
    DIFICIL(-0.25);

    private double desconto;

    NivelDificuldade(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return this.desconto;
    }
    
}
