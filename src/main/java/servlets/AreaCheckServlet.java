package servlets;

import models.JavaBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import static java.lang.Math.*;


@WebServlet(name = "AreaCheckServlet", urlPatterns = "/areaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    private Integer[] arrayValidX = {-5, -4, -3, -2, -1, 0, 1, 2, 3};
    private Integer[] arrayValidR = {1, 2, 3, 4, 5};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("jb")==null) {
            JavaBean javaBean = new JavaBean();
            session.setAttribute("jb",javaBean);
        }

        try {
            int x = Integer.parseInt(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            int r = Integer.parseInt(req.getParameter("r_field"));

            if (Arrays.asList(arrayValidX).contains(x) && Arrays.asList(arrayValidR).contains(r) && (y > -3.0) && (y < 5.0)) {
                ((JavaBean) session.getAttribute("jb")).addEntry(x, y, r, batman(x, y, r));
                req.getRequestDispatcher("result.jsp").forward(req, resp);
            } else {
                PrintWriter writer = resp.getWriter();
                writer.write("data is not valid");
                writer.close();
            }
        } catch (NumberFormatException | NullPointerException exception ){
            PrintWriter writer = resp.getWriter();
            writer.write("data is not valid");
            writer.close();
        }
    }

    //формула
    private boolean batman (int xx, double y, int R){
        double rx = R/7.0;
        double ry = R/6.0;
        double x = xx+0.0;
        boolean elipce = ( (pow(x,2))/(49*pow(rx,2)) + (pow(y,2))/(9*pow(ry,2)) -1.0 ) <= 0.00000000000001;
        boolean elipce_down_x = (abs(x/rx)) >= 4;
        boolean elipce_down_y = (y/ry >= -3*sqrt(33)/7.0) && (y/ry <= 0);
        boolean elipce_up_x = (abs(x/rx)) >= 3;
        boolean elipce_up_y = y>=0;
        boolean full_elipce = (elipce&elipce_down_x&elipce_down_y) || (elipce&elipce_up_x&elipce_up_y);

        boolean smile = ( ((3*sqrt(33)-7)*pow(x,2))/(-112.0*pow(rx,2)) + abs(x/rx)/2
                +sqrt(1-pow(abs((abs(x/rx))-2)-1,2)) - y/ry -3) <=0;
        boolean smile_y = (y/ry>=-3) && (y/ry<=0);
        boolean smile_x = (x/ry<=4) && (x/ry>=-4);

        boolean full_smile = smile&smile_x&smile_y;


        boolean ears_y = y>=0;
        boolean ears_x = abs(x/rx)<=1 && abs(x/rx)>=0.75;
        boolean ears = -8*abs(x/rx)-y/ry+9>=0;

        boolean full_ears = ears&ears_x&ears_y;

        boolean ears2_x = abs(x/rx)<=0.75 && abs(x/rx)>=0.5;
        boolean ears2 = 3*abs(x/rx)-y/ry+0.75>=0;

        boolean full_ears2 = ears2&ears2_x&ears_y;

        boolean chelka_y = y>=0;
        boolean chelka_x = abs(x/rx)<=0.5;
        boolean chelka=9.0/4.0 - y/ry >=0;

        boolean chelka_full = chelka_x&&chelka_y&&chelka;

        boolean wings_x = abs(x/rx)<=3 && abs(x/rx)>=1;
        boolean wings_y = y>=0;
        boolean wings = -abs(x/rx)/2 - (3.0/7.0)*sqrt(10)*sqrt(4-pow(abs(x/rx)-1,2)) - y/ry + (6*sqrt(10))/7.0 + 1.5 >=0;

        boolean full_wings = wings&&wings_y&&wings_x;
        return full_elipce || full_smile || full_ears || full_ears2 || full_wings || chelka_full;
    }
}