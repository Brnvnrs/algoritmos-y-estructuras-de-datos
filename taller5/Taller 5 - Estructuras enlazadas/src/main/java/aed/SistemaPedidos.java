package aed;

public class SistemaPedidos {
    private ABB<Pedido> abb;
    private ListaEnlazada<ABB<Pedido>.HandleABB> lista;

    public SistemaPedidos() {
        abb = new ABB<>();
        lista = new ListaEnlazada<>();
    }

    public void agregarPedido(Pedido pedido) {
        ABB<Pedido>.HandleABB h = abb.insertar(pedido);
        lista.agregarAtras(h);
    }

    public Pedido proximoPedido() {
        ABB<Pedido>.HandleABB h = lista.obtener(0);
        Pedido p = h.valor();
        h.eliminar();
        lista.eliminar(0);
        return p;
    }

    public Pedido pedidoMenorId() {
        return abb.minimo();
    }

    public String obtenerPedidosEnOrdenDeLlegada() {
        StringBuilder sb = new StringBuilder("[");
        ListaEnlazada<ABB<Pedido>.HandleABB>.ListaIterador it = lista.iterador();

        boolean primero = true;
        while (it.haySiguiente()) {
            if (!primero) {
                sb.append(", ");
            }
            sb.append(it.siguiente().valor().toString());
            primero = false;
        }

        sb.append("]");
        return sb.toString();
    }

    public String obtenerPedidosOrdenadosPorId() {
        return abb.toString();
    }
}