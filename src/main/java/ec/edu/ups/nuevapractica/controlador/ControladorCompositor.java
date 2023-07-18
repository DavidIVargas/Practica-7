package ec.edu.ups.nuevapractica.controlador;
import ec.edu.ups.nuevapractica.dao.CantanteDao;
import ec.edu.ups.nuevapractica.idao.ICompositorDao;
import ec.edu.ups.nuevapractica.modelo.Cancion;
import ec.edu.ups.nuevapractica.modelo.Cantante;
import ec.edu.ups.nuevapractica.modelo.Compositor;
import java.util.List;

public class ControladorCompositor {

    private ICompositorDao compositorDao;
    private Compositor compositor;
    private Cantante cantante;
    private CantanteDao cantantedao;

    public ControladorCompositor(ICompositorDao compositorDao) {
        this.compositorDao = compositorDao;
    }

    public void crearCompositor(Compositor compositor) {
        compositorDao.create(compositor);
    }

    public List<Compositor> verCompositores() {
        return compositorDao.findAll();
    }

    public void actualizarCompositor(Compositor compositor) {
        compositorDao.update(compositor);
    }

    public void eliminarCompositor(Compositor compositor) {
        compositorDao.delete(compositor);
    }

    public Compositor buscarCompositor(int codigo) {
        return compositorDao.read(codigo);
    }

    public Compositor buscarPorCancion(String nombre) {
        return compositorDao.buscarPorTituloDeCancion(nombre);
    }

    public void agregarClienteCan(Compositor compositor, Cantante cantante) {
        compositor.agregarCliente(cantante);
    }

    public void actualizarCancion(Compositor compositor, Cancion cancion) {
        compositor.actualizarCancion(cancion);
    }

    public void agregarCancion(Cancion cancion, Compositor compositor) {
        compositor.agregarCancion(cancion);
    }

    public Cancion buscarCancion(Compositor compositor, int codigo) {
        return compositor.buscarCancion(codigo);
    }

    public void eliminarCancion(Compositor compositor, int codigo) {
        compositor.eliminarCancion(codigo);
    }
}
