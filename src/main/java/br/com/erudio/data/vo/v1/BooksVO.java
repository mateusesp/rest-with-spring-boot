package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BooksVO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BooksVO booksVO = (BooksVO) o;
        return Objects.equals(key, booksVO.key) && Objects.equals(author, booksVO.author) && Objects.equals(launchDate, booksVO.launchDate) && Objects.equals(price, booksVO.price) && Objects.equals(title, booksVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, author, launchDate, price, title);
    }
}
