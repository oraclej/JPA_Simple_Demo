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

@WebServlet(urlPatterns = "/pdelete")
public class PersonDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        tx.commit();
        entityManager.close();
        resp.sendRedirect("plist");

    }
}
