package com.cc.member.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.member.dto.Member;
import com.cc.member.service.MemberService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("member")
public class MemberController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 查询所有用户信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject query() throws Exception {
		
		return new JsonData(this.memberService.query());
	}
	
	/**
	 * 新增用户
	 * TODO 仅限管理员使用该接口
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject add(@Validated Member member) throws Exception {
		member.setRegisterTime(new Date());
		this.memberService.add(member);
		return new JsonData(member);
	}
	
	/**
	 * 用户充值
	 * @param member
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject recharge(@RequestParam(value = "id") Long id,@RequestParam(value = "amount") Double amount) throws Exception {
		Member member = this.memberService.getById(id);
		if(member == null){
			throw new Exception("用户信息有误，请重试");
		}
		member.setAmount(member.getAmount() + amount);
		this.memberService.edit(member);
		return new JsonData(member);
	}
	
	/**
	 * 密码重置
	 * @param member
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject reset(@RequestParam(value = "id") Long id) throws Exception {
		Member member = this.memberService.getById(id);
		if(member == null){
			throw new Exception("用户信息有误，请重试");
		}
		member.setPassword(member.getCellPhone());
		this.memberService.edit(member);
		return new JsonData(member);
	}
	
	/**
	 * 用户提现
	 * @param member
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/withdrawals", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject withdrawals(@RequestParam(value = "id") Long id,@RequestParam(value = "amount") Double amount) throws Exception {
		Member member = this.memberService.getById(id);
		if(member == null){
			throw new Exception("用户信息有误，请重试");
		}
		if(member.getAmount() < amount){
			throw new Exception("提现金额有误，请重试");
		}
		member.setAmount(member.getAmount() - amount);
		this.memberService.edit(member);
		return new JsonData(member);
	}
	
	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject regist(@Validated Member member) throws Exception {
		member.setRegisterTime(new Date());
		member.setAmount(0);
		this.memberService.add(member);
		return new JsonData(member);
	}
	
	
	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject login(HttpServletRequest request,@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) throws Exception {
		Member member = this.memberService.getByName(username);
		if(member == null){
			member = this.memberService.getByPhone(username);
		}
		if(member == null || !member.getPassword().equals(password)){
			throw new Exception("用户名或密码有误，请重试");
		}
		request.getSession().setAttribute("memberId", member.getId());
		request.getSession().setAttribute("username", member.getUsername());
		request.getSession().setAttribute("cellphone", member.getCellPhone());
		return new JsonData(member);
	}
	
	
	/**
	 * 编辑用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject edit(@Validated Member member) throws Exception {
		Member user = this.memberService.getById(member.getId());
		if(user == null){
			throw new Exception("用户信息有误，请重试");
		}
		member.setAmount(user.getAmount());
		this.memberService.edit(member);
		return new JsonData(member);
	}
	
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject delete(@RequestParam(value = "id") Long id) throws Exception {
		Member member = this.memberService.getById(id);
		if(member == null){
			throw new Exception("用户信息有误，请重试");
		}
		this.memberService.delete(id);
		return new JsonSuccess();
	}

}






