package aed;

public class Fecha {
    private int dia;
    private int mes;
    public Fecha(int dia, int mes) {
        // Implementar
        this.dia=dia ;
        this.mes=mes;
    }

    public Fecha(Fecha fecha) {
        Fecha fechaActual = new Fecha(fecha.dia,fecha.mes);
        this.dia = fechaActual.dia();
        this.mes = fechaActual.mes();
    }

    public Integer dia() {
        // Implementar
        return this.dia;
    }

    public Integer mes() {
        // Implementar
        return this.mes;
    }

    public String toString() {
        
        return this.dia+"/"+this.mes;
    }

    @Override
    public boolean equals(Object otra) {
        // nos fijamos si es null
        boolean isNull = otra == null;
        boolean distintaClase = otra.getClass() != this.getClass();
        if(isNull || distintaClase){
            return false;
        }else {
            Fecha otraFecha = (Fecha) otra;
            return this.dia == otraFecha.dia && this.mes == otraFecha.mes;
        }
    }

    public void incrementarDia() {
        // Implementar
        if(this.dia == diasEnMes(this.mes)){
            this.dia =1;
            if(this.mes == 12){
                this.mes = 1;
            }else{
                this.mes +=1;
            }
        }
        else{
            this.dia +=1; 
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
