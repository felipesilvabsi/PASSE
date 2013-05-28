/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.dao;

import br.com.open.schooladmin.modelo.Usuario;
import br.com.open.schooladmin.persistencia.AbstractDao;
import br.com.open.schooladmin.persistencia.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Felipe Silva
 */
public class UsuarioDAO extends AbstractDao<Usuario> {

    public UsuarioDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(Usuario obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "INSERT INTO usuario (login, MD5(senha), email, codigo_perfil) VALUES (?, ?, ?, ?)";

            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getLogin());
            stm.setString(2, obj.getSenha());
            stm.setString(3, obj.getEmail());
            stm.setLong(4, obj.getPerfil().getCodigo());

            stm.executeUpdate();

            this.commitTransaction();

        } catch (SQLException e) {
            try {
                this.rollbackTransaction();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            this.free(con, stm, null, null);
        }
        return 0;
    }

    @Override
    public void saveAll(List<Usuario> objs) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "UPDATE usuario SET login = ?, senha = MD5(?), emal = ?, codigo_perfil = ? WHERE codigo = ?";

            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getLogin());
            stm.setString(2, obj.getSenha());
            stm.setString(3, obj.getEmail());
            stm.setLong(4, obj.getPerfil().getCodigo());
            stm.setLong(5, obj.getCodigo());

            stm.executeUpdate();

            this.commitTransaction();

        } catch (SQLException e) {
            try {
                this.rollbackTransaction();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            this.free(con, stm, null, null);
        }
    }

    @Override
    public void delete(Usuario obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = getConnection();
            this.beginTransaction();

            String sql = "DELETE FROM usuario WHERE codigo = ?";

            stm = con.prepareStatement(sql);
            stm.setLong(1, obj.getCodigo());

            stm.executeUpdate();

            this.commitTransaction();

        } catch (SQLException e) {
            try {
                this.rollbackTransaction();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            this.free(con, stm, null, null);
        }
    }

    @Override
    public void deleteByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll() throws DaoException {
        List<Usuario> lista = new ArrayList<Usuario>();
        Usuario usuario;

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM cidade ORDER BY nome";

            rs = stm.executeQuery(sql);

            PerfilDAO perfilDAO = new PerfilDAO(false);
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getLong("codigo"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(perfilDAO.findById(rs.getLong("codigo_perfil")));

                lista.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }
        return lista;
    }

    @Override
    public List<Usuario> findByParams(HashMap<String, Object> params) throws DaoException {
        List<Usuario> lista = new ArrayList<Usuario>();
        Usuario usuario;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            String sql = "SELECT * FROM usuario";

            stm = this.getPreparedStatementByHashMap(con, sql, params);

            rs = stm.executeQuery();

            PerfilDAO perfilDAO = new PerfilDAO(false);
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getLong("codigo"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(perfilDAO.findById(rs.getLong("codigo_perfil")));

                lista.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }
        return lista;
    }

    @Override
    public Usuario findById(long id) throws DaoException {
        Usuario usuario = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT * FROM usuario WHERE codigo = ?";

            con = getConnection();

            stm = con.prepareStatement(sql);

            stm.setLong(1, id);

            rs = stm.executeQuery();

            PerfilDAO perfilDAO = new PerfilDAO(false);
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getLong("codigo"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(perfilDAO.findById(rs.getLong("codigo_perfil")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }

        return usuario;
    }

    @Override
    public void clean() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() throws DaoException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM usuario";

            rs = stm.executeQuery(sql);

            if (rs.next()) {

                rs.last();
                return rs.getRow();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }

        return 0;
    }
}
