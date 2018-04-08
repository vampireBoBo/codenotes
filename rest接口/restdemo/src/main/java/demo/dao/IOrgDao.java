package demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import demo.entity.Org;
/**
 * mybatis中使用的dao的接口名称与mapper.xml文件中的查询语句id一一对应 故不需要dao层的实现类
 * 参照开发alibaba开发规范手册  在接口中不出现public等修饰符  也尽量不要出现变量
 *--------------------------------------------------------------<br>
 * V1.0 创建  Administrator 2018年4月3日  新项目<br>
 *--------------------------------------------------------------<br>
 */
@Repository("orgDao")
public interface IOrgDao {
	
    int deleteByPrimaryKey(String ono);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(String ono);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
    
    List<Org> selectAll();
}