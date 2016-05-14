package com.dianzishangwu.yihunli.domain.article;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE;


@Entity
@Table(name="article_info")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Article  implements Serializable
{
	@Id
	@Column(name="article_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer id;
	
     public void setId(Integer id) {
		this.id = id;
	}

	private String  name;
     private String orignprice;
     
    public String getOrignprice() {
		return orignprice;
	}

	public void setOrignprice(String orignprice) {
		this.orignprice = orignprice;
	}

	/*    
     private String author;
     
     public String getAuthor() {
		return author;
	} 
	public void setAuthor(String author) {
		this.author = author;
	}
*/
	@Column(nullable=false)
     private String userEntityId;
     
     @Temporal(TemporalType.DATE)
     private Date date;
     
     @Temporal(TemporalType.TIMESTAMP)
     private Date time;
     
     private String title;
     public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	 private String price;
     private String province;
     private String city;
     private String district;
     private String detailAddress;
     

	public String getDetailAddress() {
		return detailAddress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Enumerated(EnumType.ORDINAL)
     @Column(name="wed_type")     
     private WEDDTYPE type;
     
     private String text;
     
     public String getUserEntityId() {
		return userEntityId;
	}

	public void setUserEntityId(String userEntityId ) {
		this.userEntityId = userEntityId;
	}
	
	private String coverfile;

	public String getCoverfile() {
		return coverfile;
	}

	public void setCoverfile(String coverfile) {
		this.coverfile = coverfile;
	}

	private String thumbnailCoverfile;
	
	public String getThumbnailCoverfile() {
		return thumbnailCoverfile;
	}

	public void setThumbnailCoverfile(String thumbnailCoverfile) {
		this.thumbnailCoverfile = thumbnailCoverfile;
	}

	private String describtion;

     @Enumerated(EnumType.ORDINAL)
     @Column(name="area")
     private Area area;
     
     @	ElementCollection(targetClass=Resource.class)
     @CollectionTable(name="resource_info",
     joinColumns=@JoinColumn(name="article_id",nullable=false))
     @OrderColumn(name="list_inf")
     List<Resource> resources = new LinkedList<Resource>();

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public void addResource(Resource resource){
		resources.add(resource);
	}
	
	public enum Area{
    	 Normal,LUXURY,GREETING;
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public WEDDTYPE getType() {
		return type;
	}

	public void setType(WEDDTYPE type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getId() {
		return id;
	}
	
    public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}  
     
	public String toString(){
		return this.getClass().getName() + id;
	}
}
