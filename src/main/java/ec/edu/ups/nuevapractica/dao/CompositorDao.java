package ec.edu.ups.nuevapractica.dao;

import ec.edu.ups.nuevapractica.idao.ICompositorDao;
import ec.edu.ups.nuevapractica.modelo.Cancion;
import ec.edu.ups.nuevapractica.modelo.Compositor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CompositorDao implements ICompositorDao {

    private final String FILE_PATH = "compositores.bin"; // Ruta del archivo binario

    @Override
    public void create(Compositor compositor) {
        List<Compositor> listaCompositores = findAll();
        listaCompositores.add(compositor);
        saveAll(listaCompositores);
    }

    @Override
    public Compositor read(int codigo) {
        List<Compositor> listaCompositores = findAll();
        for (Compositor compositor : listaCompositores) {
            if (compositor.getCodigo() == codigo) {
                return compositor;
            }
        }
        return null;
    }

    @Override
    public void update(Compositor compositor) {
        List<Compositor> listaCompositores = findAll();
        for (int i = 0; i < listaCompositores.size(); i++) {
            Compositor c = listaCompositores.get(i);
            if (c.getCodigo() == compositor.getCodigo()) {
                listaCompositores.set(i, compositor);
                break;
            }
        }
        saveAll(listaCompositores);
    }

    @Override
    public void delete(Compositor compositor) {
        List<Compositor> listaCompositores = findAll();
        listaCompositores.removeIf(c -> c.getCodigo() == compositor.getCodigo());
        saveAll(listaCompositores);
    }

    @Override
    public Compositor buscarPorTituloDeCancion(String valor) {
        List<Compositor> listaCompositores = findAll();
        for (Compositor compositor : listaCompositores) {
            for (Cancion cancion : compositor.getCancionesTop100Billboard()) {
                if (cancion.getTitulo().equals(valor)) {
                    return compositor;
                }
            }
        }
        return null;
    }

    @Override
    public List<Compositor> findAll() {
        List<Compositor> listaCompositores = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            listaCompositores = (List<Compositor>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // El archivo aún no existe o está vacío
        }
        return listaCompositores;
    }

    private void saveAll(List<Compositor> listaCompositores) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(listaCompositores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}