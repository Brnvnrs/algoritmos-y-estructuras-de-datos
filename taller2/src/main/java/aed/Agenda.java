package aed;

public class Agenda {
    private Fecha _fechaActual;
    private ArregloRedimensionableDeRecordatorios _recordatorios;
    public Agenda(Fecha fechaActual) {
        this._fechaActual = new Fecha(fechaActual.dia(), fechaActual.mes());
        this._recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        _recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        // Implementar
        String separador = "=====";
        String saltoLinea = "\n";
        String recordatorio = "";
        recordatorio+=_fechaActual.toString()+saltoLinea;
        // recordatorio += saltoLinea;
        recordatorio += separador+saltoLinea;
        // recordatorio += saltoLinea;
        for (int i = 0 ; i< _recordatorios.longitud();i++ ){
            if(_recordatorios.obtener(i).fecha().equals(_fechaActual)){
                recordatorio += _recordatorios.obtener(i).toString() ;
                recordatorio += saltoLinea;
            }
        }
        return recordatorio;
    }

    public void incrementarDia() {
        // Implementar
        this._fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        // Implementar
        // Fecha mismaFecha = new Fecha(this._fechaActual.dia(),this._fechaActual.mes());
        Fecha mismaFecha = new Fecha(this._fechaActual);
        return mismaFecha;
    }

}
