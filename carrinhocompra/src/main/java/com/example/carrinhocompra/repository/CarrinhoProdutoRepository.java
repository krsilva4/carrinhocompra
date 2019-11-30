package com.example.carrinhocompra.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carrinhocompra.entity.CarrinhoProduto;
@Repository
public interface CarrinhoProdutoRepository extends JpaRepository<CarrinhoProduto, Long> { }
