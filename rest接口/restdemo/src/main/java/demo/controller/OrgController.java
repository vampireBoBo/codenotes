package demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import demo.entity.Org;
import demo.service.IOrgService;

/**
 * org资源的controller
 * 该类 没有返回视图  故使用了@RestController  只进行数据的获取
 */
@RestController
@RequestMapping("org")
public class OrgController {
	
	@Autowired
	private IOrgService orgSer;
	/**
	 * 
	 * @Description: 
	 * 	新增组织
	 *  produces = "application/json"：指定数据返回格式
	 *  charset:指定返回数据的编码方式 
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String addOrg(Org record){
		Map<String, String> result=new HashMap<String,String>();
		try {
			if(orgSer.insert(record)>0){
				result.put("result", "新增成功！");
			}else{
				result.replace("result", "新增失败！");
			}
		} catch (Exception e) {
			result.replace("result", "请求异常！");
		}
		JSON json=(JSON) JSON.toJSON(result);
		return json.toString();
	}
	/**
	 * 
	 * @Description: 方法说明
	 * 根据主键查看组织信息
	 * @param ono
	 * @return
	 */
	@RequestMapping(value="/{ono}",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	public @ResponseBody Org getOrgById(@PathVariable String ono){
		return orgSer.selectByPrimaryKey(ono);
	}
	/**
	 * 
	 * @Description: 方法说明
	 * 查看组织资源列表信息
	 * @return List<Org> 
	 */
	@RequestMapping(value="/",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String getOrgAll(){
		Map<String, List<Org>> maps=new HashMap<>();
		List<Org> lists=orgSer.selectAll();
		maps.put("orgLists", lists);
		JSON json=(JSON)JSON.toJSON(maps);
		return json.toString();
	}
	/**
	 * 
	 * @Description: 方法说明
	 * 根据ono删除org实体
	 * @param ono
	 * @return
	 */
	@RequestMapping(value="/{ono}",method=RequestMethod.DELETE)
	public String deleteOrg(@PathVariable String ono){
		return orgSer.deleteByPrimaryKey(ono)>0?"delete success!":"delete fail!";
	}
	/**
	 * 
	 * @Description: 方法说明
	 * 更新组织信息 并返回更新后的结果
	 * @param recode
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT,produces="application/json;charset=utf-8")
	public @ResponseBody Org updateOrg(@RequestBody Org recode){
		orgSer.updateByPrimaryKey(recode);
		return orgSer.selectByPrimaryKey(recode.getOno());
	}
}
