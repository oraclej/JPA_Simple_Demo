package ir.oraclej.jpa_demo;

import java.io.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.Person;

@WebServlet(name = "helloServlet", value = "/plist")
public class PersonListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createQuery("select p from person p");
        List<Person> list = query.getResultList();
       request.setAttribute("personList", list);
       request.getRequestDispatcher("personList.jsp").forward(request, response);
    }
}