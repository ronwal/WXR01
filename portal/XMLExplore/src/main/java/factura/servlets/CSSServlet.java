/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

/**
 *
 * @author German17
 */
@WebServlet(name = "CSSServlet", urlPatterns = {"*.css"})
public class CSSServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cssFile = request.getRequestURI();
        if (cssFile == null) {
            return;
        }
        if (cssFile.contains("/")) {
            int index = cssFile.lastIndexOf("/");
            cssFile = cssFile.substring(index + 1, cssFile.length());
        }

        String realPath = request.getServletContext().getRealPath("resources/css/" + cssFile);

        File file = new File(realPath);
        if (!file.exists()) {
            return;
        }

        FileInputStream in = new FileInputStream(file);
        byte buffer[] = new byte[1024 * 5];
        int lenght = 0;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((lenght = in.read(buffer)) > 0) {
            out.write(buffer, 0, lenght);
        }
        out.flush();
        out.close();
        in.close();

        Properties properties = new Properties();
        properties.load(new FileInputStream(request.getServletContext().getRealPath("resources/css/css.properties")));

        String style = out.toString();

        int start;
        int end;
        String key;
        String value;

        while (style.contains("$[")) {
            start = style.indexOf("$[");
            end = style.indexOf("]", start);
            key = style.substring(start + 2, end );
            value = properties.getProperty(key);
            if (value != null) {
                style = style.substring(0, start) + value + style.substring(end + 1, style.length());
            } else {
                style = style.substring(0, start) + "no-define-css-property" + style.substring(end + 1, style.length());
            }
        }
        
        String lineSeparator=System.getProperty("line.separator");
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, "");
        }
        
        lineSeparator="\n";
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, "");
        }
        
        lineSeparator="\r";
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, "");
        }
        
        lineSeparator="\n\r";
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, "");
        }
        
        lineSeparator="\r\n";
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, "");
        }
        
        lineSeparator="  ";
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, " ");
        }
        
        lineSeparator="\t";
        while(style.contains(lineSeparator)){
            style=style.replace(lineSeparator, " ");
        }

        response.setContentType("text/css");
        OutputStream output = response.getOutputStream();
        try {
            output.write(style.getBytes());
            output.flush();
        } finally {

            output.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
