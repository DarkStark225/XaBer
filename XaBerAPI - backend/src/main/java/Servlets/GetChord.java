package Servlets;

import Logic.Find;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getChords")
public class GetChord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Find find = new Find();
        String respString = find.find(req.getParameter("Name"));
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(respString);
    }
}
