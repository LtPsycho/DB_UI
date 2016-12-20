package com.mycompany.app.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.app.model.Person;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class JdbcDAO {
    private static Connection connection;
    private static DatabaseConnection dbConnection;


    static {

        try {
            System.out.println("Connecting to database...");
            dbConnection = new DatabaseConnection();

            connection = dbConnection.getDatabaseConnection();
            if (connection == null) {
                System.out.println("No database found");
            }
        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);

        }

    }

    @GetMapping("/")
    public String personForm(Model model, Person person) {
        model.addAttribute("form", new Person());
        return "form";
    }

    @PostMapping("/")
    public String addPerson(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        QueryRunner run = new QueryRunner();
        try {

            int inserts = run.update(connection, "INSERT INTO darbuotojai (pavarde, vardas, pareigos_id, lytis, vaikai, data_nuo, data_iki) VALUES (?,?,?,?,?,?,?)"
                    , person.getPavarde(), person.getVardas(), person.getPareigosID(), person.getLytis(), person.getVaikai(), person.getData_nuo(), person.getData_iki());

        } catch (SQLException sqle) {

            throw new RuntimeException("Problem updating", sqle);

        }
        return "result";
    }

    @PostMapping("/dbeditor")
    public String removePerson(@RequestParam(value = "id", required = true) String id) {
        QueryRunner run = new QueryRunner();
        try {

            int inserts = run.update(connection, "DELETE FROM darbuotojai WHERE _id_ = " + id);

        } catch (SQLException sqle) {

            throw new RuntimeException("Problem updating", sqle);

        }
        return "redirect:/dbeditor";
    }


    @RequestMapping("/dbeditor")
    public String listDarbuotojai(Model model) {

        QueryRunner run = new QueryRunner();

        try {

            ResultSetHandler<List<Person>> h = new BeanListHandler<Person>(Person.class, new BasicRowProcessor(new GenerousBeanProcessor())); // 1

            model.addAttribute("dbeditor", run.query(connection, "SELECT * FROM darbuotojai", h));


            return "dbeditor";

        } catch (SQLException sqle) {

            throw new RuntimeException("Problem updating", sqle);

        }

    }


}