package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LembreteDAO {

    public void insert(Timestamp dataHora, int anotacaoId) throws SQLException {
        String sql = "INSERT INTO lembrete(data_hora, anotacao_id) VALUES(?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setTimestamp(1, dataHora);
            statement.setInt(2, anotacaoId);
            statement.executeUpdate();
        }
    }

    public List<Timestamp> findAllReminders() throws SQLException {
        List<Timestamp> lembretes = new ArrayList<>();
        String sql = "SELECT data_hora FROM lembrete";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                lembretes.add(resultSet.getTimestamp("data_hora"));
            }
        }
        return lembretes;
    }

    // Adicione outros métodos como update e delete conforme necessário.
}
