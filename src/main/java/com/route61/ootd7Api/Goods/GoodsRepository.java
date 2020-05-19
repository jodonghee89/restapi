package com.route61.ootd7Api.Goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long>, GoodsRepositoryCustom {

}
