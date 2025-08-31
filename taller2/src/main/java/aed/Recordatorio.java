package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        // Implementar
        this.mensaje=mensaje;
        this.fecha = new Fecha(fecha.dia(),fecha.mes());
        this.horario = horario ;
    }

    public Horario horario() {
        // Implementar
        return this.horario;
    }

    public Fecha fecha() {
        // Implementar
        int otroDia = this.fecha.dia();
        int otroMes = this.fecha.mes();
        Fecha otraFecha = new Fecha(otroDia,otroMes);
        
        return otraFecha;
    }

    public String mensaje() {
        // Implementar
        return this.mensaje;
    }

    @Override
    public String toString() {
        // Implementar
        return this.mensaje + " @ " + this.fecha.toString() +" " + this.horario.toString();
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        boolean isNull = otro == null;
        boolean distintaClase = otro.getClass() != this.getClass();
        if( isNull || distintaClase){
            return false;
        }
        else{
            Recordatorio otroRecordatorio= (Recordatorio) otro;
            return otroRecordatorio.fecha.equals(this.fecha) && otroRecordatorio.horario.equals(this.horario)  && otroRecordatorio.mensaje.equals(this.mensaje);
    }
}
}