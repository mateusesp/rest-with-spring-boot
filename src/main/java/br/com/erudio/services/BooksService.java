package br.com.erudio.services;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Books;
import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    BooksRepository repository;

    public BooksVO create(BooksVO books) {
        var entity = DozerConverter.parseObject(books, Books.class);
        var vo = DozerConverter.parseObject(repository.save(entity), BooksVO.class);
        return vo;
    }

    public List<BooksVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), BooksVO.class);
    }

    public BooksVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, BooksVO.class);
    }

    public BooksVO update(BooksVO books) {
        var entity = repository.findById(books.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(books.getAuthor());
        entity.setLaunchDate(books.getLaunchDate());
        entity.setPrice(books.getPrice());
        entity.setTitle(books.getTitle());

        var vo = DozerConverter.parseObject(repository.save(entity), BooksVO.class);
        return vo;
    }

    public void delete(Long id) {
        Books entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
