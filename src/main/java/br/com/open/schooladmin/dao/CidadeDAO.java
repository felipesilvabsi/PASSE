/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.dao;

import br.com.open.schooladmin.modelo.Cidade;
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
public class CidadeDAO extends AbstractDao<Cidade> {

    public CidadeDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(Cidade obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "INSERT INTO cidade (nome, sigla_estado) VALUES (?, ?)";

            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getEstado().getSigla());

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
    public void saveAll(List<Cidade> objs) throws DaoException {
        //
    }

    @Override
    public void update(Cidade obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "UPDATE cidade SET nome = ?, sigla_estado = ? WHERE codigo = ?";

            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getEstado().getSigla());
            stm.setLong(3, obj.getCodigo());

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
    public void delete(Cidade obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = getConnection();
            this.beginTransaction();

            String sql = "DELETE FROM cidade WHERE codigo = ?";

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
        //
    }

    @Override
    public List<Cidade> findAll() throws DaoException {
        List<Cidade> lista = new ArrayList<Cidade>();
        Cidade cidade;

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM cidade ORDER BY nome";

            rs = stm.executeQuery(sql);

            while (rs.next()) {
                cidade = new Cidade();
                cidade.setCodigo(rs.getLong("codigo"));
                cidade.setNome(rs.getString("nome"));

                lista.add(cidade);
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
    public List<Cidade> findByParams(HashMap<String, Object> params) throws DaoException {
        List<Cidade> lista = new ArrayList<Cidade>();
        Cidade cidade;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            String sql = "SELECT * FROM cidade";

            stm = this.getPreparedStatementByHashMap(con, sql, params);

            rs = stm.executeQuery();

            while (rs.next()) {
                cidade = new Cidade();
                cidade.setCodigo(rs.getLong("codigo"));
                cidade.setNome(rs.getString("nome"));

                lista.add(cidade);
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
    public Cidade findById(long id) throws DaoException {
        Cidade cidade = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT * FROM cidade WHERE codigo = ?";

            con = getConnection();

            stm = con.prepareStatement(sql);

            stm.setLong(1, id);

            rs = stm.executeQuery();

            if (rs.next()) {

                cidade = new Cidade();
                cidade.setCodigo(rs.getLong("codigo"));
                cidade.setNome(rs.getString("nome"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }

        return cidade;
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
            String sql = "SELECT * FROM cidade";

            rs = stm.executeQuery(sql);

            if (rs.next()) {
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
