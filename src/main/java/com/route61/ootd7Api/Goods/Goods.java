package com.route61.ootd7Api.Goods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.jdo.annotations.Join;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Entity(name = "IAN_cmall_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@ToString(exclude = {})
public class Goods {

	@Id
	@GeneratedValue
	@Column(name = "cit_id")
	private long citId;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "spg_id")
//	private ShippingCost shippingCost;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "bra_id")
//	private Brand brand;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "mem_id")
//	private Member member;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "cbp_id")
//	private BuyPlace buyPlace;

	@Column(name = "cit_key")
	private int citKey;

	@Column(name = "cit_name")
	private String citName;

	@Column(name = "cit_name_eng")
	private String citNameEng;

	@Column(name = "cit_make_country")
	private String citMakeCountry;

	@Column(name = "cit_make_company")
	private String citMakeCompany;

	@Column(name = "cit_origin_country")
	private String citOriginCountry;

	@Column(name = "cit_material")
	private String citMaterial;

	@Column(name = "cit_make_date")
	private LocalDate citMakeDate;

	@Column(name = "cit_model")
	private String citModel;

	@Column(name = "cit_seller_email")
	private String citSellerEmail;

	@Column(name = "cit_shop_memo")
	private String citShopMemo;

	@Column(name = "cit_recommend_selling_price")
	private int citRecommendSellingPrice;

	@Column(name = "cit_min_price")
	private int citMinPrice;

	@Column(name = "cit_market_price")
	private int citMarketPrice;

	@Column(name = "cit_order")
	private int citOrder;

	@Column(name = "cit_type1")
	private int citType1;

	@Column(name = "cit_type2")
	private int citType2;

	@Column(name = "cit_type3")
	private int citType3;

	@Column(name = "cit_type4")
	private int citType4;

	@Column(name = "cit_status")
	private int citStatus;

	@Column(name = "cit_summary")
	private String citSummary;

	@Column(name = "cit_content")
	private String citContent;

	@Column(name = "cit_mobile_content")
	private String citMobileContent;

	@Column(name = "cit_content_html_type")
	private int citContentHtmlType;

	@Column(name = "cit_price")
	private int citPrice;

	@Column(name = "cit_file_1")
	private String citFile1;

	@Column(name = "cit_file_1_name")
	private String citFile1Name;

	@Column(name = "cit_file_2")
	private String citFile2;

	@Column(name = "cit_file_2_name")
	private String citFile2Name;

	@Column(name = "cit_file_3")
	private String citFile3;

	@Column(name = "cit_file_3_name")
	private String citFile3Name;

	@Column(name = "cit_file_4")
	private String citFile4;

	@Column(name = "cit_file_4_name")
	private String citFile4Name;

	@Column(name = "cit_file_5")
	private String citFile5;

	@Column(name = "cit_file_5_name")
	private String citFile5Name;

	@Column(name = "cit_hit")
	private int citHit;

	@Column(name = "cit_datetime")
	private LocalDateTime citDateTime;

	@Column(name = "cit_updated_datetime")
	private LocalDateTime citUpdatedDateTime;

	@Column(name = "cit_sell_count")
	private int citSellCount;

	@Column(name = "cit_wish_count")
	private int citWishCount;

	@Column(name = "cit_download_days")
	private int citDownloadDays;

	@Column(name = "cit_review_count")
	private int citReviewCount;

	@Column(name = "cit_review_average")
	private float citReviewAverage;

	@Column(name = "cit_qna_count")
	private int citQnaCount;

	@Column(name = "cit_out_of_stock")
	private byte citOutOfStock;

	@Column(name = "cit_stock_count")
	private int citStockCount;

	@Column(name = "cit_md")
	private byte citMd;

	@Column(name = "cit_self")
	private byte citSelf;

	@Column(name = "cit_besticon")
	private byte citBesticon;

	@Column(name = "cit_soshing_sort")
	private char citSoshingSort;

	@Column(name = "cit_size_kind")
	private char citSizeKind;

	@Column(name = "cit_process_status")
	private byte citProcessStatus;

	@Column(name = "cit_size_info")
	private String citSizeInfo;

	@Column(name = "cit_pit")
	private byte citPit;

	@Column(name = "cit_gloss")
	private byte citGloss;

	@Column(name = "cit_shine")
	private byte citShine;

	@Column(name = "cit_elasticity")
	private byte citElasticity;

	@Column(name = "cit_lining")
	private byte citLining;

	@Column(name = "cit_wire")
	private byte citWire;

	@Column(name = "cit_pad_width")
	private byte citPadWidth;

	@Column(name = "cit_pad_de_adhe")
	private byte citPadDeAdhe;

	@Column(name = "cit_manage_color_id")
	private int citManageColorId;

	@Column(name = "cit_high_item")
	private char citHighItem;

	@Column(name = "cit_middle_item")
	private char citMiddleIteme;

	@Column(name = "cit_top_desc")
	private String citTopDesc;

	@Column(name = "cit_bottom_desc")
	private String citBottomDesc;

	@Column(name = "cit_washing_method")
	private String citWashingMethod;

	@Column(name = "cit_gif")
	private String citGif;

	@Column(name = "cit_sale_reg_datetime")
	private LocalDateTime citSaleRegDateTime;

	@Column(name = "cit_delay_of_delivery_notice")
	private String citDelayOfDeliveryNotice;

	@Column(name = "cit_video_code")
	private String citVideoCode;

	@Column(name = "cit_imglabel")
	private byte citImgLabel;

	@Column(name = "cit_image_source")
	private char citImageSource;

	@Column(name = "cit_admin_memo")
	private String citAdminMemo;

	@Column(name = "rollorosa_goods")
	private int rollorosaGoods;

	@Column(name = "rollorosa_goods_comment")
	private String rollorosaGoodsComment;

	@Column(name = "rollorosa_goods_reg_date")
	private LocalDateTime rollorosaGoodsRegDate;

	private String keyword;

	@Column(name = "option_save_type")
	private short optionSaveType;

	@Column(name = "large_option_cnt")
	private short largeOptionCnt;

	@Column(name = "option_separator")
	private char ooptionSeparator;

	@Column(name = "option_order_type")
	private short optionOrderType;

	@Column(name = "option_plus_size_yn")
	private short optionPlusSizeYn;
}
