/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.nuevapractica.idao;
import ec.edu.ups.nuevapractica.modelo.Cantante;
import ec.edu.ups.nuevapractica.modelo.Disco;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICantanteDao {
    
    public void create(Cantante cantante);
    public Cantante read(int id);
    public void update(Cantante cantante);
    public void delete(Cantante cantante);  
    public Disco buscarPorNombreDeDisco(String valor);
    public List<Cantante> findAll();
}