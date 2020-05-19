package com.api.restapi.Goods;

import com.api.restapi.Goods.GoodsDto.GoodsInfo;
import java.util.List;

public interface GoodsRepositoryCustom {
	List<GoodsInfo> getGoodsList();
}
