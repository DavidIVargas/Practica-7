package ec.edu.ups.nuevapractica.dao;

import ec.edu.ups.nuevapractica.idao.ICantanteDao;
import ec.edu.ups.nuevapractica.modelo.Cantante;
import ec.edu.ups.nuevapractica.modelo.Disco;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CantanteDao implements ICantanteDao {

    private final String FILE_PATH = "cantantes.bin"; // Ruta del archivo binario

    @Override
    public void create(Cantante cantante) {
        List<Cantante> listaCantantes = findAll();
        listaCantantes.add(cantante);
        saveAll(listaCantantes);
    }

    @Override
    public Cantante read(int id) {
        List<Cantante> listaCantantes = findAll();
        for (Cantante cantante : listaCantantes) {
            if (cantante.getCodigo() == id) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        List<Cantante> listaCantantes = findAll();
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante c = listaCantantes.get(i);
            if (c.getCodigo() == cantante.getCodigo()) {
                listaCantantes.set(i, cantante);
                break;
            }
        }
        saveAll(listaCantantes);
    }

    @Override
    public void delete(Cantante cantante) {
        List<Cantante> listaCantantes = findAll();
        listaCantantes.removeIf(c -> c.getCodigo() == cantante.getCodigo());
        saveAll(listaCantantes);
    }

    @Override
    public Disco buscarPorNombreDeDisco(String valor) {
        List<Cantante> listaCantantes = findAll();
        for (Cantante cantante : listaCantantes) {
            for (Disco disco : cantante.getDiscos()) {
                if (disco.getNombre().equals(valor)) {
                    System.out.println("Cantante: " + cantante.getNombreArtistico());
                    return disco;
                }
            }
        }
        return null;
    }

    @Override
    public List<Cantante> findAll() {
        List<Cantante> listaCantantes = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            listaCantantes = (List<Cantante>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // El archivo aún no existe o está vacío
        }
        return listaCantantes;
    }

    private void saveAll(List<Cantante> listaCantantes) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(listaCantantes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
