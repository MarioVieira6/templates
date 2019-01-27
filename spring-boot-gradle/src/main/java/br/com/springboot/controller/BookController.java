package br.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.springboot.model.Book;

/**
 * <p>
 * Controlador da página de cadastro de livros.
 * </p>
 *
 * <pre>
 * <code>@Controller</code> -> define a classe como sendo um controlador da página.
 * <code>@RequestMapping("/books")</code> -> define a url em que a página será acessada: <i>localhost:8080/books</i>
 * </pre>
 */
@Controller
@RequestMapping("/books")
public class BookController {

    /**
     * <p>
     * Ao acessar a url <b>/books</b>, o método <code>newBook()</code> será
     * acessado através do verbo <b>GET</b> definido pela anotação
     * <code>@GetMapping</code>. Através da classe <code>ModelAndView</code> a
     * pagina html <b>Book</b> sera renderizada na tela com o objeto
     * <code>book</code> inicializado para alteração de valores.
     * </p>
     *
     * @return o conteudo da página <b>BookRegistry.html</b> na tela
     */
    @GetMapping
    public ModelAndView newBook() {
        final ModelAndView mv = new ModelAndView("Book", "book", new Book());
        return mv;
    }

    /**
     * <p>
     * Uma chamada ao método <code>print()</code> será feita pelo cliente com os
     * valores preenchidos do Livro, cujo valor, sera imprimido no console
     * através do verbo <b>POST</b> definido pela anotação
     * <code>@PostMapping</code>.
     * </p>
     *
     * @param book
     *            Objeto preenchido
     * @return pagina <b>/books</b> atualizada.
     */
    @PostMapping
    public String print(final Book book) {
        System.out.println(book);
        return "redirect:/books";
    }

}
