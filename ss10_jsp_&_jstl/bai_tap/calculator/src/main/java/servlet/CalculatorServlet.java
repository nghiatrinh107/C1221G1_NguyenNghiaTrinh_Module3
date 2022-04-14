package servlet;

import models.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
//        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
//        char operator = request.getParameter("operator").charAt(0);
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Result:</h1>");
//        try{
//            float result = Calculator.calculate(firstOperand, secondOperand, operator);
//            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
//        }catch (Exception ex){
//            writer.println("Error: " + ex.getMessage());
//        }
//        writer.println("</html>");
        String message = "";
        float firstOperand = 0;
        float secondOperand = 0;
        char operator = request.getParameter("operator").charAt(0);
        float result = 0;
        try {
            firstOperand = Float.parseFloat(request.getParameter("first-operand"));
            secondOperand = Float.parseFloat(request.getParameter("second-operand"));
        } catch (NumberFormatException numberFormatException) {
            message = "ô giá trị không được rỗng";
        }
        try {
            result = Calculator.calculate(firstOperand, secondOperand, operator);
        } catch (RuntimeException runtimeException) {
            message = "mẫu không được là 0 ";
        }
        request.setAttribute("message", message);
        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("secondOperand", secondOperand);
        request.setAttribute("operator", operator);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/index.jsp").forward(request, response);


}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
