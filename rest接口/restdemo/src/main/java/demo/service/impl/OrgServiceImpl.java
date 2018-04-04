package demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.IOrgDao;
import demo.entity.Org;
import demo.service.IOrgService;

@Service("orgSer")
public class OrgServiceImpl implements IOrgService {
	
	@Autowired
	private IOrgDao orgDao;
	
	@Override
	public int deleteByPrimaryKey(String ono) {
		return orgDao.deleteByPrimaryKey(ono);
	}

	@Override
	public int insert(Org record) {
		return orgDao.insert(record);
	}

	@Override
	public int insertSelective(Org record) {
		return orgDao.insertSelective(record);
	}

	@Override
	public Org selectByPrimaryKey(String ono) {
		return orgDao.selectByPrimaryKey(ono);
	}

	@Override
	public int updateByPrimaryKeySelective(Org record) {
		return orgDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Org record) {
		return orgDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Org> selectAll() {
		return orgDao.selectAll();
	}

}
