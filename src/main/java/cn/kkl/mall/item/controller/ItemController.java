package cn.kkl.mall.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kkl.mall.item.pojo.Item;
import cn.kkl.mall.pojo.TbItem;
import cn.kkl.mall.pojo.TbItemDesc;
import cn.kkl.mall.service.ItemDescService;
import cn.kkl.mall.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDescService itemDescService;
	
	@RequestMapping(value="/item/{itemId}")
	public String showItemDetail(@PathVariable Long itemId,Model model) {
		TbItem tbItem = itemService.getItemById(itemId);
		Item item=new Item(tbItem);
		TbItemDesc itemDesc = itemDescService.getItemDescById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);
		return "item";
	}
}
