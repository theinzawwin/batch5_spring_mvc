package com.best.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.best.spring.dao.ItemDao;
import com.best.spring.model.Item;

@Controller
public class ItemController {

	@Autowired
	private ItemDao itemDao;
	@RequestMapping(value="/index.htm",method = RequestMethod.GET)
	public String itemList(Model model) {
		model.addAttribute("name", "Kaung Myat Htut");
		return "index";
	}
	@RequestMapping(value="/new_item.htm")
	public String new_item(Model model) {
		Item i=new Item();
		i.setName("Item 10");
		i.setColor("Blue");
		model.addAttribute("item", i);
		model.addAttribute("colorList", getColorList());
		model.addAttribute("inventoryList", getInventoryList());
		return "new_item";
	}
	@RequestMapping(value="/new_item.htm",method = RequestMethod.POST)
	public String post_item(@ModelAttribute(value="item")Item item,Model model) {
		itemDao.saveItem(item);
		model.addAttribute("item", item);
		return "success_item";
	}
	@RequestMapping(value="/item_list.htm")
	public String item_list(Model model) {
	model.addAttribute("itemList", itemDao.getAllItemList());
		return "item_list";
	}
	@RequestMapping(value="/item_edit.htm/{id}")
	public String item_edit(@PathVariable Long id) {
		
		return "item_edit";
	}
	private List<String> getColorList(){
		List<String> colors=List.of("White","Red","Blue","Gray");
		return colors;
	}
	private List<String> getInventoryList(){
		return List.of("Inventory","Non-Inventory");
	}
}
