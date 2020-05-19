package com.route61.ootd7Api.Goods;

import static com.route61.ootd7Api.Goods.GoodsDto.*;
import static org.springframework.http.MediaType.*;

import com.route61.ootd7Api.common.model.ApiResponseModel;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/goods", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GoodsController {

	private final GoodsRepository goodsRepository;

	@GetMapping("/getList")
	public ResponseEntity<ApiResponseModel<List<GoodsInfo>>> getList() {

		List<GoodsInfo> resultList = goodsRepository.getGoodsList();

		ApiResponseModel<List<GoodsInfo>> responseModel = new ApiResponseModel<>(resultList);

		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
}
