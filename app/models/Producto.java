package models;
 
import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
 
@Entity
public class Producto extends Model {
 
    public String nombre;
    public double precio;
    
    public Producto(String n, double p) {
       nombre = n;
       precio = p;
    }
}