package com.route61.ootd7Api.Goods;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class GoodsDto {

	@Data
	@ToString(exclude = {})
	public static class GoodsInfo {
		private long citId;
		private String citName;
		private int citKey;
	}
}
