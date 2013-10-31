package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import com.google.gson.Gson;
import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void deleteProd(Long id) {
        Producto p = Producto.findById(id);
        if(p != null){
          p.delete();
          renderJSON(id);
        }
        id*=-1;
        renderJSON(id);
    }
  
    static Gson g = new Gson();
  
    public static void SaveProd() {
      
         Producto newProd = g.fromJson(params.get("body"), Producto.class);
         newProd.save();
      
        renderJSON(newProd);
    }
  
    public static void upDateProd(Long id) {
      
         Producto newProd = g.fromJson(params.get("body"), Producto.class);
         Producto pLocal = Producto.findById(id);
      
         pLocal.nombre = newProd.nombre;
         pLocal.precio = newProd.precio;
      
         pLocal.save();
        renderJSON(pLocal);
    }
  
    public static void productos() {
        List<Producto> l = Producto.findAll();
        renderJSON(l);
    }
  
}