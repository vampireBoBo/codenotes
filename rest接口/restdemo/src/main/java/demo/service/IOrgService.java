package demo.service;

import java.util.List;

import demo.entity.Org;

public interface IOrgService {
	int deleteByPrimaryKey(String ono);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(String ono);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
    
    List<Org> selectAll();
}
