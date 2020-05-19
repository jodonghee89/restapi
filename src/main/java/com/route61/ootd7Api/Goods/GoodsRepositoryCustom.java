package com.route61.ootd7Api.Goods;

import com.route61.ootd7Api.Goods.GoodsDto.GoodsInfo;
import java.util.List;

public interface GoodsRepositoryCustom {
	List<GoodsInfo> getGoodsList();
}
