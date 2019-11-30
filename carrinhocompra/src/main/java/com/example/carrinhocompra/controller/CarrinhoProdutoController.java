package com.example.carrinhocompra.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrinhocompra.entity.CarrinhoProduto;
import com.example.carrinhocompra.repository.CarrinhoProdutoRepository;

@RestController
public class CarrinhoProdutoController {
	 @Autowired
	    private CarrinhoProdutoRepository _carrinhoProdutoRepository;

	    @RequestMapping(value = "/carrinhoproduto", method = RequestMethod.GET)
	    public List<CarrinhoProduto> Get() {
	        return _carrinhoProdutoRepository.findAll();
	    }

	    @RequestMapping(value = "/carrinhoproduto/{id}", method = RequestMethod.GET)
	    public ResponseEntity<CarrinhoProduto> GetById(@PathVariable(value = "id") long id)
	    {
	        Optional<CarrinhoProduto> CarrinhoProduto = _carrinhoProdutoRepository.findById(id);
	        if(CarrinhoProduto.isPresent())
	            return new ResponseEntity<CarrinhoProduto>(CarrinhoProduto.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/carrinhoproduto", method =  RequestMethod.POST)
	    public CarrinhoProduto Post( @Valid @RequestBody CarrinhoProduto carrinhoProduto)
	    {
	        return _carrinhoProdutoRepository.save(carrinhoProduto);
	    }
	    @RequestMapping(value = "/carrinhoproduto/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<CarrinhoProduto> pessoa = _carrinhoProdutoRepository.findById(id);
	        if(pessoa.isPresent()){
	        	_carrinhoProdutoRepository.delete(pessoa.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
