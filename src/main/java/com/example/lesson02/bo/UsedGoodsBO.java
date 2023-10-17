package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service	// spring bean
public class UsedGoodsBO {
	
	
	@Autowired		// spring bean(객체) 가져오는 것 - DI (Dependency Injection)
	private UsedGoodsMapper usedGoodsMapper;
	
	
	// input (controller로 부터 요청 받음) : 파라미터 X
	// output (controller한테 돌려줌) : List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		
		return usedGoodsMapper.selectUsedGoodsList();
		
	}

}
