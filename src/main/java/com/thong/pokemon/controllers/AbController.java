package com.thong.pokemon.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AbController", value = "/AbController")
public class AbController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pokemonName = "concac";
        String pokemonConcac = "concac";
        request.setAttribute("pokemonName", pokemonName);
        request.setAttribute("pokemonConcac", pokemonConcac);
        System.out.println(request.getAttribute("pokemonName"));
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/ab.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}