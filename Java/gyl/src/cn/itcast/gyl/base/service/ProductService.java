package cn.itcast.gyl.base.service;

import cn.itcast.gyl.domain.base.Product;
import cn.itcast.gyl.query.PageResult;

public interface ProductService {
	public PageResult<Product> getProducts(); 
}
