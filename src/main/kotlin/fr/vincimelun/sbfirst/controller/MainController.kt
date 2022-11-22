package fr.vincimelun.sbfirst.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.io.PrintWriter
import java.lang.IllegalArgumentException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Controller
class MainController {

    @GetMapping("/")
    fun index(model: Model): String {
        model["title"] = "Hello world !"
        return "main/index"
    }

    @GetMapping("/hello")
    @ResponseBody
    fun hello(response: HttpServletResponse, request: HttpServletRequest): String {
        response.contentType = "text/plain"
        response.characterEncoding = "UTF-8"
        var nom: String = request.getParameter("nom") ?: ""
        if (nom.isEmpty())
            nom = request.session.getAttribute("nom")?.toString() ?: "inconnu"
        else
            request.session.setAttribute("nom", nom)
        return "Hello $nom\n"
    }

    @GetMapping("/hello-bis")
    @ResponseBody
    fun hello(@RequestParam(defaultValue = "") nom: String,
              response: HttpServletResponse,
              request: HttpServletRequest): String {
        response.contentType = "text/plain"
        response.characterEncoding = "UTF-8"
        val nomInSession =
            if (nom.isEmpty())
                request.session.getAttribute("nom")?.toString() ?: "inconnu"
            else {
                request.session.setAttribute("nom", nom)
                nom
            }
        return "Hello $nom\n"
    }

    // réponse directe au client (sans vue)
    @GetMapping("/demo-ge")
    fun demoException(response: HttpServletResponse) {
        response.contentType = "text/plain"
        response.characterEncoding = "UTF-8"
        val tab1 = intArrayOf(2, 3, 0, 1, 7)
        val tab2 = intArrayOf(2, 2, 2, 2, 2)
        val tab3 = intArrayOf() // vide
        val tab4 = intArrayOf(2, -3, 4, 1, 7)
        val writer: PrintWriter = response.getWriter()
        writer.println("Test de la fonction min")
        try {
            writer.println("le minmum de tab1 = " + min(tab1));
            writer.println("le minmum de tab2 = " + min(tab2));
            writer.println("le minmum de tab3 = " + min(tab3));
            writer.println("le minmum de tab4 = " + min(tab4));
        } catch (e: IllegalArgumentException){
            writer.println("ERREUR : " + e.message)
        }
        writer.println("Fin du test.");
    }
}

/**
 * Obtenir la valeur minimum d'une liste
 *
 * @param list d'entiers
 * @return la valeur minimale
 * @throws IllegalArgumentException si liste est vide
 */
fun min(list: IntArray): Int {
    if (list.isEmpty()) {
        throw IllegalArgumentException("min sur liste vide IMPOSSIBLE")
    }
    var minNb: Int = list[0]

    for (i in list.indices) {
        if (minNb > list[i]) minNb = list[i]
    }
    return minNb
}

/**
 * Réalise le transfert d'une somme donnée du compte à un autre compte
 *
 * @param destinataire celui qui bénéficie du transmfert
 * @param montant le montant à transféré
 * @throws IllegalOperationException si crédit de this insuffisant
 */
//@Throws(IllegalOperationException)
//fun transfert(destinataire: Int, montant: Double) {
//
//}

//
//fun min(list: IntArray): Int {
//    var minNb: Int = 0
//    for (i in list.indices) {
//        if (i == 0) {
//            minNb = list[i]
//        } else {
//            if (minNb > list[i]) minNb = list[i]
//        }
//    }
//    return minNb
//}


//
//fun min(list: IntArray): Int {
//    var minNb: Int = if (list.size > 0) list[0] else throw IllegalArgumentException("min : impossible sur liste vide !");
//    for (i in list.indices) {
//        if (i == 0) {
//            minNb = list[i]
//        } else {
//            if (minNb > list[i]) minNb = list[i]
//        }
//    }
//    return minNb
//}