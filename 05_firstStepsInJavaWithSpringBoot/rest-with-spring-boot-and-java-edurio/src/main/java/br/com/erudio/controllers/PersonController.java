package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service; //Notation @Service na classe PersonService - Faz o mesmo da linha de baixo só que dinamicamente
    //private PersonService = new PersonService()

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //Requisição padrão do endpoint - atende pelo get em "/person"
    public List<Person> findAll(){
        return service.findAll();
    }
 
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) //Request mapping permite o controller lidar com as requisições com parâmetros, mapeia as requests pro método manipulador específico - Produces especifica o formato do media type devolvido
    public Person findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
    produces = MediaType.APPLICATION_JSON_VALUE, 
    consumes = MediaType.APPLICATION_JSON_VALUE) //Request mapping permite o controller lidar com as requisições com parâmetros, mapeia as requests pro método manipulador específico - Produces especifica o formato do media type devolvido - consumes informa que vai consumir um JSON
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping(
    produces = MediaType.APPLICATION_JSON_VALUE, 
    consumes = MediaType.APPLICATION_JSON_VALUE) //Request mapping permite o controller lidar com as requisições com parâmetros, mapeia as requests pro método manipulador específico - Produces especifica o formato do media type devolvido - consumes informa que vai consumir um JSON
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}") //Request mapping permite o controller lidar com as requisições com parâmetros, mapeia as requests pro método manipulador específico
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
