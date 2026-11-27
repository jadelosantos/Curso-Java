package com.elcorteingles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al programa");


        // 1. Conectar con JPA
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("miUnidad");

        // 2. Crear EntityManager
        EntityManager em = emf.createEntityManager();

        // 3. Realizar SELECT
        List<Alumno> alumnos = em.createQuery(
                "SELECT a FROM Alumno a",
                Alumno.class
        ).getResultList();

        // 4. Mostrar resultados
        for (Alumno a : alumnos) {

            System.out.println(a);

        }

        // 5. Cerrar conexión
        em.close();

        emf.close();
    }
}
