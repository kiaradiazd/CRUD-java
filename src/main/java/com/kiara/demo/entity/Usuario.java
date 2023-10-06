package com.kiara.demo.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String username;
    private int edad;

    public Usuario(){}

    public Usuario(String nombre, String apellido,String username ,int edad, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.edad = edad;
        this.contraseña = contraseña;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
