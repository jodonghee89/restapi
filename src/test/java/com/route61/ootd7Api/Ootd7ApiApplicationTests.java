package com.route61.ootd7Api;

import static com.route61.ootd7Api.Goods.QGoods.goods;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.route61.ootd7Api.Goods.Goods;
import com.route61.ootd7Api.Goods.GoodsDto;
import com.route61.ootd7Api.Goods.GoodsDto.GoodsInfo;
import com.route61.ootd7Api.Goods.QGoods;
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
			.select(goods)
			.from(goods)
			.where(goods.citStatus.eq(1))
			.fetch();

		goodsList.forEach(goods -> {
			System.out.println("citName :; " + goods.getCitName());
		});
	}

}
