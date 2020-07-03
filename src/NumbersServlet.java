import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calcmeter")
public class NumbersServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String meters = request.getParameter("metry");
        String centimeters = request.getParameter("centymetry");
        String milimeters = request.getParameter("milimetry");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int unit = units(meters,centimeters,milimeters);
        if (unit != 1) {
            response.getWriter().println("<h3>wpisz tylko jedną wartość</h3>");
            return;
        }
        int  metersMeasure = 0;
        int  centimetersMeasure = 0;
        int  milimetersMeasure = 0;

        if (request.equals(meters)) {
            metersMeasure = Integer.valueOf(meters);
            centimetersMeasure = metersMeasure * 100;
            milimetersMeasure = metersMeasure * 1000;
        }
        if (request.equals(centimeters )) {
            centimetersMeasure = Integer.valueOf(centimeters);
            metersMeasure = centimetersMeasure / 100;
            milimetersMeasure = centimetersMeasure * 10;
        }
        if (request.equals(milimeters)) {
            milimetersMeasure = Integer.valueOf(milimeters);
            metersMeasure = milimetersMeasure / 1000;
            centimetersMeasure = milimetersMeasure / 10;
        }
        response.getWriter().println("Przeliczona wartości w przeliczeniu na:");
        response.getWriter().println("metry:" + metersMeasure + "m");
        response.getWriter().println("centymetry:" + centimetersMeasure + "cm");
        response.getWriter().println("milimetry:" + milimetersMeasure + "mm");
    }

    private int units(String meters, String centimeters, String milimeters) {
        int unit = 0;

        String request = null;
        
        if(request.equals(meters)){
        unit++;
    }
    if(request.equals(centimeters)){
            unit++;
    }
    if(request.equals(milimeters)){
        unit++;
    }
    return unit;
}
}

