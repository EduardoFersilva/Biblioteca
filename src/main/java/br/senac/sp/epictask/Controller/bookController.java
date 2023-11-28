package br.senac.sp.epictask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import br.senac.sp.epictask.Model.Book;
import br.senac.sp.epictask.repository.BookRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("book")
public class bookController {
    @Autowired
    BookRepository repository;

    @GetMapping
    public String index(Model model){
        var lista = repository.findAll();
        System.out.println(lista);
        model.addAttribute("books", lista);
                System.out.println("entroroeroeoreooeor");

        return "book/index";
    }

    @GetMapping("new")
    public String form(Book book){
        return "book/form.html";
    }

    @PostMapping("new")
    public String save(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) return "book/form";
         repository.save(book);
        return "redirect:/book";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/book";
    } 
}
