package com.bookmanager.ws.ui.controlers;

//requests

//Class
import com.bookmanager.ws.ui.model.response.Book;
import com.bookmanager.ws.i.model.request.BookDetailRequestModel;

//web
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Essa classe seja capaz de receber requisições HTTP e enviar resposta a aplicação cliente
@RestController 
//Fazer mapeamento da URL chamada na requisição e o método implementado no controlador
@RequestMapping("books") // http://localh'ost:8080/books 
public class BoockControler{
	
	@GetMapping
	public String getBooks(@RequestParam(value="page", defaultValue = "1")int page, 
						   @RequestParam(value="limit", defaultValue = "50") int limit,
						   @RequestParam(value="sort", defaultValue="desc", required = false) String sort //required define se a variável é opcional
						   )
	{
		//Esse método retorna a lista de livros cadastrados
		return "Retorna a lista de livros page = "+page+" Limite = "+limit + " sort = " + sort;
	}//end GetBooks
	
	@GetMapping(path = "/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn){
		//Esse método retorna dados de um livro
		Book book = new Book();
		book.setTitle("Clean Code");
		book.setAuthor("Robert C. Martin");
		book.setImageUrl("http://localhost/image");
		
		//ResponseEntity da a possibilidade de retornar o html, manioulando cabeçarios, corpo da menssagem e o código http
		return new ResponseEntity<Book>(book, HttpStatus.OK);// Através do httpStatus podemos manipular os retornos de acordo com cada status
	}//end getBook
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody BookDetailRequestModel bookDetail ){
		//Esse método retorna a criação de um book
		Book book = new Book();
		book.setTitle(bookDetail.getTitle());
		book.setAuthor(bookDetail.getAuthor());
		book.setImageUrl(bookDetail.getImageUrl());
		book.setIsbn(bookDetail.getIsbn());
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}//end createBook
	@PutMapping
	public String updateBook(){
		return "Retorna as informações e um determinada livro";
	}//end updateBook
	@DeleteMapping
	public String deleteBook() {
		return "Deleta um livro";
	}//end deleteBook
}