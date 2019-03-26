/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 56974
 */
public class PersonaDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();

    @Override
    public List listar() {

        ArrayList<Persona> list = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setRut(rs.getString("rut"));
                per.setNombre(rs.getString("nombre"));
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    @Override
    public Persona list(int id) {
        String sql = "SELECT * FROM persona WHERE id=" + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setRut(rs.getString("rut"));
                p.setNombre(rs.getString("nombre"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return p;
    }

    @Override
    public boolean add(Persona per) {
        String sql = "INSERT INTO persona (rut, nombre) VALUES (?,?)";

        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, per.getRut());
            ps.setString(2, per.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;

    }

    @Override
    public boolean edit(Persona per) {
        String sql = "UPDATE persona SET rut=? , nombre= ? WHERE id=" + per.getId();
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, per.getRut());
            ps.setString(2, per.getNombre());
            ps.executeUpdate();

        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM persona WHERE id="+ id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
return false;
    }

}
