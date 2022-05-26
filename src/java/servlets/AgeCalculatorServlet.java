package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");
        String msg;
        
        // Checks if "age" is empty
        if(age.equals("") || age.equals(null)) {
            msg = "You must give your current age.";
        }
        // Checks if "age" is not a number
        else if(!age.matches(".*[0-999].*")) {
            msg = "You must enter a number";
        }
        else {
            // Converts "age" to an int
            int ageNum = Integer.parseInt(age);
            ageNum++;
            
            msg = "Your age next birthday will be " + ageNum;
        }
        
        request.setAttribute("msg", msg);
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
}
