package fr.vincimelun.sbfirst.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class MainController {

    @GetMapping("/")
    fun index(model: Model): String {
        model["title"] = "Hello world !"
        return "main/hello"
    }

    @GetMapping("/hello")
    @ResponseBody
    fun index(response : HttpServletResponse, request : HttpServletRequest): String {
        response.setContentType("text/plain")
        response.setCharacterEncoding("UTF-8")
        var nom : String = request.getParameter("nom") ?: ""
        if (nom.isEmpty())
            nom = request.session.getAttribute("nom")?.toString() ?: "inconnu"
        else
            request.session.setAttribute("nom", nom)
        return "Hello $nom"
    }

}