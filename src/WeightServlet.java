import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calcweight")
public class WeightServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String kilograms = request.getParameter("kilogramy");
        String grams = request.getParameter("gramy");
        String miligrams = request.getParameter("miligramy");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int unit = units(kilograms, grams, miligrams);

        if (unit != 1) {
            response.getWriter().println("<h3>wpisz tylko jedną wartość</h3>");
            return;
        }
        int kilogramsMeasure = 0;
        int gramsMeasure = 0;
        int miligramsMeasure = 0;

        if (request.equals(kilograms)) {
            kilogramsMeasure = Integer.valueOf(kilograms);
            gramsMeasure = kilogramsMeasure * 1000;
            miligramsMeasure = kilogramsMeasure * 1000000;
        }
        if (request.equals(grams)) {
            gramsMeasure = Integer.valueOf(grams);
            kilogramsMeasure = gramsMeasure / 1000;
            miligramsMeasure = gramsMeasure * 1000;
        }
        if (request.equals(miligrams)) {
            miligramsMeasure = Integer.valueOf(miligrams);
            kilogramsMeasure = miligramsMeasure / 1000000;
            gramsMeasure = miligramsMeasure / 1000;
        }
        response.getWriter().println("Przeliczona wartości w przeliczeniu na:");
        response.getWriter().println("kilogramy:" + kilogramsMeasure + "kg");
        response.getWriter().println("gramy:" + gramsMeasure + "g");
        response.getWriter().println("miligramy:" + miligramsMeasure + "mg");
    }
    private int units (String kilograms, String grams, String miligrams){
        int unit = 0;

        String request = null;

        if(request.equals(kilograms)) {
            unit++;
        }
        if(request.equals(grams)) {
            unit++;
        }
        if(request.equals(miligrams)) {
            unit++;
        }
        return unit;
    }
}