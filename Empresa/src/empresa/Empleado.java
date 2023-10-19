/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

/**
 *
 * @author David
 */
import java.util.GregorianCalendar;

/**
 *
 * @author david
 */
public class Empleado {
    int num;
    String nombre;
    int sueldo;
    GregorianCalendar fechaAlta;
    int sueldoMax;
    static Empleado init = null;
    static Empleado act = null;
    Empleado sig = null;

    public Empleado(String nombre,int num, int sueldo, int sueldoMax){
        this.nombre=nombre;
        this.num=num;
        this.sueldo=sueldo;
        this.sueldoMax=sueldoMax;
        this.fechaAlta= new GregorianCalendar();
        this.sig = null;
        if(init == null)
        {
            init = this;
        }
        else
        {
            this.sig = init;
            init = this;
        }
        act = init;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Empleado getInit() {
        return init;
    }

    public static void setInit(Empleado init) {
        Empleado.init = init;
    }

    public static Empleado getAct() {
        return act;
    }

    public static void setAct(Empleado act) {
        Empleado.act = act;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldoMax() {
        return sueldoMax;
    }

    public void setSueldoMax(int sueldoMax) {
        this.sueldoMax = sueldoMax;
    }

    public Empleado getSig() {
        return sig;
    }

    public void setSig(Empleado sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "Empleado " + num + " " + nombre;
    }
    
    public static void avanzar()
    {
        act = act.sig;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    public static boolean esUlt()
    {
        return (act.sig == null);
    }
    
    public static boolean esPrimero()
    {
        return (init == act);
    }
    
    public static void retroceder()
    {
        Empleado aux = init;
        
        while(aux.sig != act)
        {
            aux = aux.sig;
        }
        act = aux;
    }
}

