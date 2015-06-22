package com.twehs.action.classify;

import java.math.BigDecimal;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.ProductsService;
import com.twehs.service.classify.dto.ProductsDTO;
//import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.Page;

public class ProductsAction extends BaseAction {

	private Integer contentid;
	private Integer typeid;
	private String typename;
	private String title;
	private boolean toplline; // 为下传数据做的类型转换
	private String topline;

	private String source;
	private boolean recommendder;// 为下传数据做的类型转换
	private String recommender;
	private Date operatetime;
	private boolean displlay; // 为下传数据做的类型转换
	private String display;
	private String smallpicaddress;
	private String smallpicname;
	/*private String midpicaddress;
	//注意为了content重用，这里midpicaddress 是对应于content表中的smallpicname
	private String bigpicaddress;*/
	//注意这里和上面一样， bigpicaddress 是对应于表中的sourse列存储的；
	private String specification;
	private BigDecimal price;
	private String content;
	private Integer order;

	private ProductsService productsService;

	/*
	 * 
	 * 分页查询产品
	 */
	public String findPageProducts() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			productsService.findPageProducts(page, title, typeid);
			// 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除产品
	 */
	public String deleteProducts() {
		try {
			boolean b = productsService.deleteProducts(contentid);

			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该分类已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该分类已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 
	 * 保存和更新产品
	 */
	
	public String savebingoOrUpdateProducts() {
		
		try {
			// boolean 类型转换处：
			// 这里需要改变上面topline的类型为Integer ,然后自定义一个Boolean类型插入下面的构造函数
			int toplineint = Integer.parseInt(this.getTopline());
			// 从表现层向下层传输数据，从String类型转换成boolean类型，表现层传到下面是String类型数据
			if (toplineint == 1) {
				toplline = true;

			} else {
				toplline = false;
			}

			int recommenderint = Integer.parseInt(this.getRecommender());
			if (recommenderint == 1) {
				recommendder = true;

			} else {
				recommendder = false;
			}

			int displayint = Integer.parseInt(this.getDisplay());
			if (displayint == 1) {
				displlay = true;
			} else {
				displlay = false;
			}

			
			ProductsDTO dto = new ProductsDTO(contentid, typeid, typename,source,
					toplline, title, recommendder, operatetime, displlay,
					smallpicaddress, smallpicname, specification, price,
					content, order);

			productsService.saveOrUpdateProducts(dto);
			if (contentid == null) {
				this.outString("{success:true,message:'保存成功!'}");
			} else {
				this.outString("{success:true,message:'修改成功!'}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	
	
	
	/*
	 * 查询分类
	 */
	public String findTypeType() {
		try {

			this.outListString(productsService.findTypeType());
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}
	
	
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSmallpicname() {
		return smallpicname;
	}

	public void setSmallpicname(String smallpicname) {
		this.smallpicname = smallpicname;
	}

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getTopline() {
		return topline;
	}

	public void setTopline(String topline) {
		this.topline = topline;
	}


	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getSmallpicaddress() {
		return smallpicaddress;
	}

	public void setSmallpicaddress(String smallpicaddress) {
		this.smallpicaddress = smallpicaddress;
	}


	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public ProductsService getProductsService() {
		return productsService;
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

}
