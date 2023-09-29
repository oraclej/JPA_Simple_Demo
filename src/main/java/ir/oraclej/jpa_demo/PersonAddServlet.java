package ir.oraclej.jpa_demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Person;

import java.io.IOException;

@WebServlet(urlPatterns = "/padd")
public class PersonAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Person person = new Person(id, name, age);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(person);
        tx.commit();
        entityManager.close();
        resp.sendRedirect("plist");
    }
}
