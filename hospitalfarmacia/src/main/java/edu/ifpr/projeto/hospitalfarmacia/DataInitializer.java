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
        jdbcTemplate.execute("DELETE FROM plano_tb;");
        jdbcTemplate.execute("DELETE FROM medicamento_tb;");
        jdbcTemplate.execute("DELETE FROM plano_medicamento;");


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


    }
}