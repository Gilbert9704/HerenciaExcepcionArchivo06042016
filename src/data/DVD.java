/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Estudiante
 */
public class DVD extends Soporte{
    private Autor[] actor;
    private int duracion;

    public DVD(Autor[] actor, int duracion, Autor autor, String titulo) {
        super(titulo);
        super.setAutor(autor);
        this.actor = actor;
        this.duracion = duracion;
    }

    public Autor[] getActor() {
        return actor;
    }

    public void setActor(Autor[] actor) {
        this.actor = actor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString(){
        return "DVD{"+ super.toString() + "Duración" + duracion +", Actor=" + actor[0] + "," + actor[1] + "}";
    }
    
}
