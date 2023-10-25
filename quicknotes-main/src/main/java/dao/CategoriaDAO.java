package dao;

import model.Anotacao;
import model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT c.id as categoria_id, c.nome as categoria_nome " +
                "FROM categoria c " +
                "LEFT JOIN categoria c ON a.categoria_id = c.id";
        return categorias;
    }

    public void insert(String nome) throws SQLException {
        String sql = "INSERT INTO categoria(nome) VALUES(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.executeUpdate();
    }

    public List<Categoria> findAll() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                categoria.setId(id);
                categoria.setNome(nome);
                categorias.add(categoria);
            }
        }
        DBConnection.closeConnection();
        return categorias;
    }

    // Adicione outros métodos como update e delete conforme necessário.
}
