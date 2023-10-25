package dao;

import model.Anotacao;
import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class AnotacaoDAO extends Anotacao{
    private Connection connection;

    public AnotacaoDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }


    public List<Anotacao> listar() {
        List<Anotacao> anotacoes = new ArrayList<>();
        String sql = "SELECT a.id as anotacao_id, a.titulo, a.conteudo, a.data, c.id as categoria_id, c.nome as categoria_nome " +
                "FROM anotacao a " +
                "LEFT JOIN categoria c ON a.categoria_id = c.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Anotacao anotacao = new Anotacao();
                anotacao.setId(rs.getInt("anotacao_id"));
                anotacao.setTitulo(rs.getString("titulo"));
                anotacao.setConteudo(rs.getString("conteudo"));

                anotacao.setData( rs.getString("data"));
//
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));

                anotacao.setCategoria(categoria);
                anotacoes.add(anotacao);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return anotacoes;
    }
    //metodo inserir
    public void Inserir (String titulo, String conteudo, String data, int categoria_id) throws SQLException {

        // aqui vai o codigo que será executado do SQL
        String sql = "INSERT INTO anotacao VALUES(null,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        // aqui em parameterIndex cada numero corresponde a uma coluna
        statement.setString(1, titulo);
        statement.setString(2, conteudo);
        statement.setString(3, data);
        statement.setInt(4, categoria_id);
        statement.executeUpdate();
    }
    // metodo deletar
    public void delete (String titulo) throws SQLException {
        String sql = "DELETE FROM anotacao WHERE id=(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, titulo);
        statement.executeUpdate();
    }
    //metodo atualizar
    public void update (String titulo) throws SQLException {
        String sql = "UPDATE FROM anotacao WHERE id=(?) SET()";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, titulo);
        statement.executeUpdate();
    }

}
