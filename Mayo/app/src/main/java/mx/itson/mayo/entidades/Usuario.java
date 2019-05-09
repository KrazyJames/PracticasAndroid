package mx.itson.mayo.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import mx.itson.mayo.database.MayoDB;

public class Usuario {

    Context context;

    public Usuario(){

    }

    public Usuario(Context context){
        this.context = context;
    }

    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public void guardar(String nombre, String telefono, String correo){
        try{
            MayoDB mayoDB = new MayoDB(context, "MayoDB", null, 1);
            SQLiteDatabase baseDatos = mayoDB.getReadableDatabase();
            baseDatos.execSQL("INSERT INTO usuario(nombre, telefono, correo)" +
                    "VALUES('"+ nombre +"','"+ telefono +"','"+ correo +"')");
            baseDatos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            MayoDB mayoDB = new MayoDB(context, "MayoDB", null, 1);
            SQLiteDatabase sqLiteDatabase = mayoDB.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT id, nombre, telefono, correo FROM usuario", null);
            while (cursor.moveToNext()){
                Usuario u = new Usuario();
                u.setId(cursor.getInt(0));
                u.setNombre(cursor.getString(1));
                u.setTelefono(cursor.getString(2));
                u.setCorreo(cursor.getString(3));
                usuarios.add(u);
            }
            sqLiteDatabase.close();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
