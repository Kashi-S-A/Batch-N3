package com.tyss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.dao.ProductDAO;
import com.tyss.dto.ProductDTO;
import com.tyss.model.Product;
import com.tyss.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductDAO productDAO;

	@Override
	public ResponseEntity<String> save(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		Product savedProduct = productRepository.save(product);

//		ResponseEntity<String> re = new ResponseEntity<String>(
//				"Product is saved with Id : " + savedProduct.getPid(),
//				HttpStatus.CREATED);

		return ResponseEntity.status(HttpStatus.CREATED).body("Product is saved with Id : " + savedProduct.getPid());
	}

	@Override
	public ResponseEntity<?> findById(Integer pid) {
		Optional<Product> opt = productRepository.findById(pid);

//		if (opt.isPresent()) {
//			return opt.get();
//		}

//		Product product = opt.orElseThrow(() -> new RuntimeException("Product not found"));
		if (opt.isPresent()) {
			return new ResponseEntity<Product>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Product not found", HttpStatus.NOT_FOUND);
		}
	}

	// pagination
	@Override
	public List<Product> findAll(Integer page) {

		Pageable pageable = PageRequest.of(page - 1, 10);

		Page<Product> pages = productRepository.findAll(pageable);

		return pages.toList();
	}

	// sorting
	@Override
	public List<Product> sortProducts(String property, String order) {
		if (order.equals("desc"))
			return productRepository.findAll(Sort.by(property).descending());
		else
			return productRepository.findAll(Sort.by(property).ascending());
	}

	// filter
	@Override
	public List<Product> filterProducts(ProductDTO productDTO) {

		Product product = new Product();

		BeanUtils.copyProperties(productDTO, product);

		Example<Product> of = Example.of(product);

		return productRepository.findAll(of);
	}

	@Override
	public ResponseEntity<String> deleteById(Integer pid) {
		if (productRepository.findById(pid).isPresent()) {
			productRepository.deleteById(pid);
			return ResponseEntity.ok("Deleted Successfully");
		} else {
			return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String updateProduct(Integer pid, ProductDTO ProductDto) {
		return productDAO.updateProduct(pid, ProductDto);
	}

	@Override
	public String updatePrice(Integer pid, Double price) {
		return productDAO.updatePrice(pid, price);
	}

	@Override
	public ResponseEntity<List<Product>> getByNameContaining(String name) {
		List<Product> products = productRepository.findByNameContainingAllIgnoringCase(name);
		return ResponseEntity.ok().body(products);
	}

}
