/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import modelo.Palabra;

/**
 *
 * @author adrian
 */
public class Juego {
    @PersistenceUnit
    private static EntityManagerFactory emf;
    @Resource
    private static UserTransaction utx;
    //private final static String palabras[] = {"Oaxaca","Chiapas","Veracruz","Sonora","Puebla"};
    private final static char letras[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                                        'ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    
    
    public static String getPalabra(int nivel,int tipo){
        emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Palabra> consultaPalabras = (TypedQuery<Palabra>) em.createNativeQuery("select * from palabra where nivel="+nivel+" and id_tipo="+tipo,Palabra.class);
        List<Palabra> palabras= consultaPalabras.getResultList();
        emf.close();
        System.out.println("************** "+palabras.size()+" ************************");
        return palabras.get((int)(Math.random() * palabras.size())).getPalabra();
    }
    
    public static char[] getLetras(){
        return letras;
    }
    
}
