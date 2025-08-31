package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] lista;
    private int longitud;
    public ArregloRedimensionableDeRecordatorios() {
        // Implementar
        this.lista = new Recordatorio[0];
        this.longitud = 0;
    }

    public int longitud() {
        // Implementar
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        // Implementar
        Recordatorio[] otraLista = new Recordatorio[this.longitud+1];
        if(this.longitud==0){
            otraLista[0]=i;
        }
        else{
            for (int j = 0;j<this.longitud;j++){
                otraLista[j] = this.lista[j];
            }
            otraLista[this.longitud] = i;
        }
        this.lista = otraLista;
        this.longitud +=1;
    }

    public Recordatorio obtener(int i) {
        // Implementar
        return this.lista[i];
    }

    public void quitarAtras() {
        // Implementar
        Recordatorio[] otraLista = new Recordatorio[longitud -1];
        for (int i =0 ; i<longitud-1;i++){
            otraLista[i]=this.lista[i];
        }
        this.lista = otraLista;
        longitud -=1;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // Implementar
        this.lista[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
        ArregloRedimensionableDeRecordatorios otroArreglo = new ArregloRedimensionableDeRecordatorios();
        for(int i =0;i<vector.longitud;i++){
            otroArreglo.agregarAtras(new Recordatorio(vector.lista[i].mensaje(),vector.lista[i].fecha(),vector.lista[i].horario()));
            // que tan bien esta usar el for y despues el metodo agregar atras?
        }
        this.lista =otroArreglo.lista;
        this.longitud = otroArreglo.longitud;       
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        ArregloRedimensionableDeRecordatorios arregloRecordatorioCopia = new ArregloRedimensionableDeRecordatorios();
        for (Recordatorio elem :this.lista){
            Recordatorio recordatorioCopia = new Recordatorio(elem.mensaje(), elem.fecha(),elem.horario());
            arregloRecordatorioCopia.agregarAtras(recordatorioCopia);
        }
        return arregloRecordatorioCopia;
    }
}