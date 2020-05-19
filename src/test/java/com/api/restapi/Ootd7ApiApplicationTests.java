package com.api.restapi;

import com.api.restapi.Goods.Goods;
import com.api.restapi.Goods.QGoods;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ootd7ApiApplicationTests {

	@Autowired
	private EntityManager em;
	private JPAQueryFactory queryFactory;

	@Test
	public void getList() {
		queryFactory = new JPAQueryFactory(em);

		List<Goods> goodsList = queryFactory
			.select(QGoods.goods)
			.from(QGoods.goods)
			.where(QGoods.goods.citStatus.eq(1))
			.fetch();

		goodsList.forEach(goods -> {
			System.out.println("citName :; " + goods.getCitName());
		});
	}

}
