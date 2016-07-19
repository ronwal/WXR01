/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.servlets;

import ec.ste.factura.dao.EmpresaDao;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author German17
 */
@WebServlet(name = "EmpresaServlet", urlPatterns = {"*.com"})
public class EmpresaServlet extends HttpServlet {
    
    private EmpresaDao empresaDao=new EmpresaDao();

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
        String base=request.getContextPath();
        String query=request.getRequestURI();
        if(query.contains("/")){
            query=query.substring(query.lastIndexOf("/")+1, query.length());
        }
       
        try {
            Empresa empresa=empresaDao.findEmpresaByUrl(query);
            //System.out.println(empresa);
            if(empresa!=null){
                request.getSession(true).setAttribute("empCodigo", empresa.getEmpCodigo());
                response.sendRedirect(base+"/empresa/login.jsf");
            }else{
                response.sendRedirect(base+"/index.jsf");
            }
        } catch (DaoException ex) {
            response.sendRedirect(base+"/index.jsf");
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
