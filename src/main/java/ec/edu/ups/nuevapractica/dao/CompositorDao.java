package ec.edu.ups.nuevapractica.dao;

import ec.edu.ups.nuevapractica.idao.ICompositorDao;
import ec.edu.ups.nuevapractica.modelo.Cancion;
import ec.edu.ups.nuevapractica.modelo.Compositor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositorDao implements ICompositorDao{
    
    private List<Compositor> listaCompositor;

    public CompositorDao() {
        listaCompositor = new ArrayList<>();
    }
    
    

    @Override
    public void create(Compositor compositor) {
        listaCompositor.add(compositor);
    }

    @Override
    public Compositor read(int codigo) {
        for (Compositor compositor : listaCompositor) {
            if (compositor.getCodigo()==(codigo)) {
                return compositor;
                
            }
        }
        return null;
    }

    @Override
    public void update(Compositor compositor) {
        for (int i = 0; i < listaCompositor.size(); i++) {
            Compositor c = listaCompositor.get(i);
            if (c.getCodigo() == compositor.getCodigo()) {
                listaCompositor.set(i, compositor);
                break;
            }
        }
    }

    @Override
    public void delete(Compositor compostior) {
        Iterator<Compositor> it = listaCompositor.iterator();
        while (it.hasNext()) {
            Compositor e = it.next();
            if (e.getNombre()== compostior.getNombre()) {
                it.remove();
                break;
            }
        }
    }
    
    @Override
    public Compositor buscarPorTituloDeCancion(String valor) {
        for (Compositor compositor : listaCompositor) {
            if (compositor instanceof Compositor) {
                for (Cancion cancion : compositor.getCancionesTop100Billboard()) {
                    if (cancion.getTitulo().equals(valor)) { 
                        return compositor;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public List<Compositor> findAll() {
        return listaCompositor;
    }
    
}
