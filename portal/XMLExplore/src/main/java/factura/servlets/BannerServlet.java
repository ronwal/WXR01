/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.servlets;

import ec.ste.factura.ConfigurationManager;
import ec.ste.factura.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author German17
 */
@WebServlet(name = "ImageServlet", urlPatterns = {"*.banner"})
public class BannerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String servletPath = request.getServletPath();
            String bannerName = servletPath.substring(servletPath.lastIndexOf("/") + 1, servletPath.indexOf(".banner"));

            String path = ConfigurationManager.getInstance().getBannersPath();
            if (!path.endsWith("/")) {
                path += "/";
            }

            path += bannerName + ".png";
            
            File file = new File(path);
            if (file.exists()) {
                sendImage(response, file);
                return;
            } else {
                path = ConfigurationManager.getInstance().getStorePath();
                if (!path.endsWith("/")) {
                    path += "/";
                }
                path += "no-banner.png";
                
                file = new File(path);
                if (file.exists()) {
                    sendImage(response, file);
                    return;
                }
            }
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void sendImage(HttpServletResponse r, File f) throws Exception {
        r.setContentType("image/png");
        r.setContentLength((int) f.length());
        OutputStream out = r.getOutputStream();
        byte data[] = FileUtil.openFile(f);
        out.write(data);
        out.flush();
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
