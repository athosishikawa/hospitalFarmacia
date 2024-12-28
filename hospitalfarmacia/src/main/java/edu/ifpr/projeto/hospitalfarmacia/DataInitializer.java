package edu.ifpr.projeto.hospitalfarmacia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DataInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DELETE FROM plano_medicamento;");
        jdbcTemplate.execute("DELETE FROM plano_tb;");
        jdbcTemplate.execute("DELETE FROM medicamento_tb;");
        
        jdbcTemplate.execute("DELETE FROM medico_tb;");
        jdbcTemplate.execute("DELETE FROM pessoa_tb;");
        jdbcTemplate.execute("DELETE FROM endereco_tb;");
        jdbcTemplate.execute("DELETE FROM paciente_tb;");
        jdbcTemplate.execute("DELETE FROM item_receita_tb;");
        jdbcTemplate.execute("DELETE FROM receita_tb;");


        jdbcTemplate.execute("INSERT INTO medicamento_tb (id, nome) VALUES (1, 'Dipirona');");
        jdbcTemplate.execute("INSERT INTO medicamento_tb (id, nome) VALUES (2, 'Amoxicilina');");
        jdbcTemplate.execute("INSERT INTO medicamento_tb (id, nome) VALUES (3, 'Ibuprofeno');");


        jdbcTemplate.execute("INSERT INTO plano_tb (id, nome) VALUES (1, 'Plano Básico');");
        jdbcTemplate.execute("INSERT INTO plano_tb (id, nome) VALUES (2, 'Plano Médio');");
        jdbcTemplate.execute("INSERT INTO plano_tb (id, nome) VALUES (3, 'Plano Premium');");

        jdbcTemplate.execute("INSERT INTO plano_medicamento (plano_id, medicamento_id) VALUES (1, 1);");
        jdbcTemplate.execute("INSERT INTO plano_medicamento (plano_id, medicamento_id) VALUES (1, 2);");
        jdbcTemplate.execute("INSERT INTO plano_medicamento (plano_id, medicamento_id) VALUES (2, 1);");
        jdbcTemplate.execute("INSERT INTO plano_medicamento (plano_id, medicamento_id) VALUES (2, 3);");
        jdbcTemplate.execute("INSERT INTO plano_medicamento (plano_id, medicamento_id) VALUES (3, 3);");
        jdbcTemplate.execute("INSERT INTO plano_medicamento (plano_id, medicamento_id) VALUES (3, 2);");

        // MÉDICO 1
        jdbcTemplate.execute(
            "INSERT INTO endereco_tb (id, bairro, cep, cidade, estado, logradouro, numero) " +
            "VALUES (1, 'Centro', '12345-678', 'Londrina', 'PR', 'Rua Principal', '100');");

        jdbcTemplate.execute(
            "INSERT INTO pessoa_tb (id, nome, idade, cpf, data_nascimento, id_endereco) " +
            "VALUES (1, 'Dr. João Silva', '45', '123.456.789-00', '1978-05-15', 1);");

        jdbcTemplate.execute(
            "INSERT INTO medico_tb (id, pessoa_id, crm, assinatura_digital) " +
            "VALUES (1, 1, '12345', 'assinatura123');");


        //MÉDICO 2
    }
}