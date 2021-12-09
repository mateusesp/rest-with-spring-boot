package br.com.erudio.controller;

import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.services.BooksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(tags = "Books endpoint")
@RestController
@RequestMapping("/api/books/v1")
public class BooksController {

    @Autowired
    private BooksService service;

    @ApiOperation(value = "Find all books recorded")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<BooksVO> findAll() {
        List<BooksVO> books = service.findAll();
        books
                .forEach(p -> p.add(
                                linkTo(methodOn(BooksController.class).findById(p.getKey())).withSelfRel()
                        )
                );
        return books;
    }

    @ApiOperation(value = "Find recorded book by id")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public BooksVO findById(@PathVariable("id") Long id) {
        BooksVO booksVO = service.findById(id);
        booksVO.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
        return booksVO;
    }

    @ApiOperation(value = "Register new book")
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BooksVO create(@RequestBody BooksVO books) {
        BooksVO booksVO = service.create(books);
        booksVO.add(linkTo(methodOn(BooksController.class).findById(booksVO.getKey())).withSelfRel());
        return booksVO;
    }

    @ApiOperation(value = "Update book in database")
    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BooksVO update(@RequestBody BooksVO books) {
        BooksVO booksVO = service.update(books);
        booksVO.add(linkTo(methodOn(BooksController.class).findById(booksVO.getKey())).withSelfRel());
        return booksVO;
    }

    @ApiOperation(value = "Delete book by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}