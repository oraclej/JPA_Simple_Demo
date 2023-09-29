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

@WebServlet(urlPatterns = "/pedit")
public class PersonEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();

        int id = Integer.parseInt(req.getParameter("id"));
        Person person = entityManager.find(Person.class, id);
        req.setAttribute("person", person);
        req.getRequestDispatcher("personEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Person person = entityManager.find(Person.class, id);
        person.setName(name);
        person.setAge(age);
        entityManager.merge(person);
        tx.commit();
        entityManager.close();
        resp.sendRedirect("plist");

    }
}
