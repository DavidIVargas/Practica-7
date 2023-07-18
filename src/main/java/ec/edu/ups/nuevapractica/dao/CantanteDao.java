package ec.edu.ups.nuevapractica.dao;
import ec.edu.ups.nuevapractica.idao.ICantanteDao;
import ec.edu.ups.nuevapractica.modelo.Cantante;
import ec.edu.ups.nuevapractica.modelo.Disco;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CantanteDao implements ICantanteDao {
    
    private List<Cantante> listaCantantes;

    public CantanteDao() {
        listaCantantes = new ArrayList<>();
    }
    
    
    @Override
    public void create(Cantante cantante) {
        listaCantantes.add(cantante);
    }

    @Override
    public Cantante read(int id) {
        for (Cantante cantante : listaCantantes) {
            if (cantante.getCodigo()==(id)) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante c = listaCantantes.get(i);
            if (c.getCodigo() == cantante.getCodigo()) {
                listaCantantes.set(i, cantante);
                break;
            }
        }
    }

    @Override
    public void delete(Cantante cantante) {
        Iterator<Cantante> it = listaCantantes.iterator();
        while (it.hasNext()) {
            Cantante d = it.next();
            if (d.getCodigo()== cantante.getCodigo()) {
                it.remove();
                break;
            }
        }
    }
    
    @Override
    public Disco buscarPorNombreDeDisco(String valor) {
        for(Cantante cantante : listaCantantes){
            if(cantante instanceof Cantante){
                for(Disco disco : cantante.getDiscos()){
                    if(disco.getNombre().equals(valor)){
                        System.out.println("Cantante: " + cantante.getNombreArtistico());
                        return disco;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Cantante> findAll() {
        return listaCantantes;
    }
    
}
