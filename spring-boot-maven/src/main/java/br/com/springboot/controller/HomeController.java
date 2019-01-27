package br.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * Controlador da página principal da aplicação
 * </p>
 *
 * <pre>
 * <code>@Controller</code> -> define a classe como sendo um controlador da página.
 * <code>@RequestMapping("/")</code> -> define a url em que a página será acessada: <i>localhost:8080/</i>
 * </pre>
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * <p>
     * Ao acessar a url inicial, o método <code>index()</code> será acessado
     * através do verbo <b>GET</b> definido pela anotação
     * <code>@GetMapping</code>. Através da classe <code>ModelAndView</code> o
     * <b>Spring</b> procura pelo nome da página definido no construtor da
     * classe sem o prefixo. Por padrão o prefixo é <b>.html</b>. A página
     * encontrada é renderizada na tela seguindo a url definida no controlador.
     * </p>
     *
     * @return o conteudo da página <b>Index.html</b> na tela
     */
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("Index");
    }
}
