/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silvadee.a2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import silvadee.a2.business.PyramidBean;
import silvadee.a2.business.PyramidValidator;
import silvadee.a2.util.CookieUtil;

/**
 *
 * @author Deemantha
 */
public class PyramidServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        String jspPath = "/WEB-INF/jsp/";
        String view;
        PyramidBean pData = new PyramidBean();

        switch (action) {

            case "/InputPyramid.do": {
                Cookie[] cookies = request.getCookies();
                String storeCookies = CookieUtil.getCookieValue(cookies, "data");
                if (!storeCookies.isEmpty()) {
                    try {
                        String[] tokens = storeCookies.split(",");
                        pData.setBaseN(tokens[0]);
                        pData.setBaseSide(tokens[1]);
                        pData.setHeight(tokens[2]);
                    } catch (Exception e) {

                    }
                }
                request.setAttribute("pDataCookies", pData);
                view = "InputPyramid";
                break;

            }

            case "/InsertPyramid.do": {
                String bases = request.getParameter("baseN");
                String sides = request.getParameter("baseSide");
                String heights = request.getParameter("height");
                PyramidValidator pValidator = new PyramidValidator(bases, sides, heights);
                int count = pValidator.errorsCount;
                if (count == 0) {
                    pData.setBaseN(request.getParameter("baseN"));
                    pData.setBaseSide(request.getParameter("baseSide"));
                    pData.setHeight(request.getParameter("height"));
                    request.setAttribute("Pyramid", pData);

                    Cookie cookie = new Cookie("data", String.format("%s,%s,%s", bases, sides, heights));
                    cookie.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(cookie);

                    view = "ConfirmPyramid";
                } else {
                    view = "PyramidErrors";
                    request.setAttribute("pDataCookies", pValidator);
                    request.setAttribute("errors", pValidator);

                }
                break;

            }

            default: {
                response.sendError(404);
                return;
            }
        }

        String greeting = getInitParameter("greeting");
        request.setAttribute("greeting", greeting);

        request.getRequestDispatcher(jspPath + view + ".jsp")
                .forward(request, response);

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
