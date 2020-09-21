package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", urlPatterns = "/controllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int x = Integer.parseInt(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            int r = Integer.parseInt(req.getParameter("r_field"));
            getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, resp);
        } catch (NumberFormatException | NullPointerException exception ){
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e){
            PrintWriter writer = resp.getWriter();
            writer.write("error");
            writer.close();
        }
    }
}