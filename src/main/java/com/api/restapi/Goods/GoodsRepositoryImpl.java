package com.api.restapi.Goods;

import static com.api.restapi.Goods.QGoods.*;

import com.api.restapi.Goods.GoodsDto.GoodsInfo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Transactional(readOnly = true)
	public List<GoodsInfo> getGoodsList () {
		List<GoodsInfo> resultList = queryFactory
			.select(Projections.fields(GoodsInfo.class,
				goods.citId,
				goods.citName,
				goods.citKey))
			.from(goods)
			.where(goods.citStatus.eq(1), goods.citId.gt(1900))
			.fetch();
		return resultList;
	}
}
