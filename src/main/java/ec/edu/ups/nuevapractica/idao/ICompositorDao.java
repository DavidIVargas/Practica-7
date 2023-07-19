package ec.edu.ups.nuevapractica.idao;

import ec.edu.ups.nuevapractica.modelo.Compositor;
import java.util.List;

public interface ICompositorDao {
    
    public void create(Compositor compositor);
    public Compositor read(int codigo);
    public void update(Compositor compositor);
    public void delete(Compositor compositor);   
    public Compositor buscarPorTituloDeCancion(String valor);
    public List<Compositor> findAll();
}
